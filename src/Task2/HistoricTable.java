
package Task2;

import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HistoricTable {
        
    public HistoricTable(User user){
        List<Transaction> history = user.getHistoric();
        if(history.isEmpty()){
            JOptionPane.showMessageDialog(null,"No history yet ! "," ", JOptionPane.NO_OPTION);
        }
        else{
            DefaultTableModel model = new DefaultTableModel( new String[]{"Id", "Symbol" , "Name" , "Quantity","type","Total_Price"}, 0);
            for (Transaction h : history) {
                model.addRow(new Object[]{h.getId(),
                    h.getStock().getSymbol(),
                    h.getStock().getName(),
                    h.getQuantity(),
                    h.getType(),
                    h.getQuantity()*h.getStock().getPrice()});
            }
            JTable table= new JTable(model);
            table.setEnabled(false);
            int rowHeight = table.getRowHeight();
            int headerHeight = table.getTableHeader().getPreferredSize().height;
            int preferredHeight = (history.size() * rowHeight) + headerHeight + 5;
            int preferredWidth = 600;
       
            table.setPreferredScrollableViewportSize(new Dimension(preferredWidth, preferredHeight));
            JPanel panel = new JPanel(new BorderLayout(5,5));
            panel.add(new JScrollPane(table),BorderLayout.CENTER);
            JOptionPane.showMessageDialog(null,panel,"Historic",JOptionPane.OK_OPTION);
        }
        new MainFrame(user);
        
    }
}
