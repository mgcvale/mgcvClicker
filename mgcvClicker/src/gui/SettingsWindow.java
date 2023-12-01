package gui;

import javax.swing.*;
import java.awt.*;
import Clicker.SettingsManager;

public class SettingsWindow extends JFrame{

    static SettingsManager localSettingsManager;

    static class MainPanel extends JPanel{
        JCheckBox CHK_waitBeforeStart = new JCheckBox();
        JCheckBox CHK_stopAfterClicks = new JCheckBox();
        JCheckBox CHK_stopAfterTime = new JCheckBox();
        JLabel L_waitBeforeStart = new JLabel("<html><p style=\"width:210; text-align:left\">"+"Wait before starting the Autoclicker"+"</p></html>");
        JLabel L_stopAfterClicks = new JLabel("<html><p stye= \"width:210; text-alignt:left\">"+"Stop after n clicks"+"</p></html");
        JLabel L_stopAfterTime = new JLabel("<html><p stye=\"width:210; text-alignt:left\">"+"Stop after n seconds"+"</p></html");
        JLabel JTFL_waitBeforeStart = new JLabel("<html><p style=\"width:84; text-align:left\">"+"milliseconds"+"</p></html>");
        JLabel JTFL_stopAfterClicks = new JLabel("<html><p style=\"width:84; text-align:left\">"+"clicks"+"</p></html>");
        JLabel JTFL_stopAfterTime = new JLabel("<html><p style=\"width:84; text-align:left\">"+"milliseconds"+"</p></html>");
        JTextField waitBeforeStart = new JTextField("0");
        JTextField stopAfterClicks = new JTextField("0");
        JTextField stopAfterTime = new JTextField("0");
        JButton apply = new JButton("Apply");
        JButton ok = new JButton("Ok");

        MainPanel(){
            setBounds(6, 6, 235, 320);
            CHK_waitBeforeStart.setBounds(30/4+6, 30/4 + 10, 20, 20);
            L_waitBeforeStart.setBounds(30/4+30, 30/4+8, 150, 40);
            waitBeforeStart.setBounds(30/4+12, 30/4+54, 100, 40);
            JTFL_waitBeforeStart.setBounds(30/4+120, 30/4+53, 84, 40);
            JTFL_waitBeforeStart.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
            waitBeforeStart.setEnabled(false);
            JTFL_waitBeforeStart.setEnabled(false);
            CHK_waitBeforeStart.addChangeListener(ChangeListener ->{
                if(CHK_waitBeforeStart.isSelected()){
                    waitBeforeStart.setEnabled(true);
                    JTFL_waitBeforeStart.setEnabled(true);
                }else{
                    waitBeforeStart.setEnabled(false);
                    JTFL_waitBeforeStart.setEnabled(false);
                }
            });

            CHK_stopAfterClicks.setBounds(30/4+6, 30/4+105, 20, 20);
            L_stopAfterClicks.setBounds(30/4+30, 30/4+104, 150, 20);
            stopAfterClicks.setBounds(30/4+12, 30/4+135, 100, 40);
            JTFL_stopAfterClicks.setBounds(30/4+120, 30/4+134, 84, 40);
            JTFL_stopAfterClicks.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
            stopAfterClicks.setEnabled(false);
            JTFL_stopAfterClicks.setEnabled(false);
            CHK_stopAfterClicks.addChangeListener(ChangeListener ->{
                if(CHK_stopAfterClicks.isSelected()){
                    stopAfterClicks.setEnabled(true);
                    JTFL_stopAfterClicks.setEnabled(true);
                }else{
                    stopAfterClicks.setEnabled(false);
                    JTFL_stopAfterClicks.setEnabled(false);
                }
            });

            CHK_stopAfterTime.setBounds(30/4+6, 30/4+185, 20, 20);
            L_stopAfterTime.setBounds(30/4+30, 30/4+184, 150, 20);
            stopAfterTime.setBounds(30/4+12, 30/4+215, 100, 40);
            JTFL_stopAfterTime.setBounds(30/4+120, 30/4+214, 84, 40);
            JTFL_stopAfterTime.setFont(new Font(Font.DIALOG, Font.PLAIN, 13));
            stopAfterTime.setEnabled(false);
            JTFL_stopAfterTime.setEnabled(false);
            CHK_stopAfterTime.addChangeListener(ChangeListener ->{
                if(CHK_stopAfterTime.isSelected()){
                    JTFL_stopAfterTime.setEnabled(true);
                    stopAfterTime.setEnabled(true);
                }else{
                    stopAfterTime.setEnabled(false);
                    JTFL_stopAfterTime.setEnabled(false);
                }
            });

            apply.setBounds(35, 273, 80, 30);
            ok.setBounds(125, 273, 80, 30);

            waitBeforeStart.setHorizontalAlignment(JTextField.CENTER);
            stopAfterClicks.setHorizontalAlignment(JTextField.CENTER);
            stopAfterTime.setHorizontalAlignment((JTextField.CENTER));

            //load current SettingsManager (local)
            CHK_stopAfterTime.setSelected(localSettingsManager.stopsAfterTime);
            CHK_stopAfterClicks.setSelected(localSettingsManager.stopsAfterClicks);
            CHK_waitBeforeStart.setSelected(localSettingsManager.waitsBeforeStart);
            waitBeforeStart.setText(String.valueOf(localSettingsManager.waitBeforeStart));
            stopAfterClicks.setText(String.valueOf(localSettingsManager.stopAfterClicks));
            stopAfterTime.setText(String.valueOf(localSettingsManager.stopAfterTime));

            apply.addActionListener(ActionListener ->{
                if(CHK_stopAfterTime.isSelected()){
                    localSettingsManager.setStopsAfterTime(true);
                    if(stopAfterTime.getText().isEmpty()){
                        localSettingsManager.setStopAfterTime(0);
                    }else if(Long.parseLong(stopAfterTime.getText())>0){
                        localSettingsManager.setStopAfterTime(Long.parseLong(stopAfterTime.getText()));
                    }else{
                        localSettingsManager.setStopAfterTime(0);
                    }
                }else{
                    localSettingsManager.setStopsAfterTime(false);
                }
                if(CHK_stopAfterClicks.isSelected()){
                    localSettingsManager.setStopsAfterClicks(true);
                    if(stopAfterClicks.getText().isEmpty()){
                        localSettingsManager.setStopAfterClicks(0);
                    } else if(Integer.parseInt(stopAfterClicks.getText())>0){
                        localSettingsManager.setStopAfterClicks(Integer.parseInt(stopAfterClicks.getText()));
                    }else{
                        localSettingsManager.setStopAfterClicks(0);
                    }
                }else{
                    localSettingsManager.setStopsAfterClicks(false);
                }
                if(CHK_waitBeforeStart.isSelected()){
                    localSettingsManager.setWaitsBeforeStart(true);
                    if(waitBeforeStart.getText().isEmpty() || Long.parseLong(waitBeforeStart.getText())<=0){
                        localSettingsManager.setWaitBeforeStart(0);
                    }else{
                        localSettingsManager.setWaitBeforeStart(Long.parseLong(waitBeforeStart.getText()));
                    }
                }else{
                    localSettingsManager.setWaitsBeforeStart(false);
                }
            });

            setLayout(null);
            add(ok);
            add(JTFL_stopAfterTime);
            add(L_stopAfterTime);
            add(stopAfterTime);
            add(CHK_stopAfterTime);
            add(JTFL_stopAfterClicks);
            add(stopAfterClicks);
            add(CHK_stopAfterClicks);
            add(L_stopAfterClicks);
            add(apply);
            add(JTFL_waitBeforeStart);
            add(waitBeforeStart);
            add(L_waitBeforeStart);
            add(CHK_waitBeforeStart);
            setVisible(true);
            setBorder(new RoundPanelBorder(30));
        }
    }

    public SettingsWindow(String name, SettingsManager sm){
        localSettingsManager=sm;
        MainPanel mainPanel = new MainPanel();
        mainPanel.ok.addActionListener(ActionListener -> setVisible(false));
        setAlwaysOnTop(true);
        setTitle(name);
        setSize(250, 375);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        add(mainPanel);
    }

    public static void setLocalSettingsManager(SettingsManager localSettingsManager) {
        SettingsWindow.localSettingsManager = localSettingsManager;
    }
    public static SettingsManager getLocalSettingsManager() {
        return localSettingsManager;
    }
}
