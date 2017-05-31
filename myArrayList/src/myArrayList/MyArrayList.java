package myArrayList;

import java.util.Arrays;

class MyArrayList {
	private int[] array;
	private int count;

	MyArrayList() {
		this.array = new int[50];
		for (int i = 0; i < 50; i++) {
			this.array[i] = Integer.MAX_VALUE;
		}
		this.count = 0;
	}

	public void insertSorted(int newValue) {
		if (this.count == this.array.length) {
			int[] temp = this.array;
			int newSize = array.length + 25;
			this.array = new int[newSize];
			int counter = 0;
			for (int i = 0; i < this.array.length; i++) {
				if (i < count)
					this.array[i] = temp[i];
				else
					this.array[i] = Integer.MAX_VALUE;
			}

		}
		this.array[this.count++] = newValue;

		Arrays.sort(this.array);
	}

	public void removeValue(int value) {
		int counter = this.indexOf(value);

		if (counter > -1) {
			for (int i = counter + 1; i < this.size(); i++) {
				this.array[i - 1] = this.array[i];
			}
			this.array[this.count--] = Integer.MAX_VALUE;
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
		return this.count;
	}

	@Override
	public String toString() {
		StringBuilder sbr = new StringBuilder("\n");
		for (int i = 0; i < this.size(); i++) {
			sbr.append(this.array[i] + " ");
		}
		sbr.append("\n");
		return sbr.toString();
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < this.count; i++) {
			System.out.print(this.array[i] + " ");
		}
	}

	public static void main(String[] args) {
		MyArrayList A = new MyArrayList();

		for (int i = 0; i < 51; i++) {
			A.insertSorted(i + 1);
		}
		A.insertSorted(10);
		for (int i = 10; i < 25; i++)
		A.removeValue(51);
		System.out.println(A.indexOf(1));
		System.out.println(A.sum());
		System.out.println(A.toString());
	}
}