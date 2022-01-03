package BigProjectAvia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListFlights extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton back;
    private String header[] = {"ID", "AIRCRAFT ID", "DEPARTURE CITY ID", "ARRIVAL CITY ID", "DEPARTURE TIME", "ECONOM PRICE", "BUSINESS PRICE"};
    private JTable table;
    private JScrollPane scrollPane;

    public ListFlights(MainFrame parent) {
        this.parent = parent;
        setSize(1000, 1000);
        setLayout(null);

        label = new JLabel("LIST FLIGHTS");
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
                parent.getListCitiesPage().setVisible(false);
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
    public void generateTable(ArrayList<Flights> list){

        Object data[][] = new Object[list.size()][7];

        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getAircraftId();
            data[i][2] = list.get(i).getDepartureCityId();
            data[i][3] = list.get(i).getArrivalCityId();
            data[i][4] = list.get(i).getDepartureTime();
            data[i][5] = list.get(i).getEcoprice();
            data[i][6] = list.get(i).getBusprice();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
