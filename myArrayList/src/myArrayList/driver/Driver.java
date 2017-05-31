package myArrayList.driver;

import myArrayList.MyArrayList;

public class Driver
{

	public static void main(String[] args) 
	{
		MyArrayList mArrli = new MyArrayList();
		for(int i =1;i<=30;i++)
            mArrli.insertSorted(i);

        mArrli.insertSorted(10);
        mArrli.insertSorted(10);
		mArrli.toString();
        for(int i =1;i<=20;i++){
            mArrli.removeValue(i);
        }
        mArrli.toString();

		System.out.println("Hello World");
	}
	
}
