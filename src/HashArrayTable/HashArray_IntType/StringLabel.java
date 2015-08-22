package HashArrayTable.HashArray_IntType;

/**
 * Created by YZ on 8/22/15.
 */
public class StringLabel {
    public static void main(String[] args){
        System.out.println(stringLabel("cattaac"));
    }

     /*
     * O(n) for time
     * create a unique label for a string "cat", "atc" => a1c1t1
     */
    public static String stringLabel(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                sb.append((char) (i + 'a'));
                sb.append(hash[i]);
            }
        }
        return sb.toString();
    }
}
