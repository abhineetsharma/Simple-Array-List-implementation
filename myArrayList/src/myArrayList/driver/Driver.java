package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {


    public static void main(String[] args) {

        if (args != null && args.length == 2) {

            String iPath = args[0];
            String oPath = args[1];
            MyArrayList myArrli = new MyArrayList();
            Results result = new Results(oPath);
            MyArrayListTest myArrliTest = new MyArrayListTest();
            FileProcessor fPro = new FileProcessor(iPath);
            String str;
            while ((str = fPro.readLine()) != null) {
                int val;
                try {
                    val = Integer.parseInt(str);
                    myArrli.insertSorted(val);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
            myArrliTest.testMe(myArrli, result);
        } else {
            System.out.println("Arguments not passed correctly");
            System.exit(1);
        }
    }

}
