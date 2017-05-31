package myArrayList.util;

public class Results implements StdoutDisplayInterface,FileDisplayInteface{


    @Override
    public void writeToStdout(String s) {
        System.out.println(s);
    }

    @Override
    public void writeToFile(String s) {

    }
}