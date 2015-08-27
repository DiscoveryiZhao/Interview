package Interviews.Alation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YZ on 8/27/15.
 */
public class ListMax {
    private List<Integer> list;
    int n;

    public ListMax(int n) {
        this.n = n;
        this.list = new ArrayList<Integer>(this.n);
        //Initialize to default value of 0 for all n positions
        for (int i = 0; i < n; i++) {
            this.list.add(0);
        }
    }

    public void doOperation(int a, int b, int k) {
        for (int i = a - 1; i < b; i++) {
            int val = this.list.get(i);
            val += k;
            this.list.set(i, val);
        }
    }

    public int listMax() {
        Collections.sort(this.list);
        int size = this.list.size();
        return this.list.get(size - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        int opCounter = 0;
        ListMax lm = new ListMax(n);
        //If I remember it right these were the constraints for the n and m values.
        if (n >= 1 && n <= 10000000 && m >= 1 && m <= 1000000) {
            while (opCounter != m) {
                String line = sc.nextLine();
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);
                int k = Integer.parseInt(line.split(" ")[2]);
                //If I remember it right these were the constraints for the a, b and k values.
                if (a >= 1 && a <= n && b >= 1 && b <= n && k >= 1 && k <= 1000000000) {
                    lm.doOperation(a, b, k);
                }
                opCounter++;
            }
        }
        System.out.println("Maximum value in the final list: " + lm.listMax());
    }
}
