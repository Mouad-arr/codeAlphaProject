
package Task2;

import java.sql.*;

public class Main {
    public static void main(String []args){
  
        
        //Stock.loadStocks();
        Stock.loadStocksFromDb();
        new UserInfoFrame();

        
    }
 
}
