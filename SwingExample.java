//4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing Programming
//in Blue color plain font with font size of 32 using Jframe and Jlabel

package LAB4A;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;   // includes JFrame, JLabel, SwingUtilities

public class SwingExample {

    SwingExample() {
        // Create JFrame
        JFrame jfrm = new JFrame("A Simple Swing Application");

        // Set size
        jfrm.setSize(500, 200);

        // Close operation
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JLabel
        JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming!");

        // Set font and color
        jlab.setFont(new Font("Verdana", Font.PLAIN, 18));
        jlab.setForeground(Color.BLUE);

        // Center text
        jlab.setHorizontalAlignment(JLabel.CENTER);

        // Add label to frame
        jfrm.add(jlab);

        // Make frame visible
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {

        // Run on Event Dispatch Thread (Best Practice)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExample();
            }
        });

        // 👉 If SwingUtilities still gives error, use this instead:
        // new SwingExample();
    }
}