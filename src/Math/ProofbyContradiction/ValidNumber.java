package Math.ProofbyContradiction;

/**
 * Created by yizhao on 6/30/15.
 */
public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("3")); // true
        System.out.println(isNumber("3E4")); // true
        System.out.println(isNumber("34.23E2")); // true
        System.out.println(isNumber("+.8")); // true
        System.out.println(isNumber("4e+")); // false
        System.out.println(isNumber(".3")); // true
        System.out.println(isNumber("3.")); // true
        System.out.println(isNumber(".")); // false
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return isNum(s.charAt(0));
        } else {
            boolean dotFlag = false;
            boolean eFlag = false;
            for (int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case '.':
                        if ((i == 0 && !isNum(s.charAt(i + 1))) || (i > 0 && (dotFlag || eFlag)) || (i == n - 1 && !isNum(s.charAt(i - 1)))) {
                            return false;
                        }
                        dotFlag = true;
                        break;
                    case '+':
                    case '-':
                        if ((i == 0 && !(isNum(s.charAt(i + 1)) || s.charAt(i + 1) == '.')) || (i > 0 && !(s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) || (i == n - 1)) {
                            return false;
                        }
                        break;
                    case 'e':
                    case 'E':
                        if (i == 0 || (i > 0 && eFlag) || i == n - 1) {
                            return false;
                        }
                        eFlag = true;
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
