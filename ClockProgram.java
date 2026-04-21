//4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
//is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
//implementing the event handling mechanism with addActionListener( ).

package LAB4C;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClockProgram extends JFrame implements ActionListener {

    private JButton digitalClockButton;
    private JButton hourGlassButton;
    private JLabel messageLabel;

    public ClockProgram() {
        setTitle("Button Image Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Load images (replace with actual image paths in your project)
        ImageIcon digitalClockIcon = new ImageIcon("C:\\Users\\ADITH RAI\\Downloads/digitalclock.jpg");
        ImageIcon hourGlassIcon = new ImageIcon("C:\\Users\\ADITH RAI\\Downloads/hourglass.jpg");

        // Create buttons with images
        digitalClockButton = new JButton("Digital Clock", digitalClockIcon);
        hourGlassButton = new JButton("Hour Glass", hourGlassIcon);

        // Add ActionListeners
        digitalClockButton.addActionListener(this);
        hourGlassButton.addActionListener(this);

        // Label to display messages
        messageLabel = new JLabel("Press a button...");

        // Add components to frame
        add(digitalClockButton);
        add(hourGlassButton);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalClockButton) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == hourGlassButton) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ClockProgram();
    }
}