
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration loggerConfig = new FileLoggerConfiguration(LogLevel.INFO, 1024, "logger.log");
        FileLogger.setUpLogger(loggerConfig);
        for (int i = 0; i < 10; i++) {
            try {
                FileLogger.log("Log text\n");
            } catch (FileMaxSizeReachedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

