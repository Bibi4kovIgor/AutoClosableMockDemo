package edu.lemon;


import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Main {
    private static final String DATA_FILE_NAME = "data.txt";
    public static void main(String[] args) {
        try (InputStream fileInputStream = Main.class.getClassLoader().getResourceAsStream(DATA_FILE_NAME)){
            StringBuilder data = new StringBuilder();
            int i;
            while ((i = Objects.requireNonNull(fileInputStream).read()) != -1) {
                data.append((char) i);
            }
            System.out.println(data);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            /**
             * It is not necessary block. It was placed only to demonstrate profit of using
             * "Parametrized critical section within AutoClosable interface"
             * @deprecated
             * */
        } /*finally {

            try {
                if(Objects.nonNull(fileInputStream)) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }*/

    }
}