package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;

public class Driver
{

	public static void main(String[] args) 
	{
		MyArrayList myArrli = new MyArrayList();
        Results result = new Results();
        MyArrayListTest myArrliTest = new MyArrayListTest();
        FileProcessor fPro = new FileProcessor();
        String str = null;
        while ((str = fPro.readLine()) != null){
             int val =0;
             try{
                 val = Integer.parseInt(str);
                 myArrli.insertSorted(val);
             }catch (NumberFormatException ex){}
        }
        str = null;
        myArrli.toString();
        myArrliTest.testMe(myArrli,result);
	}
	
}
