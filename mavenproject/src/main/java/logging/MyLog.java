package logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLog {

    private static final Logger logger = LogManager.getLogger(MyLog.class);

    public static void main(String[] args) {
        logger.info("Info log");
        logger.error("Error log");
    }

}
