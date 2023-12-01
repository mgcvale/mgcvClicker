package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Clicker.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.github.kwhat.jnativehook.GlobalScreen;
import GlobalKeyListener.GlobalKeyListener;
import com.github.kwhat.jnativehook.NativeHookException;
import GlobalKeyListener.KeyEventConverter;


public class Window extends JFrame{
    SettingsManager sm = new SettingsManager();
    public boolean stopRequested=false;
    FlatMacDarkLaf darkTheme = new FlatMacDarkLaf();

    private void enableAc(){
        if(sm.waitsBeforeStart) {
            try {
                Thread.sleep(sm.waitBeforeStart);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis();
                int i=0;
                Robot rob = new Robot();
                while (!stopRequested) {
                    rob.mousePress(sm.mouseButton);
                    Thread.sleep(sm.holdTime);
                    rob.mouseRelease(sm.mouseButton);
                    Thread.sleep((long) Math.abs(1000/sm.CPS));
                    if(sm.stopsAfterClicks) {
                        if (i > sm.stopAfterClicks) {
                            stopRequested = true;
                        }
                    }
                    if(sm.stopsAfterTime){
                        if(System.currentTimeMillis()-startTime > sm.stopAfterTime){
                            stopRequested=true;
                        }
                    }
                    i++;
                }
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public Window(){
        try{
            UIManager.setLookAndFeel(darkTheme);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JButton settings = new JButton("Settings");
        CpsSelector cpsSelector = new CpsSelector();
        SettingsPanel settingsPanel = new SettingsPanel();
        KeyEventConverter keyEventConverter = new KeyEventConverter();
        SettingsWindow settingsWindow =new SettingsWindow("Settings", sm);
        settingsWindow.setVisible(false);
        //create and setup combo box to change look and feel
        JComboBox<String> LAFChanger = new JComboBox<>();
        LAFChanger.setBounds(20, 385, 120, 40);
        settings.setBounds(155, 385, 120, 40);
        LAFChanger.addItem("Dark Theme");

        //nativehook stuff
        try {
            GlobalScreen.registerNativeHook();
        }catch(NativeHookException nativeHookException){
            nativeHookException.printStackTrace();
        }

        //settingsWindow stuff
        settings.addActionListener(ActionListener ->{
            settingsWindow.setVisible(true);
            SettingsWindow.setLocalSettingsManager(sm);
        });

        //cpsSelector panel stuff
        cpsSelector.setBorder(new RoundPanelBorder(30));
        cpsSelector.setBounds(cpsSelector.radius/4, cpsSelector.radius/4, 280, 200);
        cpsSelector.holdTime.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){ cpsSelector.holdTime.setText(""); }
            @Override
            public void focusLost(FocusEvent e){}
        });
        cpsSelector.CPS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                cpsSelector.CPS.setText("");
            }
            @Override
            public void focusLost(FocusEvent focusEvent) {}
        });
        cpsSelector.applyB.addActionListener(ActionEvent -> {
            cpsSelector.errLabel.setText("");
            if (cpsSelector.CPS.getText().isEmpty() || cpsSelector.holdTime.getText().isEmpty()){
                cpsSelector.errLabel.setText("<html><p style=\"width:210; text-align:center\">"+"Please input numbers into both areas."+"</p></html>");
                cpsSelector.CPS.setText("0");
                cpsSelector.holdTime.setText("0");
                return;
            }
            try {
                if(Double.parseDouble(cpsSelector.CPS.getText())>0 && Long.parseLong(cpsSelector.holdTime.getText())>0){
                    sm.setCPS(Double.parseDouble(cpsSelector.CPS.getText()));
                    sm.setHoldTime(Long.parseLong(cpsSelector.holdTime.getText()));
                } else{
                    cpsSelector.errLabel.setText("<html><p style=\"width:210; text-align:center\">"+"Please verify that you haven't typed any negative number."+"</p></html>");
                }
            } catch(NumberFormatException nfe){
                cpsSelector.errLabel.setText("<html><p style=\"width:210; text-align:center\">"+"Verify that the numbers entered are in correct format."+"</p></html>");
            }
            cpsSelector.CPS.setText("0");
            cpsSelector.holdTime.setText("0");
        });
        cpsSelector.setLayout(null);

        //SettingsPanel panel stuff
        settingsPanel.setBorder(new RoundPanelBorder(30));
        settingsPanel.setBounds(settingsPanel.radius/4, settingsPanel.radius/4+195, 280, 185);
        settingsPanel.setLayout(null);
        //add the start button mnemonic
        GlobalKeyListener startButtonKeyListener = new GlobalKeyListener(settingsPanel.startButton, sm);
        GlobalKeyListener stopButtonKeyListener = new GlobalKeyListener(settingsPanel.stopButton, sm);
        stopButtonKeyListener.setKeyBind(-1);
        GlobalScreen.addNativeKeyListener(startButtonKeyListener);
        GlobalScreen.addNativeKeyListener(stopButtonKeyListener);
        //add the start/stop button actions
        settingsPanel.startButton.addActionListener(ActionEvent ->{
            sm = SettingsWindow.getLocalSettingsManager();
            System.out.println("current stop after clicks: " + sm.stopAfterClicks + "Does stop after clicks: " + sm.stopsAfterClicks);
            startButtonKeyListener.setKeyBind(-1);
            stopButtonKeyListener.setKeyBind(sm.getKeyBind());
            settingsPanel.stopButton.setVisible(true);
            settingsPanel.stopButton.setEnabled(true);
            settingsPanel.startButton.setMnemonic(0);
            settingsPanel.startButton.setVisible(false);
            settingsPanel.startButton.setEnabled(false);
            settingsPanel.stopButton.requestFocus();
            stopRequested = false;
            enableAc();
        });
        settingsPanel.stopButton.addActionListener(ActionEvent ->{
            stopButtonKeyListener.setKeyBind(-1);
            startButtonKeyListener.setKeyBind(sm.getKeyBind());
            settingsPanel.startButton.setMnemonic(KeyEvent.VK_G);
            settingsPanel.startButton.setVisible(true);
            settingsPanel.startButton.setEnabled(true);
            settingsPanel.stopButton.setMnemonic(0);
            settingsPanel.stopButton.setVisible(false);
            settingsPanel.stopButton.setEnabled(false);
            settingsPanel.startButton.requestFocus();
            stopRequested=true;
        });
        settingsPanel.triggerKeyModifier.addItemListener(ItemListener ->{
            sm.ctrlModifier=false;
            sm.altModifier=false;
            sm.shiftModifier=false;
            sm.ctrlShiftModifier=false;
            sm.ctrlAltModifier=false;
            System.out.println("Something Changed: " + settingsPanel.triggerKeyModifier.getSelectedItem());
            switch(settingsPanel.triggerKeyModifier.getSelectedItem().toString()){
                case "<Ctrl>":
                    sm.ctrlModifier = true;
                    break;
                case "<shift>":
                    sm.shiftModifier=true;
                    break;
                case "<alt>":
                    sm.altModifier=true;
                    break;
                case "<Ctrl+shift>":
                    sm.ctrlShiftModifier = true;
                    break;
                case "<Ctrl+alt>":
                    sm.ctrlAltModifier = true;
                    break;
                default:
                    System.out.println("Invalid or empty modifier!");
            }
            stopButtonKeyListener.setSettingsmanager(sm);
            startButtonKeyListener.setSettingsmanager(sm);
        });

        //make the actionKey and triggerKey TextFields actually change the Buttons setMnemonics, as well as update their texts accordingly.
        settingsPanel.actionKey.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sm.mouseButton = e.getButton();
                System.out.println(e.getButton());
                switch(e.getButton()){
                    case MouseEvent.BUTTON1:
                        settingsPanel.actionKey.setText("Left click");
                        sm.mouseButton=MouseEvent.BUTTON1_DOWN_MASK;
                        break;
                    case MouseEvent.BUTTON3:
                        settingsPanel.actionKey.setText("Right click");
                        sm.mouseButton = MouseEvent.BUTTON3_DOWN_MASK;
                        break;
                    case MouseEvent.BUTTON2:
                        settingsPanel.actionKey.setText("Middle click");
                        sm.mouseButton = MouseEvent.BUTTON2_DOWN_MASK;
                        break;
                }
            }
        });
        settingsPanel.triggerKey.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                startButtonKeyListener.setKeyBind(keyEventConverter.convertKeyEvent(e.getKeyCode()));
                sm.setKeyBind(keyEventConverter.convertKeyEvent(e.getKeyCode()));
                settingsPanel.triggerKey.setText(keyText);
            }
        });

        //add the overlay checkBox stuff
        settingsPanel.CHK_overlay.addChangeListener(ChangeListener -> {
            if(settingsPanel.CHK_overlay.isSelected()){
                System.out.println("is selected!");
                this.setAlwaysOnTop(true);
                settingsWindow.setAlwaysOnTop(true);
            }else{
                System.out.println("Is not!");
                this.setAlwaysOnTop(false);
                settingsWindow.setAlwaysOnTop(false);
            }
        });

        setAlwaysOnTop(true);
        add(settings);
        setName("AutoClicker");
        add(settingsPanel);
        getContentPane().setBackground(Color.DARK_GRAY);
        add(LAFChanger);
        add(cpsSelector);
        setSize(300, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
}
