package Math.AppliedMath;

import java.util.Arrays;

/**
 * Created by yizhao on 6/30/15.
 */
public class ShufferACard {
    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArrayInteratively(cards);
        System.out.println(Arrays.toString(cards));
    }

    public static void shuffleArrayInteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            swap(cards, i, rand(i, cards.length - 1));
        }
    }

    public static int rand(int low, int high) {
        // generate a random number between [low, high - low]
        return low + (int) (Math.random() * (high - low + 1));
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
