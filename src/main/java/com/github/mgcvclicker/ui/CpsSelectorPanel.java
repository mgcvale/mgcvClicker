package com.github.mgcvclicker.ui;

import com.github.mgcvclicker.ui.data.SettingsChangeListener;
import com.github.mgcvclicker.ui.data.SettingsManager;
import com.github.mgcvclicker.ui.util.PlaceholderTextField;
import com.github.mgcvclicker.ui.util.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CpsSelectorPanel extends RoundedPanel {
    //ui elements
    private PlaceholderTextField cpsTxt, holdTimeTxt;
    private JLabel cpsLbl, holdTimeLbl;
    private JButton applyBtn;

    //backend fields
    private SettingsManager sm;
    private SettingsChangeListener smChangeListener;


    public CpsSelectorPanel() {
        initPanel();
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

    private void initPanel() {
        setLayout(new GridBagLayout());
    }

    private void initComponents() {
        cpsTxt = new PlaceholderTextField("CPS");
        holdTimeTxt = new PlaceholderTextField("Hold time (ms)");
        cpsLbl = new JLabel("CPS");
        holdTimeLbl = new JLabel("Hold time (ms)");
        applyBtn = new JButton("Apply");
    }

    private void layComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 1; gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 0, 10);
        add(cpsLbl, gbc);


        gbc.gridx++;
        add(holdTimeLbl, gbc);

        gbc.insets.bottom = 10;
        gbc.weighty = 0.6;
        gbc.gridx = 0;
        gbc.gridy ++;
        add(cpsTxt, gbc);

        gbc.gridx ++;
        add(holdTimeTxt, gbc);

        gbc.insets.right = 25;
        gbc.insets.left = 25;
        gbc.weighty = 0.4;
        gbc.gridx = 0;
        gbc.gridy ++;
        gbc.gridwidth = 2;
        add(applyBtn, gbc);
    }

    private void addListeners() {
        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cps = Integer.parseInt(cpsTxt.getText());
                    int holdTime = Integer.parseInt(holdTimeTxt.getText());
                    if(holdTime > 1000/cps){
                        JOptionPane.showMessageDialog(CpsSelectorPanel.this, "O holdTime está muito alto!");
                        holdTimeTxt.requestFocus();
                        return;
                    }
                    holdTimeTxt.setText("");
                    cpsTxt.setText("");
                    sm.cps = cps;
                    sm.holdTime = holdTime;
                    smChangeListener.settingsManagerChanged(sm);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(CpsSelectorPanel.this, "Selecione valores válidos!");
                }
            }
        });
    }

}
