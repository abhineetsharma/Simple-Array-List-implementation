package myArrayList.util;

import java.io.*;


class FileProcessor{;
    private File file;
    private FileInputStream fstream;
    private BufferedReader br;
    FileProcessor(){
        br=null;
        file = new File("input.txt");
        if(file.exists() && !file.isDirectory()){
            try{
            fstream = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fstream));
            }catch (IOException ex){
                if(br!=null) try {
                    br.close();
                } catch (IOException e) {

                }
            }
        }
    }

    String readLine(){

        String strLine;
        if(file.exists() && !file.isDirectory()){

            try {
                if ((strLine = br.readLine()) != null)   {

                    return strLine;
                }else{
                    br.close();
                }
            } catch (IOException e) {

            }
        }
        return null;
    }
	
}