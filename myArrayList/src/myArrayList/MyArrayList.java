package myArrayList;


public class MyArrayList {
    private static final int INITIALSIZE = 50;
    private static final int MAXVALUE = Integer.MAX_VALUE;
    private static final int MIN = 0;
    private static final int MAX = 10000;
    private int[] array;
    private int size;
    private boolean printFlag;

    //Constructor
    public MyArrayList() {
        this.setArray(INITIALSIZE);
        this.clear();
        this.printFlag = true;
    }

    //Array accessor for the class
    private int[] getArray(){
        return array;
    }
    private void setArray(int length){
        array = new int[length];
    }
    private int getArrayElement(int index) {
        return array[index];
    }
    private int getArrayLength(){
        return array.length;
    }
    private void setArrayElement(int index,int val) {
        this.array[index] = val;
    }


    //
    // Helper Functions

    //Binary Search
    private int binarySearch(int value) {
        int start = 0;
        int end = size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value == getArrayElement(mid))
                return mid;
            if (value < getArrayElement(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    //Increase the capacity of the array by half
    private void increaseCapacity() {
        int incrementSize = size()/2;
        setArray(incrementSize + size());
        reinitializeArrayWithDefaultValues();
    }
    //Reinitialize the array and fill it with default Value(Integer.MAX_VALUE)
    private void reinitializeArrayWithDefaultValues() {
        setArray(getArrayLength());
        for (int i = 0; i < getArrayLength(); ) {
            setArrayElement(i++,MAXVALUE);
        }
    }
    private boolean validityOfNumber(int val) {
        return val >= MIN && val <= MAX;
    }

    public void togglePrintFlag() {
        this.printFlag = !printFlag;
    }

    //API function
    public void clear() {
        size = 0;
        reinitializeArrayWithDefaultValues();
    }

    public void insertSorted(int newValue) {
        if(validityOfNumber(newValue)){
            int[] temp = getArray();

            if (size() == getArrayLength())
                increaseCapacity();
            else
                reinitializeArrayWithDefaultValues();

            int i = 0;
            for (; i < size(); i++) {
                if (newValue < temp[i]) break;
                setArrayElement(i,temp[i]);
            }
            setArrayElement(i, newValue);
            size++;
            for (int j = i + 1;j < size(); j++) {
                setArrayElement(j,temp[i++]);
            }
        }
    }

    public void removeValue(int value) {
        int counter;
        while ((counter = indexOf(value)) > -1) {
            for (int i = counter + 1; i < size(); i++) {
                setArrayElement(i - 1 , getArrayElement(i));
            }
            setArrayElement(size--, MAXVALUE);
        }
    }

    public int indexOf(int value) {
        int index = binarySearch(value);
        while(index >0 && value == getArrayElement(index-1)){
            index--;
        }
        return index;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += getArrayElement(i);
        }
        return sum;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < size(); i++)
            sbr.append(getArrayElement(i)).append(" ");
        String str = sbr.toString().trim();
        String sumString = "The sum of all the values in the array list is: " + sum();
        if(printFlag){
            System.out.println(str);
            System.out.println(sumString);
        }
        return str;
    }



}