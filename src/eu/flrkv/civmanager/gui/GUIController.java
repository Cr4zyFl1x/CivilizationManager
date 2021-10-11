package eu.flrkv.civmanager.gui;

import eu.cr4zyfl1x.logger.LogType;
import eu.cr4zyfl1x.logger.Logger;
import eu.flrkv.civmanager.gui.frames.Setup;
import eu.flrkv.civmanager.gui.frametype.AppFrame;

public class GUIController {

    private AppFrame setupFrame;


    public GUIController()
    {
        Logger.log(LogType.INFORMATION, "GUI Controller was created successfully!");
    }

    public void run() {
        Logger.log(LogType.INFORMATION, "Running GUI Controller...");
        setupFrame = new Setup();
    }


}
