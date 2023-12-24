package app;

public class Application {
    public static void main(String[] args) {
        System.out.println("JAVA_VERSION: %s".formatted(System.getProperties().get("java.specification.version")));
    }
}
