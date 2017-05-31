package myArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {
	private int[] array;
	private int size;

	public MyArrayList() {
		this.array = new int[50];

		for (int i = 0; i < 50; i++) {
			this.array[i] = Integer.MAX_VALUE;
		}
		this.size = 0;
	}

	public void insertSorted(int newValue) {
        int [] temp = this.array;

        if(this.size() == this.array.length)
            this.array = new int[25+this.size()];
        else
            this.array = new int[this.array.length];
        int i=0;
		for( ;i<this.size();i++){
		    if(newValue<temp[i])break;
            this.array[i]=temp[i];
        }
        this.array[i]=newValue;
        this.size++;
        int  j=i+1;
        for(;j<this.size();j++){
            this.array[j]=temp[i];
            i++;
        }
	}

	public void removeValue(int value) {

		int counter=-1;
		while ((counter = this.indexOf(value)) > -1) {
			//int counter = this.indexOf(value);
			for (int i = counter + 1; i < this.size(); i++) {
				this.array[i - 1] = this.array[i];
			}
			this.array[this.size--] = Integer.MAX_VALUE;
		}
	}

	public int indexOf(int value) {

		for (int i = 0; i < this.size(); i++) {
			if (value == this.array[i])
				return i;
		}
		return -1;
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < this.size(); i++) {
			sum += this.array[i];
		}
		return sum;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder("\n");
		for (int i = 0; i < this.size(); i++) {
			sbr.append(this.array[i] + " ");
		}
		sbr.append("\n");
		String str = sbr.toString();
        System.out.println(str);
		return str;
	}

//	public void display() {
//		System.out.println();
//		for (int i = 0; i < this.size(); i++) {
//			System.out.print(this.array[i] + " ");
//		}
//	}
//
//	public static void main(String[] args) {
//		MyArrayList A = new MyArrayList();
//
//		for (int i = 0; i < 51; i++) {
//			A.insertSorted(i + 1);
//		}
//		A.insertSorted(10);
//		for (int i = 10; i < 25; i++)
//		A.removeValue(51);
//		System.out.println(A.indexOf(1));
//		System.out.println(A.sum());
//		System.out.println(A.toString());
//	}
}