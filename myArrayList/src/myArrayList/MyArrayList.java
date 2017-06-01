package myArrayList;

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList() {
        this.array = new int[50];

        this.reinitializeArray();
        this.size = 0;
    }

    private void increaseCapacity(){
        this.array = new int[25 + this.size()];
        this.reinitializeArray();
    }
    private void reinitializeArray(){
        this.array = new int[this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = Integer.MAX_VALUE;
        }
    }

    public void insertSorted(int newValue) {
        int[] temp = this.array;

        if (this.size() == this.array.length)
            this.increaseCapacity();
        else
            this.reinitializeArray();
        int i = 0;
        for (; i < this.size(); i++) {
            if (newValue < temp[i]) break;
            this.array[i] = temp[i];
        }
        this.array[i] = newValue;
        this.size++;
        int j = i + 1;
        for (; j < this.size(); j++) {
            this.array[j] = temp[i];
            i++;
        }
        temp = null;
    }

    public void removeValue(int value) {

        int counter = -1;
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

}