package singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("If you see same value, then singleton was reused (yay!)");
        System.out.println("If you see different value, then 2 singletons were created (booo!!)");
        System.out.println("RESULT:");

        Singleton singleton = Singleton.getInstance("FOO");
        Singleton singleton2 = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(singleton2.value);
    }
}