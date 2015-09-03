package DesignPattern.Singleton;

/**
 * Created by YZ on 9/2/15.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void print() {
        System.out.println("only one");
    }
}