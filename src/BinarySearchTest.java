import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {
    // ******************************************************
    // always need data to be sorted in order to use a search
    // ******************************************************
    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        String[] asWords = new String[10];
        int targetIndex;
        String targetString;
        int iIndexReturned;
        long startTime;
        long elapsedTime;

        // Fill array with words
        asWords[0] = "John";
        asWords[1] = "Lucky";
        asWords[2] = "Abraham";
        asWords[3] = "Christian";
        asWords[4] = "Rocky";
        asWords[5] = "Josiah";
        asWords[6] = "Zack";
        asWords[7] = "Michael";
        asWords[8] = "Anna";
        asWords[9] = "Bill";

        // Sort array
        Arrays.sort(asWords);
        targetIndex = oRand.nextInt(asWords.length);
        targetString = asWords[targetIndex];
//        for (int i = 0; i < asWords.length; i++) {
//            System.out.println(asWords[i]);
//        }
        System.out.println("Target string and index: " + targetString + " / " + targetIndex );
        System.out.println("***********************************************************************");

        // Instantiate the class in order to use a none static method
        BinarySearchTest oTest = new BinarySearchTest();

        // ************************** //
        // *** Time Binary Search *** //

        startTime = System.nanoTime();
        iIndexReturned = oTest.findStringBinarySearch(asWords, targetString, asWords.length - 1, 0);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("(Binary Search) Time: " + elapsedTime);
        System.out.println("(Binary Search) Index found: " + iIndexReturned);
        System.out.println("***********************************************************************");

        // ***  End Binary Search *** //
        // ************************** //


        // ************************** //
        // *** Time Linear Search *** //

        startTime = System.nanoTime();
        iIndexReturned = oTest.findNumberLinearSearch(asWords, targetString);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("(Linear Search) Index found: " + iIndexReturned);
        System.out.println("Time for linear search: " + elapsedTime);

        // ***  End Linear Search *** //
        // ************************** //

        // System.out.println("Index returned: " + iIndexReturned);

    }

    // Finding index of target num using Binary Search and Recursion.
    private int findStringBinarySearch(String[] siStringArray, String sTargetString, int iHighIndex, int iLowIndex) {

        // Get middle index
        int iMiddleIndex = (iLowIndex + iHighIndex) / 2;

        // check if number at middle is target number.
        if (siStringArray[iMiddleIndex].equals(sTargetString)) {
            return iMiddleIndex;
        }

        // check if target string comes after the word in the middle index in aplhabetical order
        if (sTargetString.compareTo(siStringArray[iMiddleIndex]) > 0) {
            // Recursively call this method to continue search.
            return findStringBinarySearch(siStringArray, sTargetString, iHighIndex, iMiddleIndex + 1);

        }
        // Target num must be in lower half of range
        else {
            return findStringBinarySearch(siStringArray, sTargetString, iMiddleIndex - 1, iLowIndex);
        }

    }

    // Find target number's index using linear search
    private int findNumberLinearSearch(String[] stringArray, String targetString) {

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(targetString)) {
                return i;
            }
        }

        // negative one is often returned to indicate an error
        return -1;
    }
}
