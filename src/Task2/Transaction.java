
package Task2;


public class Transaction {
    private int id;
    private Stock stock;
    private int quantity;
    private User user;
    private String type;
    private static int count = 0;
       
    
    public Transaction(Stock s , User u,int quantity , String type){
        this.id=count++;
        this.stock=s;
        this.user=u;
        this.quantity=quantity;
        this.type=type.toLowerCase();
        
        if(this.type.equals("buy")){
            s.setQuantity(s.getQuantity()-quantity);
            u.setBalance(u.getBalance()-(s.getPrice()*quantity));
        }
        else {
           s.setQuantity(s.getQuantity()+quantity);
           Stock stock = Stock.getStock(s.getSymbol());
           if(stock ==null)
               Stock.addStock(s);
           u.setBalance(u.getBalance()+(s.getPrice()*quantity));
        }
    }
    public int getId(){
        return this.id;
    }
    public Stock getStock(){
        return this.stock;
    }
    public int getQuantity(){
        return this.quantity;
    } 
    public String getType(){
        return this.type;
    }
    
}
