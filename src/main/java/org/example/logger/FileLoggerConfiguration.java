

public class FileLoggerConfiguration {
    private LogLevel level;
    private int fileMaxsize;
    private String filePath;

    public LogLevel getLevel() {
        return level;
    }

    public int getFileMaxsize() {
        return fileMaxsize;
    }

    public String getFilePath() {
        return filePath;
    }


    public FileLoggerConfiguration(LogLevel level, int fileMaxsize, String filePath) {
        this.level = level;
        this.fileMaxsize = fileMaxsize;
        this.filePath = filePath;
    }
}