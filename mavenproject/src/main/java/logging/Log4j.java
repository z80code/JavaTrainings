package logging;

//import org.apache.logging.log4j.core.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// https://logging.apache.org/log4j/2.x/manual/migration.html
// https://logging.apache.org/log4j/2.0/manual/api.html
// https://logging.apache.org/log4j/2.0/manual/configuration.html
public class Log4j {
    //final static Logger logger = Logger.getLogger(String.valueOf(Log4j.class));
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void main(String[] args) {
        logger.info("sdf");
        logger.error("error");
    }
}
