import java.io.BufferedWriter;
import java.io.*;
import java.time.LocalDateTime;

public class FileLogger {
    private static FileLoggerConfiguration LoggConfig;

    public static void setUpLogger(FileLoggerConfiguration config) {
        LoggConfig = config;
    }
    public static void log (String text) throws IOException {
        if (LoggConfig.getLevel() == LogLevel.DEBUG) {
            debug(text);
            info(text);
        } else {
            info(text);
        }
        File file = new File(LoggConfig.getFilePath());
        if (file.length() >= LoggConfig.getFileMaxsize())
            throw new FileMaxSizeReachedException("FileMaxSize - " + LoggConfig.getFileMaxsize() + " ;" + " file current size - " + file.length() + " ; path - " + LoggConfig.getFilePath());
    }
    public static void info(String text) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(LoggConfig.getFilePath(), true);
        text = LocalDateTime.now() + " [ LEVEL ]" + LogLevel.INFO + " : " + text;
        byte[] buffer = text.getBytes();
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
    public static void debug(String text) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(LoggConfig.getFilePath(), true);
        text = LocalDateTime.now() + "[ LEVEL ]" + LogLevel.DEBUG + " :" + text;
        byte[] buffer = text.getBytes();
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
}