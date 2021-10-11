package eu.flrkv.civmanager.gui.frames;

import eu.flrkv.civmanager.StaticProperties;
import eu.flrkv.civmanager.gui.frametype.AppFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Setup extends AppFrame {

    private JPanel mainPanel;
    private JLabel logo;
    private JLabel appnameLabel;
    private JCheckBox c6;
    private JButton finishButton;
    private JLabel welcomeLabel;
    private JCheckBox c6dlc;

    public Setup() {
        super(null, StaticProperties.APPNAME + " | Setup", new Dimension(600, 450), true);
        init();
    }

    @Override
    protected void init() {
        this.add(mainPanel);
        appnameLabel.setText(StaticProperties.APPNAME);
        this.pack();
        this.setResizable(false);
        this.welcomeLabel.setText(this.welcomeLabel.getText().replace("%APPNAME%", StaticProperties.APPNAME));
        this.finishButton.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c6dlc.setVisible(false);

        c6.addChangeListener(onCheckBoxChange());
        c6dlc.addChangeListener(onCheckBoxChange());

    }

    private ChangeListener onCheckBoxChange()
    {
        return e -> finishButton.setEnabled(c6.isSelected() || c6dlc.isSelected());
    }

    private void createUIComponents()
    {
        logo = new JLabel(StaticProperties.HEADER_IMAGEICON);
    }
}
