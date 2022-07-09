package bwgames;

import java.time.LocalDateTime;

public class Debug {
    public static void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[DEBUG " + now + "] " + msg);
    }
}
