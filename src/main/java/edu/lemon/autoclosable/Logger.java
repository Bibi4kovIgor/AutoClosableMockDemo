package edu.lemon.autoclosable;

@FunctionalInterface
public interface Logger {
    void log(String message);

    static Logger createLogger() {
        return message -> {};
    }
    static Logger createPrintableLogger() {
        return System.out::println;
    }
}
