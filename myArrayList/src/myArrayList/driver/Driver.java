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
        MyArrayListTest myArrayListTest;
        try {
            if (args != null && args.length == 2) {

                iPath = args[0];
                oPath = args[1];
                myArraylist = new MyArrayList();
                result = new Results(oPath);
                fPro = new FileProcessor(iPath);
                myArrayListTest = new MyArrayListTest();

                while ((str = fPro.readLine()) != null) {
                    try {
                        int val = Integer.parseInt(str);
                            myArraylist.insertSorted(val);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        System.exit(0);
                    }
                }
                myArrayListTest.testMe(myArraylist, result);
                result.writeToStdout();
                result.writeToFile();
            } else {
                System.out.println("Arguments not passed correctly");
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
    @Override
    public String toString(){
        String className = this.getClass().getName();
        String description = "This has the main(...) function. \nIt create the MyArrayList instance and a Results instance, and call the testMe method on a MyArrayListTest instance. \nNext, it prints the String stored in the Results instance";
        String str = String.format("\nClass : %s\nMethod toString()\nDescription : %s\n",className,description );
        System.out.println(str);
        return str;
    }

}
