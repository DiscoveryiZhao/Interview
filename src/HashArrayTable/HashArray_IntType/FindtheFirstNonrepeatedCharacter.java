package HashArrayTable.HashArray_IntType;

/**
 * Created by yizhao on 12/12/14.
 */
public class FindtheFirstNonrepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(findtheFirstNonrepeatedCharacter("teeter")); // r
        System.out.println(findtheFirstNonrepeatedCharacter("total")); // o
        System.out.println(findtheFirstNonrepeatedCharacter("Pearlpet")); // a
        System.out.println(findtheFirstNonrepeatedCharacter("aabbcdefg")); // c
    }

    public static Character findtheFirstNonrepeatedCharacter(String s) {
        s = s.toLowerCase();
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return null;
    }
}
