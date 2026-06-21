
package Task2;

import javax.swing.*;


public class SellFrame {
    
    public SellFrame(User user){
        if(user.getPortfolioValue()<=0){
            JOptionPane.showMessageDialog(null,"No stocks to sell ! ","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JTextField symbolField = new JTextField(15);
            JTextField quantityField = new JTextField(15);

            JPanel panel = new JPanel();
            panel.add(new JLabel("Stock Symbol : "));
            panel.add(symbolField);
            panel.add(new JLabel("Quantity : "));
            panel.add(quantityField);

            int result = JOptionPane.showConfirmDialog(null,panel,"Sell a stock",JOptionPane.OK_CANCEL_OPTION);
            if(result==JOptionPane.OK_OPTION){
                String symbol= symbolField.getText();
                if(symbol.isEmpty())
                    JOptionPane.showMessageDialog(null,"Enter a valid Symbol !","Error", JOptionPane.ERROR_MESSAGE);
                else{
                    try{
                        int quantity = Integer.parseInt(quantityField.getText());
                        if(quantity<=0){
                            throw new Exception();
                        }
                        boolean res = user.sell(symbol, quantity);
                        if(res){
                            JOptionPane.showMessageDialog(null,"Transaction completed successfully. ","Succes", JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Transaction failed.  ","Failure", JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(Exception e){
                         JOptionPane.showMessageDialog(null,"Quantity must be a positive integer !","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        new MainFrame(user);
    }
}
