package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {
    public void testMe(MyArrayList myArrayList, Results results) {
        myArrayList.toString();


    }
}
//package myArrayList.test;
//
//import java.util.Arrays;
//import java.util.Random;
//
//import myArrayList.MyArrayList;
//import myArrayList.util.FileProcessor;
//import myArrayList.util.Results;
//
//public class MyArrayListTest
//{
//    public static void sumTest(MyArrayList myArrayList, Results results, FileProcessor fileProcessor)
//    {
//        // read in all the elements from the input file
//        String line = "";
//        while ((line = fileProcessor.readLine()) != null)
//        {
//            int intToInsert = 0;
//            try
//            {
//                intToInsert = Integer.parseInt(line);
//            }
//            catch (NumberFormatException e)
//            {
//                System.err.println("Couldn't convert '" + line + "' to an int. Terminating the program.");
//                System.exit(1);
//            }
//            myArrayList.insertSorted(intToInsert);
//        }
//
//        // store the sum to the results file
//        String result = "The sum of all the values in the array list is : " + myArrayList.sum();
//        results.writeToFile(result);
//    }
//
//    public static void testMe(MyArrayList myArrayList, Results results)
//    {
//        // run the test cases
//        myArrayList.clear();
//        testCase1(myArrayList, results);
//
//        myArrayList.clear();
//        testCase2(myArrayList, results);
//
//        myArrayList.clear();
//        testCase3(myArrayList, results);
//
//        myArrayList.clear();
//        testCase4(myArrayList, results);
//
//        myArrayList.clear();
//        testCase5(myArrayList, results);
//
//        myArrayList.clear();
//        testCase6(myArrayList, results);
//
//        myArrayList.clear();
//        testCase7(myArrayList, results);
//
//        myArrayList.clear();
//        testCase8(myArrayList, results);
//
//        myArrayList.clear();
//        testCase9(myArrayList, results);
//
//        myArrayList.clear();
//        testCase10(myArrayList, results);
//    }
//
//    private static String compareResults(String testName, String expectedResult, String actualResult)
//    {
//        String result = "";
//
//        if (expectedResult.compareToIgnoreCase(actualResult) == 0)
//        {
//            result = "test " + testName + " passed";
//        }
//        else
//        {
//            result = "test " + testName + " failed\n";
//            result += "Expected: " + expectedResult +"\n";
//            result += "Actual: " + actualResult;
//        }
//
//        return result;
//    }
//
//    private static void testCase1(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'List Initially Empty'";
//
//        // array list should be empty after a clear
//        String expectedResult = "0 0";
//        String actualResult = myArrayList.size() + " " + myArrayList.sum();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase2(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'Remove from empty list'";
//
//        // try to remove from empty list, shouldn't cause an error and list should still be empty
//        String expectedResult = "";
//        myArrayList.removeValue(5);
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase3(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'Insert 10 Random Elements'";
//        int[] array = new int[10];
//
//        // try to insert 10 random elements into the array
//        Random random = new Random();
//        for (int i = 0; i < 10; i++)
//        {
//            int randomInt = random.nextInt(10001);
//            array[i] = randomInt;
//            myArrayList.insertSorted(randomInt);
//        }
//
//        // use the java sort function to sort the expected results array
//        Arrays.sort(array);
//        String expectedResult = "";
//        for (int i = 0; i < array.length; i++)
//        {
//            expectedResult += array[i];
//            if (i < (array.length - 1))
//            {
//                expectedResult += " ";
//            }
//        }
//
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase4(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'Store more than initial capacity of 50'";
//        int[] array = new int[51];
//
//        // store more than 50 elements into array
//        for (int i = 51; i > 0; i--)
//        {
//            array[i-1] = i;
//            myArrayList.insertSorted(i);
//        }
//
//        // expected result is already in ascending order
//        String expectedResult = "";
//        for (int i = 0; i < array.length; i++)
//        {
//            expectedResult += array[i];
//            if (i < (array.length - 1))
//            {
//                expectedResult += " ";
//            }
//        }
//
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase5(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'remove element from beginning, middle, and end'";
//        String expectedResult = "1 2 4 5";
//
//        // store 7 elements into the array
//        for (int i = 0; i < 7; i++)
//        {
//            myArrayList.insertSorted(i);
//        }
//
//        // remove the first, middle, and last elements
//        myArrayList.removeValue(0);
//        myArrayList.removeValue(3);
//        myArrayList.removeValue(6);
//
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase6(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'adding duplicate elements'";
//        String expectedResult = "0 1 2 2 3 4";
//
//        // store 5 elements into the array
//        for (int i = 0; i < 5; i++)
//        {
//            myArrayList.insertSorted(i);
//        }
//
//        // insert duplicate 2
//        myArrayList.insertSorted(2);
//
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase7(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'indexOf returns index of first duplicated element'";
//        String expectedResult = "2";
//
//        // store 5 elements into the array
//        for (int i = 0; i < 5; i++)
//        {
//            myArrayList.insertSorted(i);
//        }
//
//        // insert duplicate 2
//        myArrayList.insertSorted(2);
//
//        String actualResult = "" + myArrayList.indexOf(2);
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase8(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'removeValue removes only one duplicated element'";
//        String expectedResult = "0 1 2 3 4";
//
//        // store 5 elements into the array
//        for (int i = 0; i < 5; i++)
//        {
//            myArrayList.insertSorted(i);
//        }
//
//        // insert duplicate 2
//        myArrayList.insertSorted(2);
//
//        // remove the duplicate 2
//        myArrayList.removeValue(2);
//
//        String actualResult = myArrayList.toString();
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase9(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'Calculate average of 7 numbers'";
//        String expectedResult = "2"; // will be 2 after casting to an int
//
//        // store 7 elements into an array
//        myArrayList.insertSorted(1);
//        myArrayList.insertSorted(4);
//        myArrayList.insertSorted(-2);
//        myArrayList.insertSorted(5);
//        myArrayList.insertSorted(7);
//        myArrayList.insertSorted(-8);
//        myArrayList.insertSorted(10);
//
//        // calculate average
//        int average = myArrayList.sum() / myArrayList.size();
//        String actualResult = "" + average;
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//
//    private static void testCase10(MyArrayList myArrayList, Results results)
//    {
//        String testName = "'Calculate average of 7 numbers, after initially having 10'";
//        String expectedResult = "-2"; // will be -2 after casting to an int
//
//        // store 10 elements into an array
//        myArrayList.insertSorted(1);
//        myArrayList.insertSorted(4);
//        myArrayList.insertSorted(-2);
//        myArrayList.insertSorted(5);
//        myArrayList.insertSorted(7);
//        myArrayList.insertSorted(-8);
//        myArrayList.insertSorted(10);
//        myArrayList.insertSorted(-5);
//        myArrayList.insertSorted(0);
//        myArrayList.insertSorted(-20);
//
//        // remove 3 elements
//        myArrayList.removeValue(-2);
//        myArrayList.removeValue(4);
//        myArrayList.removeValue(7);
//
//        // calculate average
//        int average = myArrayList.sum() / myArrayList.size();
//        String actualResult = "" + average;
//
//        // write to results
//        results.writeToFile(compareResults(testName, expectedResult, actualResult));
//    }
//}
