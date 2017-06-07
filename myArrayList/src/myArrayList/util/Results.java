package myArrayList.util;

import java.io.*;

public class Results implements StdoutDisplayInterface, FileDisplayInteface {

    private StringBuilder sbr;
    private String outputPath;

    public Results(String path) {
        this.sbr = new StringBuilder();
        this.setOutputPath(path);
    }

    private String getOutputPath() {
        return outputPath;
    }

    private void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    private String getString() {
        return sbr.toString().trim();
    }

    private void add(String str) {
        str = String.format("%s%s",str,"\n");
        sbr.append(str);
    }

    public void storeNewResult(Object obj) {
        String str =  obj.toString();
        writeToStdout(str);
        writeToFile(str);
    }

    @Override
    public void writeToStdout(String str) {
        System.out.println(str.toString());
    }

    @Override
    public void writeToFile(String str) {

        File file ;
        try {
            add(str);
            file = new File(getOutputPath());

            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(getOutputPath()), "utf-8"))) {
                String str1 = getString();
                writer.write(str1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error in printing into the output file");
            System.exit(0);
        }


    }


}