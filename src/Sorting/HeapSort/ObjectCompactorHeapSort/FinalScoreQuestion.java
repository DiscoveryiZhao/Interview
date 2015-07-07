package Sorting.HeapSort.ObjectCompactorHeapSort;

import java.util.*;

/**
 * Created by yizhao on 7/7/15.
 */
public class FinalScoreQuestion {
    public static void main(String[] args) {
        // (94 + 98 + 93 + 90 + 50) / 5 = 85
        TestResult studentA_1 = new TestResult(1, "", 94);
        TestResult studentA_2 = new TestResult(1, "", 98);
        TestResult studentA_3 = new TestResult(1, "", 93);
        TestResult studentA_4 = new TestResult(1, "", 90);
        TestResult studentA_5 = new TestResult(1, "", 23);
        TestResult studentA_6 = new TestResult(1, "", 50);

        // (74 + 78 + 73 + 70 + 30) / 5 = 65
        TestResult studentB_1 = new TestResult(2, "", 74);
        TestResult studentB_2 = new TestResult(2, "", 78);
        TestResult studentB_3 = new TestResult(2, "", 73);
        TestResult studentB_4 = new TestResult(2, "", 70);
        TestResult studentB_5 = new TestResult(2, "", 3);
        TestResult studentB_6 = new TestResult(2, "", 30);

        List<TestResult> results = new ArrayList<TestResult>();
        results.add(studentA_1);
        results.add(studentA_2);
        results.add(studentA_3);
        results.add(studentA_4);
        results.add(studentA_5);
        results.add(studentA_6);

        results.add(studentB_1);
        results.add(studentB_2);
        results.add(studentB_3);
        results.add(studentB_4);
        results.add(studentB_5);
        results.add(studentB_6);

        // {1=85.0, 2=65.0}
        System.out.println(calculateFinalScores(results));
    }

    public static Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
        if (results.size() == 0) {
            return null;
        } else {
            HashMap<Integer, PriorityQueue<Integer>> id_scores = new HashMap<Integer, PriorityQueue<Integer>>();
            // reverseOrder from minHeap PriorityQueue to maxHeap PriorityQueue
            Comparator<Integer> c = Collections.reverseOrder();
            for (TestResult r : results) {
                PriorityQueue<Integer> minHeap = null;
                if (!id_scores.containsKey(r.studentId)) {
                    // use Comparator to reverseOrder from minHeap PriorityQueue to maxHeap PriorityQueue
                    minHeap = new PriorityQueue<Integer>(5, c);
                } else {
                    minHeap = id_scores.get(r.studentId);
                }
                minHeap.add(r.testScore);
                id_scores.put(r.studentId, minHeap);
            }

            HashMap<Integer, Double> id_average = new HashMap<Integer, Double>();
            for (int key : id_scores.keySet()) {
                PriorityQueue<Integer> q = id_scores.get(key);
                double avg = 0;
                for (int i = 0; i < 5; i++) {
                    avg += q.poll();
                }
                avg /= 5;
                id_average.put(key, avg);
            }
            return id_average;
        }
    }
}

class TestResult{
    int studentId;
    String name;
    int testScore;

    public TestResult(int studentId, String name, int testScore){
        this.studentId = studentId;
        this.name = name;
        this.testScore = testScore;
    }
}