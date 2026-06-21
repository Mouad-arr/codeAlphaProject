package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User {
    private String name ;
    private double balance ;
    private Map<Stock,Integer> portfolio ;
    private List<Transaction> historic;
    
    public User(){
        this.portfolio = new HashMap<>();
    }
    public User(String name,double balance){
        this.name=name;
        this.balance=balance;
        this.portfolio = new HashMap<>();
        this.historic=new ArrayList<>();
    }
    
    public void setName(String name){
        this.name=name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public String getName(){
        return this.name;
    }
    public double getBalance(){
        return this.balance;
    }
    
    public boolean buy(String symbol,int shares){
        Stock s= Stock.getStock(symbol);
        if(s==null || s.getPrice()*shares > this.balance || s.getQuantity() < shares)
            return false;
        this.historic.add(new Transaction(s,this,shares,"Buy"));
        this.portfolio.put(s, shares+this.portfolio.getOrDefault(s, 0));
        return true;
    }
    public boolean sell(String symbol , int shares){
        Stock s=this.isStockExist(symbol);
        if( s==null || this.portfolio.get(s)<shares)
            return false;
        this.historic.add(new Transaction(s,this,shares,"Sell"));
        if(this.portfolio.get(s)-shares==0){
            this.portfolio.remove(s);
        }
        else
            this.portfolio.put(s,this.portfolio.get(s)-shares);
        return true;
    }
    
    public Stock isStockExist(String symbol){
        for(Stock s : portfolio.keySet()){
            if(s.getSymbol().equals(symbol))
                return s;
        }
        return null;
    }
    
    public Map<Stock,Integer> getPortfolio(){
        return this.portfolio;
    }
    public List<Transaction> getHistoric(){
        return this.historic;
    }
    public double getPortfolioValue(){
       return this.portfolio.entrySet().stream().reduce(0.0, (acc, entry)-> acc+ entry.getValue()*entry.getKey().getPrice(),Double::sum);
    }
}
