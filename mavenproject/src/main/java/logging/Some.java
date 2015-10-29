package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by igor on 29.10.2015.
 */
public class Some {

    private static final Logger logger = LogManager.getLogger(Some.class);

    public static void main(String[] args) {
        logger.debug("deb");
        logger.error("!error");
        logger.info("inf");
    }
}
