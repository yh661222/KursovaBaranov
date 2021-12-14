package database;

import com.example.demo.Coffee;
import com.example.demo.Truck;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeRepository {


    public boolean SetCoffee(Coffee coffee){
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("CONNECTED");
            String SQL = "Select CoffeeName from Coffee where CoffeeName =?";
            PreparedStatement mystmnt = connection.prepareStatement(SQL);
            mystmnt.setString(1, coffee.getName());
            ResultSet rs = mystmnt.executeQuery();
            if(!rs.next()){
                try{
                    String SQL2 = "INSERT INTO Coffee (CoffeeName, Type, QualityClass,RoastingQuality,FlavorQuality,PricePerKg," +
                        "AmountKg) values(?, ?, ?,?,?,?,?)";
                    mystmnt = connection.prepareStatement(SQL2);
                    mystmnt.setString(1, coffee.getName());
                    mystmnt.setString(2, coffee.getType());
                    mystmnt.setString(3, coffee.getQuality());
                    mystmnt.setString(4, coffee.getRoast());
                    mystmnt.setString(5, coffee.getFlavor());
                    mystmnt.setInt(6, coffee.getPricePerKg());
                    mystmnt.setInt(7, coffee.getAmount());
                    mystmnt.executeUpdate();
                    return true;
            }catch (SQLException f){
                f.printStackTrace();}
            }
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return false;}

    public int LeftSpaceInTruck(){
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("CONNECTED");
            String SQL = "Select sum(AmountKg) from Coffee";
            Statement mystmnt = connection.createStatement();
            ResultSet rs = mystmnt.executeQuery(SQL);
            if(!rs.next()){
                return 0;
            }
            Truck truck = new Truck();
            int leftSpace = truck.getMaxVolume() - rs.getInt(1);
            return leftSpace;
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return 0;
    }

    public List<Coffee> ShowCoffee(Coffee coffee){
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";
        List<Coffee> list = new ArrayList<Coffee>();


        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("CONNECTED");
            String SQL = "Select CoffeeName,Type,QualityClass,RoastingQuality,FlavorQuality,PricePerKg,AmountKg from Coffee " +
                    "where Type like ? and QualityClass like ? and RoastingQuality like ? and FlavorQuality like ? ";
            PreparedStatement mystmnt = connection.prepareStatement(SQL);
            mystmnt.setString(1, coffee.getType());
            mystmnt.setString(2, coffee.getQuality());
            mystmnt.setString(3, coffee.getRoast());
            mystmnt.setString(4, coffee.getFlavor());
            ResultSet rs = mystmnt.executeQuery();
            while(rs.next()){
                Coffee ShowCoffee = new Coffee();
                ShowCoffee.setName(rs.getString("CoffeeName"));
                ShowCoffee.setType(rs.getString("Type"));
                ShowCoffee.setQuality(rs.getString("QualityClass"));
                ShowCoffee.setRoast(rs.getString("RoastingQuality"));
                ShowCoffee.setFlavor(rs.getString("FlavorQuality"));
                ShowCoffee.setPricePerKg(rs.getInt("PricePerKg"));
                ShowCoffee.setAmount(rs.getInt("AmountKg"));
                list.add(ShowCoffee);
            }
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return list;
    }

    public void DeleteCoffee(Coffee coffee){
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";
        try (Connection connection = DriverManager.getConnection(url)) {
            String SQL = "delete from Coffee where CoffeeName = ?";
            PreparedStatement mystmnt = connection.prepareStatement(SQL);
            mystmnt.setString(1, coffee.getName());
            mystmnt.executeUpdate();
        } catch (SQLException e) {
        System.out.println("error");
        e.printStackTrace();
    }
    }

    public void UpdateCoffee(Coffee coffee){
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";
        try (Connection connection = DriverManager.getConnection(url)) {
            String SQL = "update Coffee set Type = ? , QualityClass = ? , RoastingQuality = ? " +
                    ", FlavorQuality = ? , PricePerKg = ? , AmountKg = ? where CoffeeName = ?";
            PreparedStatement mystmnt = connection.prepareStatement(SQL);
            mystmnt.setString(1, coffee.getType());
            mystmnt.setString(2, coffee.getQuality());
            mystmnt.setString(3, coffee.getRoast());
            mystmnt.setString(4, coffee.getFlavor());
            mystmnt.setInt(5, coffee.getPricePerKg());
            mystmnt.setInt(6, coffee.getAmount());
            mystmnt.setString(7, coffee.getName());
            mystmnt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
