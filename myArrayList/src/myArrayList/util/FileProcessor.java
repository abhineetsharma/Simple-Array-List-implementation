package myArrayList.util;

import java.io.*;


public class FileProcessor {

    private File file;
    private FileInputStream fstream;
    private BufferedReader br;
    private String filePath;

    public FileProcessor(String path) {
        br = null;
        this.filePath = path;
        file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            try {
                fstream = new FileInputStream(file);
                br = new BufferedReader(new InputStreamReader(fstream));
            } catch (IOException ex) {
                if (br != null) try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        } else {
            System.out.println("input File not found");
            System.exit(1);
        }
    }

    public String readLine() {
        String strLine;
        if (file.exists() && !file.isDirectory()) {
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

    public String getFilePath() {
        return this.filePath;
    }
}