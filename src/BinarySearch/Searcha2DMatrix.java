package BinarySearch;

/**
 * Created by yizhao on 5/17/15.
 */
public class Searcha2DMatrix {
    public static void main(String[] args){
        int[][] test1 = {{1}};
        int[][] test2 = {{1},{3}};
        int[][] test3 = {{1,3,5}};
        int[][] test4 = {{1,3}};
        System.out.println(searchMatrix(test1,1)); // true
        System.out.println(searchMatrix(test2,0)); // false
        System.out.println(searchMatrix(test3,4)); // false
        System.out.println(searchMatrix(test4,1)); // true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        int mid;
        while (low + 1 < high) {
            // Invariant: a[low] < target < a[high], and a[mid] == target
            mid = low + (high - low) / 2;
            int row = mid / matrix[0].length ;
            int col = mid % matrix[0].length ;
            if (matrix[row][col] == target) {
                return true ;
            } else if (matrix[row][col] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if(matrix[low / matrix[0].length][high % matrix[0].length] == target){
            return true;
        }
        if(matrix[high / matrix[0].length][low % matrix[0].length] == target){
            return true;
        }
        return false ;
    }
}
