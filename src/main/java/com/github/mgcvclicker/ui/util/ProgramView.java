package com.github.mgcvclicker.ui.util;

import com.github.mgcvclicker.ui.ActionsPanel;
import com.github.mgcvclicker.ui.CpsSelectorPanel;
import com.github.mgcvclicker.ui.data.SettingsChangeListener;
import com.github.mgcvclicker.ui.data.SettingsManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProgramView extends JPanel implements SettingsChangeListener {
    private CpsSelectorPanel cpsSelectorPanel;
    private ActionsPanel actionsPanel;

    public ProgramView() {
        initComponents();
        layComponents();
    }

    private void initComponents() {
        setBackground(UIManager.getColor("TextField.background"));
        cpsSelectorPanel = new CpsSelectorPanel();
        cpsSelectorPanel.addSettingsChangeListener(this);
        cpsSelectorPanel.setSettingsManager(new SettingsManager());
        actionsPanel = new ActionsPanel();
        actionsPanel.addSettingsChangeListener(this);
        actionsPanel.setSettingsManager(new SettingsManager());
    }

    private void layComponents() {
        setLayout(new GridLayout(2, 1, 0, 10));
        setBorder(new EmptyBorder(15, 15, 15, 15));
        add(cpsSelectorPanel);
        add(actionsPanel);
    }

    @Override
    public void settingsManagerChanged(SettingsManager newManager) {
        actionsPanel.setSettingsManager(newManager);
        cpsSelectorPanel.setSettingsManager(newManager);
    }
}
