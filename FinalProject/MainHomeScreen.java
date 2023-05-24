package Assignment.FinalProject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainHomeScreen {

    public static void main(String[] args) {
        new WindowClass();
    }
}


    class WindowClass extends  JFrame {//implements ActionListener
        JFrame f;
        WindowClass() {
            JButton btnAdd = new JButton("Add Student");
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    new AddScr("Insert");
                }
            });
            JButton btnUpdate = new JButton("Update Student");
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    new AddScr("Update");
                }
            });
            JButton btnDelete = new JButton("Delete Student");
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    new AddScr("Delete");
                }
            });
            JButton btnSearch = new JButton("Search Student");
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    new AddScr("Search");
                }
            });

            GridLayout myGrid = new GridLayout(1, 4);
            add(btnAdd);add(btnUpdate);add(btnDelete);add(btnSearch);

            setSize(500, 100);
            setLayout(myGrid);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
        }
}


            //Implement

//            JButton addStd, findStd, delStd,updateStd;
//
//            addStd = new JButton("Add Students");
//            addStd.setBounds(15,10,100,50);
//            findStd = new JButton("Find Students");
//            findStd.setBounds(15,60,100,50);
//            delStd = new JButton("Del Students");
//            delStd.setBounds(15,110,100,50);
//            updateStd = new JButton("Update Stud's");
//            updateStd.setBounds(15,160,100,50);
//
//            addStd.addActionListener(this);
//
//            add(addStd);add(findStd);add(delStd);add(updateStd);
//
//            setSize(130,250);
//            setLayout(null);
//            setVisible(true);

    class AddScr extends JFrame{
//
        JFrame f1;
        AddScr(String Operation){

            JLabel lblID = new JLabel("Student ID :");
            JTextField txtID = new JTextField();
            JLabel lblName = new JLabel("Student Name :");
            JTextField txtName = new JTextField();
            JLabel lblMG = new JLabel("MIDTerm Grade :");
            JTextField txtMG = new JTextField();
            JLabel lblFG = new JLabel("Final Grade :");
            JTextField txtFG = new JTextField();
            JLabel lblPW = new JLabel("Project Work :");
            JTextField txtPW = new JTextField();
            JButton btnFind = new JButton("Find");
            JButton btnSave;

            if (Operation.equals("Insert")){
                btnSave = new JButton("Add");
            }else if (Operation == "Update"){
                btnSave = new JButton("Update");
            }else {
                btnSave = new JButton("Delete");
            }


            JLabel lbl = new JLabel("");

            btnSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    StudentBLL stdobj = new StudentBLL();

                    stdobj.setStdID(txtID.getText());
                    stdobj.setStdName(txtName.getText());
                    double mg = Double.parseDouble(txtMG.getText());
                    stdobj.setStdMG(mg);
                    double fg = Double.parseDouble(txtMG.getText());
                    stdobj.setStdMG(fg);
                    double fp = Double.parseDouble(txtMG.getText());
                    stdobj.setStdMG(fp);

                    if (Operation == "Insert"){
                        stdobj.Insert();
                        lbl.setText("New student was added!");
                    } else if (Operation == "Update") {
                        stdobj.Update();
                        lbl.setText("Student was updated!");
                    }else if (Operation == "Delete") {
                        stdobj.Delete();
                        lbl.setText("Student was deleted!");
                    }
                });






















            btnFind.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e){
                    if (Operation!="Search"){
                        StudentBLL std = new StudentBLL();
                        std.setStdID(txtID.getText());
                        ArrayList<String> list = std.find();

                        for(String item:list){
                            String [] values = item.split(",");
                            txtName.setText(values[1]);
                            txtMG.setText(values[2]);
                            txtFG.setText(values[3]);
                            txtPW.setText(values[4]);
                        }
                    }   else {
                        StudentBLL std = new StudentBLL();
                        std.setStdID(txtID.getText());
                        std.setStdName(txtName.getText());
                        double mg = Double.parseDouble(txtMG.getText());
                        std.setStdMG(mg);
                        ArrayList<String> list = std.Search();
                        new Search(list);
                    }

                    }

                });
            GridLayout myGrid;

                myGrid = new GridLayout(6,2);

                JLabel stdLBL = new JLabel("");
                add(lblID);add(txtID);
                add(lblName);add(txtName);
                add(lblMG);add(txtMG);
                if(Operation!="Serach"){
                    add("btnSave");
                }

                if (Operation != "Insert"){
                    add(btnFind);
                }
                add(lbl);
                setSize(400,400);
                setLayout(myGrid);
                setVisible(true);
                setLocationRelativeTo(null);

        }
    }
}

class Search extends JFrame{
    Search(ArrayList<String> alldata){
        JFrame f;

        String column[] = alldata.get(0).split(",");
        final int rows = alldata.size();
        String[][] data = new String[rows][column.length];

        for (int i = 1; i < rows; i++) {
            String[] row = alldata.get(i).split(",");
            for (int j = 0; j < column.length; j++) {
                data[i][j] = row[j];
            }
        }

        final JTable jt = new JTable(data,column);

        jt.setCellSelectionEnabled(true);
        ListSelectionModel select = jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String Data = null;
                    int[] row = jt.getSelectedRows();
                    int[] columns = jt.getSelectedColumns();

                }
            }
        });
    }
}





//        public void actionPerformed(ActionEvent e){
//
//        JButton btnAdd = new JButton("Add Student");
//        btnAdd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new AddScr("Insert");
//            }
//        });
//    }







