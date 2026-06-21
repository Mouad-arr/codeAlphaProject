
package Task2;

import java.awt.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class PortfolioTable {
    
    public PortfolioTable(User user){
        
        Map<Stock,Integer> portfolio= user.getPortfolio();
        if(portfolio.isEmpty()){
            JOptionPane.showMessageDialog(null,"Your Portfolio is empty ! "," ",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            DefaultTableModel model = new DefaultTableModel( new String[]{"Symbol", "Name" , "Price" , "Shares"}, 0);
            for (Map.Entry<Stock, Integer> entry : portfolio.entrySet()) {
                model.addRow(new Object[]{entry.getKey().getSymbol(),entry.getKey().getName(),entry.getKey().getPrice(),entry.getValue()});
            }
            JTable table= new JTable(model);
            table.setEnabled(false);
            int rowHeight = table.getRowHeight();
            int headerHeight = table.getTableHeader().getPreferredSize().height;
            int preferredHeight = (portfolio.size() * rowHeight) + headerHeight + 5;
            int preferredWidth = 320;
       
            table.setPreferredScrollableViewportSize(new Dimension(preferredWidth, preferredHeight));
            JPanel panel = new JPanel(new BorderLayout(5,5));
            panel.add(new JScrollPane(table),BorderLayout.CENTER);
            JOptionPane.showMessageDialog(null,panel,"Portfolio",JOptionPane.OK_OPTION);
        }
        new MainFrame(user);
         
    }
}
