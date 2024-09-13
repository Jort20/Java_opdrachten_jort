package section6_design.part2_patterns.singleton;

import java.time.LocalDateTime;
import java.util.Date;

public class Logger {
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        //add your date information
        System.out.println("Logging: " + message);
    }
}
