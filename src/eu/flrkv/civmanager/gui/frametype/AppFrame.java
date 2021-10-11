package eu.flrkv.civmanager.gui.frametype;

import eu.flrkv.civmanager.StaticProperties;
import eu.flrkv.civmanager.gui.GUIController;

import javax.swing.*;
import java.awt.*;

public abstract class AppFrame extends JFrame {

    /**
     * GUIController for this Frame
     */
    private GUIController controller = null;


    public AppFrame(GUIController gc, String title, Dimension dim, boolean visible) {

        // Set Frame title
        super(title);

        // Set Dimension of frame
        this.setSize(dim);

        // Frame icon
        this.setIconImage(StaticProperties.FRAME_ICON.getImage());

        // Set Visibility
        this.setVisible(visible);

        // Set GUI Controller
        this.setController(gc);

    }

    public AppFrame(GUIController gc, String title, int[] dim, boolean visible) {

        // Set Frame title
        super(title);

        // Set Dimension of frame
        if (dim.length == 2) this.setSize(dim[0], dim[1]);

        // Frame icon
        this.setIconImage(StaticProperties.FRAME_ICON.getImage());

        // Set Visibility
        this.setVisible(visible);

        // Set GUI Controller
        this.setController(gc);

    }

    public AppFrame(GUIController gc, String title, boolean visible) {

        // Set Frame title
        super(title);

        // Frame icon
        this.setIconImage(StaticProperties.FRAME_ICON.getImage());

        // Set Visibility
        this.setVisible(visible);

        // Set GUI Controller
        this.setController(gc);
    }

    protected void setController(GUIController gc)
    {
        this.controller = gc;
    }

    protected GUIController getController()
    {
        return this.controller;
    }

    protected abstract void init();
}
