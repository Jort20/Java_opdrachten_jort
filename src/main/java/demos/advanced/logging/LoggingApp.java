package demos.advanced.logging;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

public class LoggingApp {
    public static void main(String[] args) throws IOException {

        LoggingApp app = new LoggingApp();
        //remove default handlers
        Handler[] handlers = LOGGER.getHandlers();
        for (Handler handler : handlers) {
            LOGGER.removeHandler(handler);
        }
        LOGGER.setLevel(Level.ALL);
        FileHandler fileHandler = new FileHandler("logfile.html", false);
        fileHandler.setFormatter(new MyHtmlLogFormatter());
        LOGGER.addHandler(fileHandler);
        app.start();

    }

    public static final String GLOBAL_LOGGER_NAME = "nl.bioinf.log";
    private static final Logger LOGGER = Logger.getLogger(GLOBAL_LOGGER_NAME);

    private void start() {
        showHierarchy();

        LOGGER.warning("Could not find resource");
        //same as
        //LOGGER.log(Level.WARNING, "Could not find resource");
        try {
            LOGGER.log(Level.INFO, "Doing business");
            doBusiness();
        } catch (IOException e) {
            //e.printStackTrace();
            LOGGER.log(Level.SEVERE,
                    "Something went wrong; cause= {0}; message={1}",
                    new Object[]{e.getCause(), e.getMessage()});
        }
        LOGGER.log(Level.WARNING, "An illegal state!", new IllegalStateException("No booze"));
    }

    private void showHierarchy() {
        System.out.println("BASE: \"" + LOGGER.getName() + '"');
        System.out.println("Parent one: \"" + LOGGER.getParent().getName() + '"');
        System.out.println("Parent one: \"" + Logger.getLogger("nl.bioinf").getName() + '"');


    }

    private void doBusiness() throws IOException {
        IOException ex = new IOException("exception occurred");
        ex.initCause(new FileNotFoundException());
        throw ex;
    }
}
