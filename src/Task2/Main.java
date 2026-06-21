
package Task2;


public class Main {
    public static void main(String []args){
        //Stocks for test
        Stock.addStock(new Stock("App","Apple",12,120));
        Stock.addStock(new Stock("AAPL", "Apple", 1000, 120));
        Stock.addStock(new Stock("TSLA", "Tesla", 800, 250));
        Stock.addStock(new Stock("MSFT", "Microsoft", 1200, 180));
        Stock.addStock(new Stock("GOOG", "Google", 500, 300));
        Stock.addStock(new Stock("AMZN", "Amazon", 700, 220));
        Stock.addStock(new Stock("NVDA", "Nvidia", 900, 450));
        Stock.addStock(new Stock("META", "Meta", 600, 280));
        Stock.addStock(new Stock("NFLX", "Netflix", 400, 190));
        Stock.addStock(new Stock("INTC", "Intel", 1500, 90));
        Stock.addStock(new Stock("AMD", "AMD", 1000, 160));
        new UserInfoFrame();
    }
}
