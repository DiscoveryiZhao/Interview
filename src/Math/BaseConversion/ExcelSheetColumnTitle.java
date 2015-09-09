package Math.BaseConversion;

/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
*/
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27)); // AA
    }

    public static String convertToTitle(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        int base = 26;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--; // 27 - 1 = 26
            sb.append((char) (n % base + 'A')); // A
            n /= base; // 26/26 = 1
        }

        sb.reverse();
        return sb.toString();
    }
}
