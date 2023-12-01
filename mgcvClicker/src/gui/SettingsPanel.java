package gui;
import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    JTextField actionKey = new JTextField("Left click");
    final JLabel L_actionKey = new JLabel("Action key: ");
    JTextField triggerKey = new JTextField("G");
    final JLabel L_triggerKey = new JLabel("Trigger key: ");
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JCheckBox CHK_overlay = new JCheckBox("Overlay");
    JComboBox<String> triggerKeyModifier = new JComboBox<>();
    final int radius = 30;

    public SettingsPanel(){
        L_actionKey.setBounds(radius/4+14, radius/4+8, 140, 20);
        L_triggerKey.setBounds(radius/4+14, radius/4+86, 140, 20);
        actionKey.setBounds(radius/4+10, radius/4+30, 140, 50);
        triggerKey.setBounds(radius/4+10, radius/4+110, 140, 50);
        startButton.setBounds(radius/4+160, radius/4+20, 90, 50);
        stopButton.setBounds(radius/4+160, radius/4+20, 90, 50);
        CHK_overlay.setBounds(radius/4+164, radius/4+70, 140, 50);
        triggerKeyModifier.setBounds(radius/4+160, radius/4+125, 100, 25);

        actionKey.setMargin(new Insets(5, 5, 5, 5));
        actionKey.setHorizontalAlignment(JTextField.CENTER);
        actionKey.setFont(new Font(Font.DIALOG, Font.PLAIN, 17));
        actionKey.setEditable(false);

        CHK_overlay.setSelected(true);
        CHK_overlay.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        triggerKeyModifier.addItem("<no modifier>");
        triggerKeyModifier.addItem("<Ctrl>");
        triggerKeyModifier.addItem("<alt>");
        triggerKeyModifier.addItem("<shift>");
        triggerKeyModifier.addItem("<Ctrl+shift>");
        triggerKeyModifier.addItem("<Ctrl+alt>");

        triggerKey.setMargin(new Insets(5, 5, 5, 5));
        triggerKey.setHorizontalAlignment(JTextField.CENTER);
        triggerKey.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        triggerKey.setEditable(false);

        startButton.setMargin(new Insets(5, 5, 5, 5));
        startButton.setHorizontalAlignment(JButton.CENTER);
        startButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        stopButton.setMargin(new Insets(5, 5, 5, 5));
        stopButton.setHorizontalAlignment(JButton.CENTER);
        stopButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        stopButton.setVisible(false);
        stopButton.setEnabled(false);

        add(triggerKeyModifier);
        add(CHK_overlay);
        add(stopButton);
        add(startButton);
        add(L_actionKey);
        add(L_triggerKey);
        add(actionKey);
        add(triggerKey);
    }

}
