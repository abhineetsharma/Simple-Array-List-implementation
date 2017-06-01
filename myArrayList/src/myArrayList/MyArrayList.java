package myArrayList;


public class MyArrayList {
    private final int INITIALSIZE = 50;
    private final int INCREMENTSIZE = 25;
    private int[] array;
    private int size;

    //Constructor
    public MyArrayList() {
        this.array = new int[INITIALSIZE];
        this.clear();
    }

    //Helper Functions
    private int binarySearch(int value) {
        int start = 0;
        int end = this.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value == this.array[mid])
                return mid;
            if (value < this.array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private void increaseCapacity() {
        this.array = new int[INCREMENTSIZE + this.size()];
        this.reinitializeArrayWithDefaultValues();
    }

    private void reinitializeArrayWithDefaultValues() {
        this.array = new int[this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = Integer.MAX_VALUE;
        }
    }

    public void clear() {
        this.reinitializeArrayWithDefaultValues();
        this.size = 0;
    }

    public void insertSorted(int newValue) {
        int[] temp = this.array;

        if (this.size() == this.array.length)
            this.increaseCapacity();
        else
            this.reinitializeArrayWithDefaultValues();
        int i = 0;
        for (; i < this.size(); i++) {
            if (newValue < temp[i]) break;
            this.array[i] = temp[i];
        }
        this.array[i] = newValue;
        this.size++;
        int j = i + 1;
        for (; j < this.size(); j++) {
            this.array[j] = temp[i++];
        }
        temp = null;
    }

    public void removeValue(int value) {

        int counter = -1;
        while ((counter = this.binarySearch(value)) > -1) {
            //int counter = this.indexOf(value);
            for (int i = counter + 1; i < this.size(); i++) {
                this.array[i - 1] = this.array[i];
            }
            this.array[this.size--] = Integer.MAX_VALUE;
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.size(); i++)
            if (this.array[i] == value) return i;
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
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < this.size(); i++)
            sbr.append(this.array[i] + " ");
        String str = sbr.toString().trim();
        System.out.println(str);
        return str;
    }


}