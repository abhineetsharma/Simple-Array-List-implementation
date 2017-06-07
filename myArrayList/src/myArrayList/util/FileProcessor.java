package myArrayList.util;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;


public class FileProcessor {

    private String path;
    private File file;
    private BufferedReader br;

    public FileProcessor(String path) {
        this.path = path;
        initializeAndGetFileObject();
    }

    private BufferedReader initializeAndGetBufferedReaderObject(FileInputStream fStream){
        return new BufferedReader(new InputStreamReader(fStream));
    }

    private void initializeAndGetFileObject(){
        br = null;
        String path = getFilePath();
        file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            try {
                br = initializeAndGetBufferedReaderObject(new FileInputStream(file));
            } catch (IOException ex) {
                if (br != null) try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        } else {
            System.out.println("input File not found");
            System.exit(0);
        }
    }

    private String getFilePath() {
        return this.path;
    }

    public String readLine() {
        if (file.exists() && !file.isDirectory()) {
            String strLine;
            try {
                if ((strLine = br.readLine()) != null)
                    return strLine;
                else {
                    br.close();
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}