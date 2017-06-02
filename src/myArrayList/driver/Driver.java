package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {

    public static void main(String[] args) {
        MyArrayList myArrli = new MyArrayList();
        Results result = new Results();
        MyArrayListTest myArrliTest = new MyArrayListTest();
        FileProcessor fPro = new FileProcessor();
        String str;
        while ((str = fPro.readLine()) != null) {
            int val = 0;
            try {
                val = Integer.parseInt(str);
                myArrli.insertSorted(val);
            } catch (NumberFormatException ex) {
            }
        }
        str = null;

        myArrliTest.testMe(myArrli, result);
    }

}
