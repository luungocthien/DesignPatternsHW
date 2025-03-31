package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    private Logger() {
        this.fileName = "default_log.txt";
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        try {
            if (writer != null) {
                writer.close();
            }
            this.fileName = fileName;
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
