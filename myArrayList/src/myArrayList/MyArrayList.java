//package myArrayList;

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
		this.array[this.count++]= newValue;

		Array.sort(this.array);
	}
	public void removeValue(int value){
		int counter = -1;
		boolean flag = false;

		for(int i =0 ; i<this.count;i++){
			if(flag){
				this.array[i-1] = this.array[i];
			}
			else if(value == this.array[i]){
				counter = i;
				flag = true;
			}
		}
		if(counter>-1)this.count--;
	}
	public void indexOf(int value){}
	public void sum(){}
	public void size(){}
	public void display(){
		System.out.println();
		for(int i=0;i<this.count;i++){
			System.out.print(this.array[i]+" ");
		}
	}

	public static void main(String [] args){
		MyArrayList A = new MyArrayList();

		for(int i =0;i< 76;i++){
			A.insertSorted(i);
		}
		A.removeValue(10);
		A.removeValue(10);
		A.removeValue(100);
		A.removeValue(8);
		A.display();
	}
	//public void toString(){}
}