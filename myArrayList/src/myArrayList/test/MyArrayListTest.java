package myArrayList.test;


import myArrayList.MyArrayList;
import myArrayList.util.Results;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MyArrayListTest {
    private Results results;
    private MyArrayList myArrayList;
    private int testNumber;
    private String dash72;

    public MyArrayListTest() {
        this.testNumber = 1;
        this.dash72 = generate72Dash();
    }

    private void initializeMyArrayListObject(MyArrayList myArrayListObj) {
        myArrayList = myArrayListObj;
    }

    private void initializeResultObj(Results result) {
        results = result;
    }
    
    private void toggleMyArrayList_toStringMethod(){
        myArrayList.togglePrintFlag();
    }
    
    public void testMe(MyArrayList myArrayListObj, Results result) {
        initializeMyArrayListObject(myArrayListObj);
        initializeResultObj(result);

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();

    }

    private int getRandomNumberFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private void compareTestCaseAndStoreIt(String testCaseName, Object acceptedResult, Object outputResult) {
        String sCompare = stringCompare(acceptedResult.toString(), outputResult.toString()) ? "Passed" : "Failed";
        int testNumber = getCurrentTestNumber();
        boolean isPassed = sCompare.equalsIgnoreCase("passed");
        String str = String.format("%sTest Number : %d\n%s%s%s%s\nResult : %s\n%s",
                dash72,
                testNumber,
                testCaseName,
                !isPassed?"":"\nThe sum of all the values in the array list is: "+myArrayList.sum(),
                isPassed?"":"\nAccepted : "+acceptedResult,
                isPassed?"":"\nOutput : "+outputResult,
                sCompare,
                dash72);
        results.storeNewResult(str);
    }

    private boolean stringCompare(String str1, String str2) {
        return str1.trim().equalsIgnoreCase(str2.trim());
    }

    private int getCurrentTestNumber() {
        return testNumber++;
    }

    private String generate72Dash() {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < 72; i++) sbr.append("-");
        sbr.append("\n");
        return sbr.toString();
    }

    private int[] getArrayFromMyArrayList(int bandwidth) {
        String[] sArray = myArrayList.toString().split(" ");
        int[] arr = new int[sArray.length + bandwidth];
        int i = 0;
        for (String s : sArray)
            arr[i++] = Integer.parseInt(s);
        while(i<arr.length)
            arr[i++] = Integer.MAX_VALUE;
        return arr;
    }

    private String stringifyArray(int size, int[] array) {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) continue;
            sbr.append(array[i] + " ");
        }
        String str = sbr.toString().trim();
        return str;
    }

    private void test1() {
        toggleMyArrayList_toStringMethod();
        int num = getRandomNumberFromRange(0,10000);
        String test = String.format("Check the size of the array  after Insert %d in to the Array",num);
        int accepted = myArrayList.size() + num;
        myArrayList.insertSorted(num);
        int output = myArrayList.size();

        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test2() {
        toggleMyArrayList_toStringMethod();
        int num = getRandomNumberFromRange(0,10000);
        String test = "Check if the element inserted into the array is inserted and sorted properly \nnumber to be inserted is " + num;
        int[] arr = getArrayFromMyArrayList(1);
        int sizeBefore = myArrayList.size();

        if (sizeBefore < arr.length) {
            arr[arr.length - 1] = num;
        }
        Arrays.sort(arr);

        String accepted = stringifyArray(sizeBefore + 1, arr);
        myArrayList.insertSorted(num);
        String output = myArrayList.toString();
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test3() {
        toggleMyArrayList_toStringMethod();
        int[] arr = getArrayFromMyArrayList(0);
        int index = getRandomNumberFromRange(0, arr.length - 1);
        int num = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) arr[i] = -1;
        }
        String test = "Check if the element removal from the array (" + num + ")";


        String accepted = stringifyArray(arr.length, arr);
        myArrayList.removeValue(num);
        String output = myArrayList.toString();
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test4() {
        toggleMyArrayList_toStringMethod();
        int num = 100;
        String test = "Check by doing 2 insert of the same value (" + num + ")";

        int[] arr = getArrayFromMyArrayList(2);
        arr[arr.length - 2] = num;
        arr[arr.length - 1] = num;
        Arrays.sort(arr);


        String accepted = stringifyArray(arr.length, arr);
        myArrayList.insertSorted(num);
        myArrayList.insertSorted(num);
        String output = myArrayList.toString();
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test5() {
        toggleMyArrayList_toStringMethod();
        int num = 22;
        String test = "Check to remove all instance of element from the array (2 instance of " + num + " will be entered and removed)";


        int[] arr = getArrayFromMyArrayList(2);

        arr[arr.length - 2] = num;
        arr[arr.length - 1] = num;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) arr[i] = -1;
        }


        String accepted = stringifyArray(arr.length, arr);
        myArrayList.insertSorted(num);
        myArrayList.insertSorted(num);
        myArrayList.removeValue(num);
        String output = myArrayList.toString();
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test6() {
        toggleMyArrayList_toStringMethod();
        int size = 25;
        String test = "Check in a clean my MyArrayList by " + size + " inserting random numbers from 0 to 10001";
        myArrayList.clear();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num = getRandomNumberFromRange(0, 10001);
            arr[i] = num;
            myArrayList.insertSorted(num);
        }
        Arrays.sort(arr);
        String accepted = stringifyArray(arr.length, arr);
        String output = myArrayList.toString();

        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test7() {
        toggleMyArrayList_toStringMethod();
        int[] arr = getArrayFromMyArrayList(0);
        int index = getRandomNumberFromRange(0, arr.length - 1);

        int num = arr[index];
        int accepted = index;
        String test = "Check the index of a known element inside a MyArrayList\n" + myArrayList.toString() + "\nfor element " + num + " index is " + index;

        int output = myArrayList.indexOf(num);
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test8() {
        toggleMyArrayList_toStringMethod();
        int num;
        while (true) {
            num = getRandomNumberFromRange(0, 10000);
            if (myArrayList.indexOf(num) == -1)
                break;
        }
        String test = "Check the index of a element not in the MyArrayList (" + num + ")\n" + myArrayList.toString();
        compareTestCaseAndStoreIt(test, -1, myArrayList.indexOf(num));
        toggleMyArrayList_toStringMethod();
    }



    private void test9() {
        toggleMyArrayList_toStringMethod();
        String test = "Check the size of the empty array";
        String accepted = "0";
        myArrayList.clear();
        int output = myArrayList.size();
        compareTestCaseAndStoreIt(test, accepted, output);
        toggleMyArrayList_toStringMethod();
    }

    private void test10(){
        toggleMyArrayList_toStringMethod();
        String test = "Check the sum of the elements in the MyArrayList";
        myArrayList.clear();
        int sum=0;
        for(int i=0;i<10;i++){
            int val = getRandomNumberFromRange(0,10000);
            myArrayList.insertSorted(val);
            sum+=val;
        }
        compareTestCaseAndStoreIt(test+"\nArray List : "+myArrayList.toString(),sum,myArrayList.sum());
        toggleMyArrayList_toStringMethod();
    }

    @Override
    public String toString(){
        String className = this.getClass().getName();
        String description = "Has a method named testMe(MyArrayList myArrayList, Results results)";
        String str = String.format("\nClass : %s\nMethod toString()\nDescription : %s \n",className,description) ;
        System.out.println(str);
        return str;
    }

}
