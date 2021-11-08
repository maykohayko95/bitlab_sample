package MiniProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudent extends JPanel{
    private MainFrame parent;
    private JLabel label;
    private JButton back;
    private String header[] = {"ID", "NAME", "SURNAME", "AGE"};
    private JTable table;
    private JScrollPane scrollPane;

    public ListStudent(MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        label = new JLabel("STUDENTS LIST");
        label.setSize(300, 30);
        label.setLocation(100, 100);
        add(label);

        back = new JButton("BACK");
        back.setSize(300, 30);
        back.setLocation(100, 150);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getListStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);
    }
    public void generateTable(ArrayList<Students> list){

        Object data[][] = new Object[list.size()][4];

        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getSurname();
            data[i][3] = list.get(i).getAge();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
