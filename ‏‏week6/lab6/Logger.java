package lab6;
/**
In this assignment we will implement a Logger object with the following requirements:

        The logger class should be a singleton class (same API as in the TA)

        The logger object can take up to 100 strings and store them

        In addition implement the following methods:

        addLogLine(String Operation) - should add the string if there is space.
        readLog() - prints out all strings in the log with the format: “LOGGER: <String>\n”
 */

/**
 * in this example, we are using the singleton pattern to create a logger object.
 * the purpose of the logger object is to store log lines.
 * */
class Logger {
    private String[] logs;
    private static Logger LOGGER;
    private int count = 0;

    private Logger() {
        logs = new String[100];
    }

    public Logger getInstance() {
        if (LOGGER == null) {
            LOGGER = new Logger();
        }
        return LOGGER;
    }


    public void addLogLine(String logLine) {
        if (LOGGER != null && count < 100) {
            {
                logs[count++] = logLine;
            }
        }
    }

    public void readLog() {
        for (int i = 0; i < count; i++) {
            System.out.println("LOGGER: " + logs[i]);
        }
    }
}