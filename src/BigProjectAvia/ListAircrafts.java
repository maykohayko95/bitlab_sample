package BigProjectAvia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListAircrafts extends JPanel{
    private MainFrame parent;
    private JLabel label;
    private JButton back;
    private String header[] = {"ID", "NAME", "MODEL", "BUSINESS CLASS CAPACITY", "ECONOM CLASS CAPACITY"};
    private JTable table;
    private JScrollPane scrollPane;

    public ListAircrafts(MainFrame parent) {
        this.parent = parent;
        setSize(1000, 1000);
        setLayout(null);

        label = new JLabel("LIST AIRCRAFTS");
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
                parent.getListAircraftsPage().setVisible(false);
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
    public void generateTable(ArrayList<Aircrafts> list){

        Object data[][] = new Object[list.size()][5];

        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getName();
            data[i][2] = list.get(i).getModel();
            data[i][3] = list.get(i).getBusclasscap();
            data[i][4] = list.get(i).getEcoclasscap();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
