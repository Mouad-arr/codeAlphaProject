
package Task2;

import javax.swing.*;
import java.awt.*;

public class UserInfoFrame {
    
    public UserInfoFrame(){
        
        JTextField nameField = new JTextField(15);
        JTextField balanceField = new JTextField(15);
        
        JPanel panel = new JPanel(new GridLayout(4,1));
        panel.add(new JLabel("Your name : "));
        panel.add(nameField);
        panel.add(new JLabel("Your balance : "));
        panel.add(balanceField);
        
        int result = JOptionPane.showConfirmDialog(null,panel,"Enter your informations ",JOptionPane.OK_CANCEL_OPTION);
        
        if(result==JOptionPane.OK_OPTION){
            String name = nameField.getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter a valid name ! ","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    double balance=Double.parseDouble(balanceField.getText().trim());
                    User user = new User(name,balance);
                    new MainFrame(user);

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Enter a valid balance !","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
 
    
   }   
}
