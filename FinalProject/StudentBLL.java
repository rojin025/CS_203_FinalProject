package Assignment.FinalProject;

import java.util.ArrayList;

public class StudentBLL {

    private String StdID = "";
    private String StdName = "";
    private double StdMG;
    private double StdFG;
    private double StdPW;




    public String getStdID() {
        return StdID;
    }

    public void setStdID(String stdID) {
        StdID = stdID;
    }

    public String getStdName() {
        return StdName;
    }

    public void setStdName(String stdName) {
        StdName = stdName;
    }

    public double getStdMG() {
        return StdMG;
    }
    public void Insert(){
        StudentDAL std = new StudentDAL();
        std.Insert(StdID,StdName,StdMG);
    }
    public ArrayList<String> Find(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> result = std.Find(false,StdID);
        return result;
    }
    public void Update(){
        StudentDAL std = new StudentDAL();
        std.Update(StdID,StdName,StdMG);
    }
    public void Delete(){
        StudentDAL std = new StudentDAL();
        std.Delete(StdID);
    }
    public ArrayList<String> Search(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.Search(StdID,StdName,StdMG);
        return list;
    }
    public void setStdMG(double stdMG) {
        StdMG = stdMG;
    }

    public double getStdFG() {
        return StdFG;
    }

    public void setStdFG(double stdFG) {
        StdFG = stdFG;
    }

    public double getStdPW() {
        return StdPW;
    }

    public void setStdPW(double stdPW) {
        StdPW = stdPW;
    }


}
