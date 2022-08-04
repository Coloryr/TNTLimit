package coloryr.tntlimit.side.sideBukkit;

import coloryr.tntlimit.side.IMyLogger;

import java.util.logging.Logger;

public class BukkitLog implements IMyLogger {
    private final Logger logger;

    public BukkitLog(Logger Logger) {
        this.logger = Logger;
    }

    @Override
    public void warning(String data) {
        logger.warning(data);
    }

    @Override
    public void info(String data) {
        logger.info(data);
    }
}
