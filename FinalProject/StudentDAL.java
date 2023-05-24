package Assignment.FinalProject;

import java.io.*;
import java.util.ArrayList;

public class StudentDAL {
    final String filePath = "Student.txt";
    private void WriteData(String lineToAppend,boolean Append){
        try{
            FileOutputStream f = new FileOutputStream(filePath, Append);

            byte[] byteArr = lineToAppend.getBytes();
            f.write(byteArr);
            f.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> Find(boolean AllButThisID, String ID){
        ArrayList<String > str = new ArrayList<String>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = br.readLine()) != null) {
                if ((AllButThisID && !line.split(",")[0].toString().equals(ID.toString())) || (!AllButThisID && line.split(",")[0].toString().equals(ID.toString()) )) {
                str.add(line);}
            }
            fr.close();         //Closes the stream and release the resources
        } catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
    public ArrayList<String> Search(String ID, String Name, double MG) {
        ArrayList<String> str = new ArrayList<String>();
        try{
            File file = new File(filePath);    // Creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr); //Creates a buffering character input stream
            StringBuffer sb = new StringBuffer();       //Constructs a String buffer with no characters
            String line;

            str.add(br.readLine());
            while((line = br.readLine())!=null){
                String stdID = line.split(",")[0].toString();
                String stdName = line.split(",")[1].toString();
                double stdMG = Double.parseDouble(line.split(",")[2].toString());

                /**
                 * Implement
                 */
                if ((stdID.equals(ID.toString())&& !ID.toString().equals("") || (stdName.contains(Name.toString()) && !Name.toString().equals("")) || (stdMG == MG && MG !=0) )){
                    str.add(line);}}
                fr.close();
            }catch (IOException e){
                e.printStackTrace();
        }
        return str;

    }

}
