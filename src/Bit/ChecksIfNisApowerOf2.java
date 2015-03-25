package Bit;

/**
 * Created by yizhao on 3/24/15.
 */
public class ChecksIfNisApowerOf2 {
    public static void main(String[] args) {
        System. out.println(checksIfnIsaPowerOf2(0)); // true
        System. out.println(checksIfnIsaPowerOf2(1)); // true
        System. out.println(checksIfnIsaPowerOf2(2)); // true
        System. out.println(checksIfnIsaPowerOf2(3)); // false
        System. out.println(checksIfnIsaPowerOf2(4)); // true
        System. out.println(checksIfnIsaPowerOf2(5)); // false
        System. out.println(checksIfnIsaPowerOf2(6)); // false
    }

    public static boolean checksIfnIsaPowerOf2(int n) {
        return (n & (n-1)) == 0;
    }
}
