package edu.lemon.autoclosable;

public class Application {

    private static final Logger logger = Logger.createPrintableLogger();
    public static void main(String[] args) {
        // Using try-with-resources to automatically close the resource
        try (MyResource resource = new MyResource(logger)) {
            // Resource is automatically closed after this block
            resource.open();
            resource.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
