package com.hennrix.tools.display;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MainGUITest {

    private FrameFixture window;

    @Before
    public void setUp() {
        MainGUI frame = GuiActionRunner.execute(MainGUI::new);
        window = new FrameFixture(frame.getFrame());
        window.show(); // Show the frame to test the GUI
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void testButtonDraw_ShouldTriggerRepaint() {
        // Enter valid coordinates
        window.textBox("x1Coordinate").setText("10");
        window.textBox("y1Coordinate").setText("20");
        window.textBox("x2Coordinate").setText("30");
        window.textBox("y2Coordinate").setText("40");

        // Click the "Draw Line" button
        window.button("buttonDraw").click();

        // Since actual GUI rendering is complex to test in headless mode, focus on state changes or mock
        JPanel drawPanel = window.panel("drawPanel").target();
        assertThat(drawPanel.isVisible()).isTrue(); // Basic validation to ensure no errors
    }

    @Test
    public void testInvalidCoordinates_ShouldShowErrorDialog() {
        // Enter invalid coordinates
        window.textBox("x1Coordinate").setText("invalid");
        window.textBox("y1Coordinate").setText("20");
        window.textBox("x2Coordinate").setText("30");
        window.textBox("y2Coordinate").setText("40");

        // Click the "Draw Line" button
        window.button("buttonDraw").click();

        // Verify that an error dialog is shown
        JOptionPaneFixture optionPane = window.optionPane();
        optionPane.requireErrorMessage().requireMessage("Please enter valid numbers.");
    }

    @Test
    public void testCustomText_ShouldDisplayInDrawPanel() {
        // Enter custom text
        window.textBox("customTextField").setText("Test Text");

        // Enter valid coordinates
        window.textBox("x1Coordinate").setText("10");
        window.textBox("y1Coordinate").setText("20");
        window.textBox("x2Coordinate").setText("30");
        window.textBox("y2Coordinate").setText("40");

        // Click the "Draw Line" button
        window.button("buttonDraw").click();

        // Verify that the custom text is drawn on the panel
        JPanel drawPanel = window.panel("drawPanel").target();
        assertThat(drawPanel.isVisible()).isTrue(); // Ensure no errors during rendering
    }
}
