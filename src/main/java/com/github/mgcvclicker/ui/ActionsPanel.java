package com.github.mgcvclicker.ui;

import com.github.mgcvclicker.ui.data.SettingsChangeListener;
import com.github.mgcvclicker.ui.data.SettingsManager;
import com.github.mgcvclicker.ui.util.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.GridBagConstraints.*;

public class ActionsPanel extends RoundedPanel {
    //ui elements
    private JTextField actionKeyTf, triggerKeyTf;
    private JButton startBtn;
    private JCheckBox overlayCHK;
    private JComboBox<String> modifiers;

    //backend fields
    private SettingsManager sm;
    private SettingsChangeListener smChangeListener;

    public ActionsPanel() {
        initComponents();
        layComponents();
        addListeners();
    }

    public void addSettingsChangeListener(SettingsChangeListener smChangeListener) {
        this.smChangeListener = smChangeListener;
    }

    public SettingsManager getSettingsManager() {
        return sm;
    }

    public void setSettingsManager(SettingsManager sm) {
        this.sm = sm;
    }

    private void initComponents() {
        //action key tf
        actionKeyTf = new JTextField("G");
        actionKeyTf.setEditable(false);

        //trigger key tf
        triggerKeyTf = new JTextField("Left Click");
        triggerKeyTf.setEditable(false);

        // start button
        startBtn = new JButton("Start");

        //overlay check box
        overlayCHK = new JCheckBox("Overlay");
        overlayCHK.setSelected(true);

        //modifier combo
        modifiers = new JComboBox<>();
        modifiers.setMinimumSize(new Dimension(0, 0));
        modifiers.setPreferredSize(new Dimension(80, 30));
        modifiers.addItem("<no modififers");
        modifiers.addItem("<Ctrl>");
        modifiers.addItem("<Alt>");
        modifiers.addItem("shift");
        modifiers.addItem("<Ctrl+alt>");
        modifiers.addItem("<Ctrl+shift>");
    }

    private void layComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        JPanel leftPanel = new JPanel(new GridBagLayout());
        //left panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.4;
        gbc.fill = HORIZONTAL;
        gbc.insets.bottom = 10;
        leftPanel.add(new JLabel("Action Key:"),  gbc);

        gbc.insets.bottom = 0;
        gbc.gridy++;
        gbc.fill = BOTH;
        leftPanel.add(actionKeyTf, gbc);

        gbc.insets.bottom = 10;
        gbc.gridy++;
        gbc.fill = HORIZONTAL;
        leftPanel.add(new JLabel("Trigger Key:"), gbc);

        gbc.insets.bottom = 0;
        gbc.gridy++;
        gbc.fill = BOTH;
        leftPanel.add(triggerKeyTf, gbc);

        //main panel
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.fill = BOTH;
        gbc.gridheight = 3;
        add(leftPanel, gbc);

        gbc.insets = new Insets(10, 10, 10, 15);
        gbc.fill = HORIZONTAL;
        gbc.weightx = 0.4;
        gbc.gridx++;
        gbc.gridheight = 1;
        gbc.ipady = 8;
        add(startBtn, gbc);

        gbc.insets.top = 0;
        gbc.ipady = 0;
        gbc.gridy++;
        add(overlayCHK, gbc);

        gbc.insets.left = 5;
        gbc.insets.bottom = 10;
        gbc.ipady = 2;
        gbc.gridy++;
        add(modifiers, gbc);
    }

    private void addListeners() {
        actionKeyTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                actionKeyTf.setText(String.valueOf(e.getKeyChar()));
                sm.actionKey = e.getKeyCode();
                smChangeListener.settingsManagerChanged(sm);
            }
        });
        triggerKeyTf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                triggerKeyTf.setText(String.valueOf(e.getButton()));
                sm.triggerKey = e.getButton();
                smChangeListener.settingsManagerChanged(sm);
            }
        });

    }

}
