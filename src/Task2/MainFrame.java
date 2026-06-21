
package Task2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
public class MainFrame extends JFrame{

    public MainFrame(User user){
        
 
        
        
        
        JPanel header = new JPanel(new GridBagLayout());
        JLabel label = new JLabel();
        label.setText("Stock Trading Platform  ");
        label.setFont(new Font("MyFont",Font.BOLD,30));
        label.setForeground(Color.WHITE);
        header.add(label);
        header.setPreferredSize(new Dimension(60,60));
        header.setBackground(new Color(0x1E3A8A));
        
        JPanel stockPanel = new JPanel(new BorderLayout(5, 5));
        stockPanel.setBorder(BorderFactory.createTitledBorder("Available Stocks"));
        
        List<Stock> availableStocks = Stock.getStocks();
        if(availableStocks.isEmpty()){
            stockPanel.add(new JLabel("No stock Availble !",SwingConstants.CENTER));
        }
        else{
            DefaultTableModel model = new DefaultTableModel( new String[]{"Symbol", "Name" , "Price" , "Quantity"}, 0);
            for(Stock s : availableStocks)
                model.addRow(new Object[]{s.getSymbol(),s.getName(),s.getPrice(),s.getQuantity()});
            JTable stockTable = new JTable(model);
            stockTable.setEnabled(false);
            int rowHeight = stockTable.getRowHeight();
            int headerHeight = stockTable.getTableHeader().getPreferredSize().height;
            int preferredHeight = (availableStocks.size() * rowHeight) + headerHeight + 5;
            int preferredWidth = 320;
       
            stockTable.setPreferredScrollableViewportSize(new Dimension(preferredWidth, preferredHeight));
            stockPanel.add(new JScrollPane(stockTable), BorderLayout.CENTER);
            
        }
        
        DefaultTableModel modelP = new DefaultTableModel(new String[]{"Balance" , "Portfolio Value"} , 0);
        modelP.addRow(new Object[]{user.getBalance(),user.getPortfolioValue()});
        JTable tabelP = new JTable(modelP);
        tabelP.setEnabled(false);
        tabelP.setPreferredScrollableViewportSize(new Dimension(200,30));
        JPanel panelp = new JPanel(new GridLayout(5, 1, 5, 5));
        panelp.setBorder(BorderFactory.createTitledBorder("Your Account"));
        panelp.add(new JScrollPane(tabelP),BorderLayout.CENTER);
        
       
        
        JButton buyBtn = new JButton("Buy a stock");
        JButton sellBtn = new JButton("Sell a stock");
        JButton portBtn = new JButton("Show My Portfolio");
        JButton showHistory = new JButton("Show My Historic");
        
        buyBtn.setFocusable(false);
        sellBtn.setFocusable(false);
        portBtn.setFocusable(false);
        showHistory.setFocusable(false);
        
       
        buyBtn.addActionListener(e->{
            new BuyFrame(user);
            this.dispose();
        });
        sellBtn.addActionListener(e->{
            new SellFrame(user);
            this.dispose();
        });
        portBtn.addActionListener(e->{
            new PortfolioTable(user);
            this.dispose();
        });
        showHistory.addActionListener(e->{
            new HistoricTable(user);
            this.dispose();
        });
        
        panelp.add(buyBtn);
        panelp.add(sellBtn);
        panelp.add(portBtn);
        panelp.add(showHistory);
        
        this.setSize(700, 600);
        this.setLayout(new BorderLayout(10,30));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(header,BorderLayout.NORTH);
        this.add(stockPanel,BorderLayout.CENTER);
        this.add(panelp,BorderLayout.WEST);
        
       
 
        this.setVisible(true);
         
    }
}
