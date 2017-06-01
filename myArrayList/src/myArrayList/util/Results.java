package myArrayList.util;

import java.io.File;

public class Results implements StdoutDisplayInterface,FileDisplayInteface{


    @Override
    public void writeToStdout(String str) {
        System.out.println(str);
    }

    @Override
    public void writeToFile(String str) {
        String path = String.format("%s/myArrayList/src/myArrayList/store/%s",System.getProperty("user.dir"),"output.txt");
        System.out.println(path);
        File file=null;
        file = new File(path);

        if(file.exists() && !file.isDirectory()){
            System.out.println(path);
        }

    }
}