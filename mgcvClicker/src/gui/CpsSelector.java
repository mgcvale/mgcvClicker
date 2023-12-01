package gui;

import javax.swing.*;
import java.awt.*;

public class CpsSelector extends JPanel{
    JTextField CPS = new JTextField("0");
    JTextField holdTime = new JTextField("0");
    final JLabel L_CPS = new JLabel("CPS: ");
    final JLabel L_holdTime = new JLabel("Hold time (ms): ");
    JLabel errLabel = new JLabel("", SwingConstants.CENTER);
    JButton applyB = new JButton("Apply");
    final int radius = 30;

    public CpsSelector() {
        applyB.setBounds(radius/4+85, radius/4+90, 100, 40);
        L_CPS.setBounds(radius/4+12, radius/4+8, 120, 20);
        L_holdTime.setBounds(radius/4+142, radius/4+8, 120, 20);
        errLabel.setBounds(45, radius/4+140, 200, 50);
        CPS.setBounds(radius/4+10, radius/4+30, 120, 50);
        holdTime.setBounds(radius/4+140, radius/4+30, 120, 50);
        errLabel.setBounds(radius/4+30, radius/4+135, 210, 45);

        CPS.setMargin(new Insets(5, 10, 5, 10));
        CPS.setHorizontalAlignment(JTextField.CENTER);
        CPS.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

        holdTime.setMargin(new Insets(5, 10, 5, 10));
        holdTime.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        holdTime.setHorizontalAlignment(JTextField.CENTER);

        applyB.setMargin(new Insets(5, 5, 5, 5));
        applyB.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        add(CPS);
        add(holdTime);
        add(L_CPS);
        add(L_holdTime);
        add(applyB);
        add(errLabel);
    }
}


