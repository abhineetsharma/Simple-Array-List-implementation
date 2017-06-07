package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;


public class Driver {

    public static void main(String[] args) {

        String iPath, oPath;
        MyArrayList myArraylist;
        Results result;
        FileProcessor fPro;
        String str;
        try {
            if (args != null && args.length == 2) {

                iPath = args[0];
                oPath = args[1];
                myArraylist = new MyArrayList();
                result = new Results(oPath);
                fPro = new FileProcessor(iPath);
                while ((str = fPro.readLine()) != null) {
                    try {
                        int val = Integer.parseInt(str);
                            myArraylist.insertSorted(val);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        System.exit(0);
                    }
                }
                new MyArrayListTest().testMe(myArraylist, result);
            } else {
                System.out.println("Arguments not passed correctly");
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

}
