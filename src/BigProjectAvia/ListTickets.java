package BigProjectAvia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListTickets extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JButton back;
    private String header[] = {"ID", "FLIGHT ID", "NAME", "SURNAME", "PASSPORT No", "TICKET TYPE"};
    private JTable table;
    private JScrollPane scrollPane;

    public ListTickets(MainFrame parent) {
        this.parent = parent;
        setSize(1000, 1000);
        setLayout(null);

        label = new JLabel("LIST TICKETS");
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
                parent.getListTicketsPage().setVisible(false);
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
    public void generateTable(ArrayList<Tickets> list){

        Object data[][] = new Object[list.size()][6];

        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getFlightId();
            data[i][2] = list.get(i).getName();
            data[i][3] = list.get(i).getSurname();
            data[i][4] = list.get(i).getPassportNumber();
            data[i][5] = list.get(i).getTicketType();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
