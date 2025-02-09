package ce201.src;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.YELLOW;

public class WelcomeScreen extends JPanel {

    static JTextField message;
    static JTextField title;
    static JPanel contentRestrictor;
    static JButton proceed;

    public WelcomeScreen() {

        // Basic characteristics and components defined.

        setLayout(MainFrame.standardLayout);

        title = new JTextField("UK Power Generation Viewer");
        message = new JTextField("Welcome! Instructions are provided in the menu bar.");
        proceed = new JButton("Proceed");
        proceed.setOpaque(true);

        ButtonHandler proceedAction = new ButtonHandler(2); // sends user to the next panel
        proceed.addActionListener(proceedAction);

        // Uses static fonts created in MainFrame and applied to the title and message.

        title.setFont(MainFrame.titleFont);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setEditable(false);
        title.setBorder(BorderFactory.createEmptyBorder());

        message.setFont(MainFrame.messageFont);
        message.setHorizontalAlignment(JTextField.CENTER);
        message.setEditable(false);
        message.setBorder(BorderFactory.createEmptyBorder());

        // This JPanel is used to space elements out; no real purpose at this point.

        contentRestrictor = new JPanel();

        // Adds all created components to the main JPanel

        add(title);
        add(message);
        add(contentRestrictor);
        add(proceed);

    }
}