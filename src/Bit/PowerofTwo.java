package Bit;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerofTwo {
    public static void main(String[] args) {
        System. out.println(checksIfnIsaPowerOf2(0)); // false
        System. out.println(checksIfnIsaPowerOf2(1)); // true, 2^0 = 1
        System. out.println(checksIfnIsaPowerOf2(2)); // true, 2^1 = 2
        System. out.println(checksIfnIsaPowerOf2(3)); // false
        System. out.println(checksIfnIsaPowerOf2(4)); // true, 2^2 = 4
        System. out.println(checksIfnIsaPowerOf2(5)); // false
        System. out.println(checksIfnIsaPowerOf2(6)); // false
    }

    public static boolean checksIfnIsaPowerOf2(int n) {
        if(n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
