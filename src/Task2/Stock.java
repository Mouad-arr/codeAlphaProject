package Task2;

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
            stocks.add(this);
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
}
