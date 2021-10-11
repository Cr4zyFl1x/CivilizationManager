package eu.flrkv.civmanager.database;

import eu.cr4zyfl1x.logger.LogType;
import eu.cr4zyfl1x.logger.Logger;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {

    private final String dbfile;
    private final String directory;

    public SQLite(String directory, String dbfile)
    {
        this.dbfile = dbfile;
        this.directory = directory;

        Logger.log(LogType.INFORMATION, "Starting initialization of SQLite controller for file '" + dbfile + "'");

        checkDatabaseFile();
        initDB();
    }

    private void checkDatabaseFile()
    {
        File databaseDirectory = new File(directory);
        if (!databaseDirectory.exists()) {
            Logger.log(LogType.INFORMATION, "Creating directory for SQLite database in '" + directory +"' ...");
            if (databaseDirectory.mkdirs()) {
                Logger.log(LogType.INFORMATION, "Directory for SQLite database '" + dbfile + "' was successfully created!");
            } else {
                Logger.log(LogType.ERROR, "Directory for SQLite database '" + dbfile + "' could not be created!");
            }
        }
    }

    private void initDB()
    {
        boolean a = new File(directory + "/" + dbfile).exists();
        try {
            if (!a) Logger.log(LogType.INFORMATION, "Database file '" + dbfile + "' does not exist but will be created ...");
            DriverManager.getConnection("jdbc:sqlite:" + directory + "/" + dbfile);
            if (!a) Logger.log(LogType.INFORMATION, "Database file was successfully created!");
        } catch (SQLException e) {
            Logger.log(LogType.CRITICAL, "Cannot create/access to SQLite database!\n" + e.getMessage());
        }
    }

}
