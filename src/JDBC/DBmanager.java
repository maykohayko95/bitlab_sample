package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBmanager {
    private Connection conn;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBC_Bitlab?useUnicode=true&serverTimezone=UTC","root", "");
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Items> getAllItems(){
        ArrayList<Items> items = new ArrayList<>();
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Items");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                items.add(new Items(id,name,price));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public void addItem(Items items){
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO Items(id, name, price) values(NULL,?,?)");
            st.setString(1,items.getName());
            st.setDouble(2,items.getPrice());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteItem(Long id){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM Items where id = ?");
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
