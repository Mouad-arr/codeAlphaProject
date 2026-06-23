package Task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String symbol ;
    private String name ;
    private double price ;
    private int quantity ;
    private static List<Stock> stocks = new ArrayList<>();
    
    public Stock(String symbol,String name,double price , int quantity){
        this.symbol=symbol;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        if(this.quantity>0)
            Stock.addStock(this);
    }
    
    public void setNewPrice(double price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
        if(this.quantity>0 && Stock.getStock(this.symbol)==null)
            stocks.add(this);
        else if(this.quantity==0){
            Stock.removeStock(this.symbol);
        }
            
    }
    public String getSymbol(){
        return this.symbol;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    
    
   
    
    public static boolean addStock(Stock s){
        if(Stock.getStock(s.getSymbol())!=null || s.getQuantity()==0)
            return false;
        stocks.add(s);
        return true;
    }
    public static boolean removeStock(String symbol){
        for(Stock s : stocks){
            if(s.getSymbol().equals(symbol)){
                stocks.remove(s);
                //Stock.saveStocks(stocks);
                return true;
            }
        }
        return false;
    }
    
    public static Stock getStock(String symbol){
        for(Stock s:stocks){
            if(s.getSymbol().equals(symbol))
                return s;
        }
        return null;
    }
    
    public static List<Stock> getStocks(){
        return stocks;
    }
    
    public static void loadStocks(){
        try (BufferedReader br = new BufferedReader(new FileReader("stocks.txt"))) {
            String line;

            while ( ( line = br.readLine() ) != null ) {
                String[] parts = line.split(",");
                
                String symbol = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                new Stock(symbol, name, price, quantity );
            }
            

        } catch (IOException e) {
            
        }
         
    }
    public static void loadStocksFromDb(){
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:stocks.db");  
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("select * from stock");
                ){
            while(res.next()){
                new Stock(res.getString("symbol"),res.getString("name"),res.getDouble("price"),res.getInt("quantity"));
            }
            
        }catch(SQLException e){}
    }
    public static void saveStocksInDb(List<Stock> stocks){
         String updateSql = "UPDATE stock SET price = ?, quantity = ? WHERE symbol = ?";
        String insertSql = "INSERT INTO stock(symbol, name, price,quantity) VALUES(?, ?, ?, ?)";
         try( Connection conn = DriverManager.getConnection("jdbc:sqlite:stocks.db");  ){
            conn.setAutoCommit(false);
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                 PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                for(Stock stock : stocks){

                    updateStmt.setDouble(1, stock.getPrice());
                    updateStmt.setInt(2, stock.getQuantity());
                    updateStmt.setString(3, stock.getSymbol());
                    
                    int rowsUpdated = updateStmt.executeUpdate();
                    if (rowsUpdated == 0) {
                        insertStmt.setString(1, stock.getSymbol());
                        insertStmt.setString(2, stock.getName());
                        insertStmt.setDouble(3, stock.getPrice());
                        insertStmt.setInt(4, stock.getQuantity());
                        insertStmt.executeUpdate();
                        
                    } 
                }
                conn.commit();     
                }catch(SQLException e){
                    throw e ;
                }
            
        }catch(SQLException e){}
    }
    
    public static void saveStocks(List<Stock> stocks) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("stocks.txt"))) {

            for (Stock s : stocks) {

                bw.write(
                    s.getSymbol() + "," +
                    s.getName() + "," +
                    s.getPrice() + "," +
                    s.getQuantity()
                );

                bw.newLine();
            }

        } catch (IOException e) {
            
        }
    }
}
