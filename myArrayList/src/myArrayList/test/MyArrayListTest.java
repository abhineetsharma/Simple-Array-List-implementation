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
        this.myArrayList = myArrayListObj;
    }

    private void initializeResultObj(Results result) {
        this.results = result;
    }

    public void testMe(MyArrayList myArrayListObj, Results result) {
        this.initializeMyArrayListObject(myArrayListObj);
        this.initializeResultObj(result);

        this.test1();
        this.test2();
        this.test3();
        this.test4();
        this.test5();
        this.test6();
        this.test7();
        this.test8();
        this.test9();
        this.test10();

    }

    private int getRandomNumberFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private void compareTestCase(String testCaseName, Object acceptedResult, Object outputResult) {
        String sCompare = this.stringCompare(acceptedResult.toString(), outputResult.toString()) ? "Passed" : "Failed";
        String str = String.format("%sTest Number : %d\n%s\nAspected : %s\nOutput : %s\nResult : %s\n%s",
                this.dash72,
                this.getCurrentTestNumber(),
                testCaseName,
                acceptedResult,
                outputResult,
                sCompare,
                this.dash72);
        this.results.storeNewResult(str);
    }

    private boolean stringCompare(String str1, String str2) {
        return str1.trim().equalsIgnoreCase(str2.trim());
    }

    private int getCurrentTestNumber() {
        return this.testNumber++;
    }

    private String generate72Dash() {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < 72; i++) sbr.append("-");
        sbr.append("\n");
        return sbr.toString();
    }

    private int[] getArrayFromMyArrayList(int bandwidth) {
        //System.out.println("gal "+ this.myArrayList.toString());
        String[] sArray = this.myArrayList.toString().split(" ");
        int[] arr = new int[sArray.length + bandwidth];
        int i = 0;
        for (int a : arr) {
            arr[i++] = Integer.MAX_VALUE;
        }
        i = 0;
        for (String s : sArray) {
            arr[i++] = Integer.parseInt(s);
        }
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
        String test = "Check the size of the array  after Insert a element in to the Array";
        int accepted = this.myArrayList.size() + 1;
        this.myArrayList.insertSorted(1);
        int output = this.myArrayList.size();

        this.compareTestCase(test, accepted, output);

    }

    private void test2() {
        int num = 22;
        String test = "Check if the element inserted into the array is inserted and sorted properly \nnumber to be inserted is " + num;
        int[] arr = this.getArrayFromMyArrayList(1);
        int sizeBefore = this.myArrayList.size();

        if (sizeBefore < arr.length) {
            arr[arr.length - 1] = num;
        }
        Arrays.sort(arr);

        String accepted = this.stringifyArray(sizeBefore + 1, arr);
        this.myArrayList.insertSorted(num);
        String output = this.myArrayList.toString();
        this.compareTestCase(test, accepted, output);
    }

    private void test3() {
        int[] arr = this.getArrayFromMyArrayList(0);
        int index = this.getRandomNumberFromRange(0, arr.length - 1);
        int num = arr[index];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) arr[i] = -1;
        }
        String test = "Check if the element removal from the array (" + num + ")";


        String accepted = stringifyArray(arr.length, arr);
        this.myArrayList.removeValue(num);
        String output = this.myArrayList.toString();
        this.compareTestCase(test, accepted, output);

    }

    private void test4() {
        int num = 100;
        String test = "Check by doing 2 insert of the same value (" + num + ")";

        int[] arr = this.getArrayFromMyArrayList(2);
        arr[arr.length - 2] = num;
        arr[arr.length - 1] = num;
        Arrays.sort(arr);


        String accepted = stringifyArray(arr.length, arr);
        this.myArrayList.insertSorted(num);
        this.myArrayList.insertSorted(num);
        String output = this.myArrayList.toString();
        this.compareTestCase(test, accepted, output);
    }

    private void test5() {
        int num = 22;
        String test = "Check to remove all instance of element from the array (2 instance of " + num + " will be entered and removed)";


        int[] arr = this.getArrayFromMyArrayList(2);

        arr[arr.length - 2] = num;
        arr[arr.length - 1] = num;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) arr[i] = -1;
        }


        String accepted = stringifyArray(arr.length, arr);
        this.myArrayList.insertSorted(num);
        this.myArrayList.insertSorted(num);
        this.myArrayList.removeValue(num);
        String output = this.myArrayList.toString();
        this.compareTestCase(test, accepted, output);

    }

    private void test6() {
        int size = 25;
        String test = "Check in a clean my myarraylist by " + size + " inserting random numbers from 0 to 10001";
        this.myArrayList.clear();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num = this.getRandomNumberFromRange(0, 10001);
            arr[i] = num;
            myArrayList.insertSorted(num);
        }
        Arrays.sort(arr);
        String accepted = stringifyArray(arr.length, arr);
        String output = this.myArrayList.toString();

        this.compareTestCase(test, accepted, output);
    }

    private void test7() {
        int[] arr = this.getArrayFromMyArrayList(0);
        int index = this.getRandomNumberFromRange(0, arr.length - 1);

        int num = arr[index];
        int accepted = index;
        String test = "Check the index of a known element inside a MyArrayList\n" + this.myArrayList.toString() + "\nfor element " + num + " index is " + index;

        int output = this.myArrayList.indexOf(num);
        this.compareTestCase(test, accepted, output);
    }

    private void test8() {
        int num;
        while (true) {
            num = this.getRandomNumberFromRange(0, 10000);
            if (this.myArrayList.indexOf(num) == -1)
                break;
        }
        String test = "Check the index of a element not in the MyArrayList (" + num + ")\n" + this.myArrayList.toString();
        this.compareTestCase(test, -1, this.myArrayList.indexOf(num));
    }

    private void test9() {
        String test = "Heavy test: 100 iteration of random insert and remove";
        StringBuilder sbr = new StringBuilder();
        this.myArrayList.clear();
        int[] arr = new int[100];
        for (int a = 0; a < arr.length; a++) arr[a] = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < 100; i++) {
            int num = this.getRandomNumberFromRange(1, 2);
            int value = this.getRandomNumberFromRange(0, 10000);

            switch (num) {
                case 1:
                    this.myArrayList.insertSorted(value);
                    sbr.append(" (+)" + value + " ");
                    arr[i] = value;
                    count++;
                    Arrays.sort(arr);
                    break;
                case 2:
                    this.myArrayList.removeValue(value);
                    sbr.append(" (-)" + value + " ");

                    int f = 0;
                    while (true) {
                        if (arr[f] == Integer.MAX_VALUE) break;
                        if (f == arr.length || arr[f] == Integer.MAX_VALUE) break;
                        else {
                            for (; f < arr.length; f++) {
                                if (arr[f] == Integer.MAX_VALUE) break;
                                if (value == arr[f]) {
                                    arr[f] = -1;
                                    if (count - 1 == -1) count = 0;
                                    else count--;
                                }
                            }
                        }

                    }
            }
        }
        String str = sbr.toString();
        String acc = this.stringifyArray(this.myArrayList.size(), arr);
        String out = this.myArrayList.toString();
        this.compareTestCase(test + "\n" + str, acc, out);
    }

    private void test10() {
        String test = "Check the size of the empty array";
        String accepted = "0";
        this.myArrayList.clear();
        int output = this.myArrayList.size();
        this.compareTestCase(test, accepted, output);
    }

}
