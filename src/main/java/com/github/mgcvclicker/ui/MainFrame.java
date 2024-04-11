package com.github.mgcvclicker.ui;

import com.github.mgcvclicker.ui.data.SettingsChangeListener;
import com.github.mgcvclicker.ui.data.SettingsManager;
import com.github.mgcvclicker.ui.util.ProgramView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setContentPane(new ProgramView());
        setSize(280, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(new Point(128, 128));
        setVisible(true);
    }
}
