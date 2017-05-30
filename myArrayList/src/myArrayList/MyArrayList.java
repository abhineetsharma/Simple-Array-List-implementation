package myArrayList;

import java.util.ArrayList;

class MyArrayList{
	private int [] array;
	private int count;

	MyArrayList(){
		this.array = new int[50];
		for(int a : this.array){
			a = Integer.MAX_VALUE;
		}
		this.count = 0;
	}

	public void insertSorted(int newValue){
		if(this.count == this.array.length){
			ArrayList<Integer> arli = new ArrayList<>();
			for(int a : array){
				arli.add(a);
			}
			int newSize = array.length + 25;
			this.array = new int[newSize];
			int counter=0;
			for(int a : arli){
				array[counter++] = a;
			}
			
		}
		this.array[count++]= newValue;
	}
	public void removeValue(int value){
		for(int i =0 ; i<count;i++){
			
		}
	}
	public void indexOf(int value){}
	public void sum(){}
	public void size(){}
	// public void display(){
	// 	System.out.println();
	// 	for(int i=0;i<count;i++){
	// 		System.out.print(this.array[i]+" ");
	// 	}
	// }

	// public static void main(String [] args){
	// 	MyArrayList A = new MyArrayList();

	// 	for(int i =0;i< 1000;i++){
	// 		A.insertSorted(i);
	// 	}
	// 	A.display();
	// }
	//public void toString(){}
}