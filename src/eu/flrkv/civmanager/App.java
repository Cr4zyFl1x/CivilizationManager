package eu.flrkv.civmanager;

import com.bulenkov.darcula.DarculaLaf;
import eu.cr4zyfl1x.logger.LogType;
import eu.cr4zyfl1x.logger.Logger;
import eu.flrkv.civmanager.database.SQLite;
import eu.flrkv.civmanager.gui.GUIController;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class App {

    public static void main(String[] args) throws IOException {

        // Load LookAndFeel
        loadLookAndFeel(new DarculaLaf());

        // Logger
        initLogger();

        // GUI Controller
        GUIController g = new GUIController();

        // Log end of main stage
        Logger.log(LogType.SYSTEM, "Reached end of system main stage");

        new SQLite(StaticProperties.STORAGE_PATH + "/data", "civilizations.db");

        // Run GUI Controller
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                g.run();
            }
        });
    }

    private static void initLogger()
    {
        Logger logger = new Logger("C6M", new Date(), StaticProperties.STORAGE_PATH + "/logs");
        logger.load();
        Logger.log(LogType.SYSTEM, "Logger initialization completed!");
        Logger.log(LogType.INFORMATION, StaticProperties.APPNAME + " - Version: " + StaticProperties.VERSION);
    }

    private static void loadLookAndFeel(LookAndFeel l) {
        try {
            UIManager.setLookAndFeel(l);
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "We're unable to load the LookAndFeel for this Application.\nPlease contact the developer using the email address below.\n\ninfo@sarpex.eu", "Critical application error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private static void registerDrivers(Driver[] drivers)
    {
        if (Logger.isLoaded()) {
            Logger.log(LogType.SYSTEM, "Loading " + drivers.length + " drivers ...");
        }
        try {
            for (Driver d: drivers) {
                DriverManager.registerDriver(d);
            }
        } catch (SQLException e) {
            if (Logger.isLoaded()) {
                Logger.log(LogType.ERROR, "One or more drivers could not be loaded!\n" + e.getMessage());
            }
        }
    }


}
