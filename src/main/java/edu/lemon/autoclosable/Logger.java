package edu.lemon.autoclosable;

@FunctionalInterface
public interface Logger {
    void log(String message);

    static Logger createLogger() {
        return message -> {};
    }
//    Override Overload Overwrite
    static Logger createPrintableLogger() {
        return System.out::println;
    }

}
