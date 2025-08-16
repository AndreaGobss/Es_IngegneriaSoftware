public class es32 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Avvio programma");
        logger.log("Evento 1");
        logger.log("Evento 2");
    }
}

class Logger {
    private static Logger instance;
    private java.io.BufferedWriter writer;

    private Logger() {
        try {
            writer = new java.io.BufferedWriter(new java.io.FileWriter("log.txt", true));
        } catch (Exception e) {}
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        try {
            String ts = java.time.LocalDateTime.now().toString();
            writer.write(ts + " - " + msg + "\n");
            writer.flush();
        } catch (Exception e) {}
    }
}
