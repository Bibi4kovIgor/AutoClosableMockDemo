package edu.lemon.autoclosable;

public class Application {

    private static final Logger logger = Logger.createPrintableLogger();
    public static void main(String[] args) {

        Logger log = Application::formattedPrint;
        log.log("message\n");
//        Logger lo
        // Using try-with-rassertEquals(esources to automatically close the resource
        try (MyResource resource = new MyResource(logger)) {
            // Resource is automatically closed after this block
            resource.open();
            resource.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void formattedPrint(String str) {
        System.out.printf("This is log of your resource %s ", str);
    }
}
