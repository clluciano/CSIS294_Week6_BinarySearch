import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {
    // ******************************************************
    // always need data to be sorted in order to use a search
    // ******************************************************
    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        int[] aiNumbers = new int[10000000];
        int iTargetNumIndex;
        int iTargetNum;
        int iIndexReturned;
        long startTime;
        long elapsedTime;

        // Fill array with random int numbers.
        for(int i = 0; i < aiNumbers.length; i++) {
            aiNumbers[i] = oRand.nextInt();
        }

        // Sort array
        Arrays.sort(aiNumbers);
        iTargetNumIndex = oRand.nextInt(aiNumbers.length);
        iTargetNum = aiNumbers[iTargetNumIndex];

        System.out.println("Target num and index: " + iTargetNum + " / " + iTargetNumIndex );

        // Instantiate the class in order to use a none static method
        BinarySearchTest oTest = new BinarySearchTest();

        // ************************** //
        // *** Time Binary Search *** //

        startTime = System.nanoTime();
        iIndexReturned = oTest.findNumberBinarySearch(aiNumbers, iTargetNum, aiNumbers.length - 1, 0);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time for binary search: " + elapsedTime);

        // ***  End Binary Search *** //
        // ************************** //


        // ************************** //
        // *** Time Linear Search *** //

        startTime = System.nanoTime();
        iIndexReturned = oTest.findNumberLinearSearch(aiNumbers, iTargetNum);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time for linear search: " + elapsedTime);

        // ***  End Linear Search *** //
        // ************************** //

        // System.out.println("Index returned: " + iIndexReturned);

    }

    // Finding index of target num using Binary Search and Recursion.
    private int findNumberBinarySearch(int[] aiNumbers, int iTargetNum, int iHighIndex, int iLowIndex) {

        // Get middle index
        int iMiddleIndex = (iLowIndex + iHighIndex) / 2;

        // check if number at middle is target number.
        if (aiNumbers[iMiddleIndex] == iTargetNum) {
            return iMiddleIndex;
        }

        // check if target number is higher than number at middle index.
        if (iTargetNum > aiNumbers[iMiddleIndex]) {
            // Recursively call this method to continue search.
            return findNumberBinarySearch(aiNumbers, iTargetNum, iHighIndex, iMiddleIndex + 1);

        }
        // Target num must be in lower half of range
        else {
            return findNumberBinarySearch(aiNumbers, iTargetNum, iMiddleIndex - 1, iLowIndex);
        }

    }

    // Find target number's index using linear search
    private int findNumberLinearSearch(int[] aiNumbers, int iTargetNum) {

        for (int i = 0; i < aiNumbers.length; i++) {
            if (aiNumbers[i] == iTargetNum) {
                return i;
            }
        }

        // negative one is often returned to indicate an error
        return -1;
    }
}
