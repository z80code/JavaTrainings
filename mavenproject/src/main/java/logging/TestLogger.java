package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class TestLogger {

    private static final Logger logger
            = LogManager.getLogger(TestLogger.class);
    private static final Marker SQL_MARKER =
            MarkerManager.getMarker("SQL");

    public static void main(String[] args) {

        logger.info(SQL_MARKER,"Info from TestLogger");
        logger.error("Error from TestLogger");
    }


}
