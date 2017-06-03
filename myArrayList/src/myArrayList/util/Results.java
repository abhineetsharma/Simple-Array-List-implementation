package myArrayList.util;

import java.io.*;

public class Results implements StdoutDisplayInterface, FileDisplayInteface {

    private StringBuilder sbr;
    private String outputPath;
    public Results(String path) {
        this.sbr = new StringBuilder();
        this.outputPath = path;
    }

    private String getString() {
        return sbr.toString().trim();
    }

    private void add(String str) {
        this.sbr.append("\n" + str);
    }

    public void storeNewResult(Object obj) {
        String str =  obj.toString();
        this.writeToStdout(str);
        this.writeToFile(str);
    }

    @Override
    public void writeToStdout(String str) {
        System.out.println(str.toString());
    }

    @Override
    public void writeToFile(String str) {

        //String path = String.format("%s/myArrayList/src/myArrayList/store/%s", System.getProperty("user.dir"), "output.txt");

        File file ;
        try {
            this.add(str);
            file = new File(this.outputPath);

            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(this.outputPath), "utf-8"))) {
                String str1 = this.getString();
                writer.write(str1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}