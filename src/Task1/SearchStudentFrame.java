
package Task1;
import java.awt.*;
import javax.swing.*;

public class SearchStudentFrame {
    
    public SearchStudentFrame(){
        JPanel panel = new JPanel();
        panel.add(new Label("Student name : "));
        JTextField nameField = new JTextField(15);
        panel.add(nameField);
        
        int res = JOptionPane.showConfirmDialog(null, panel,"Search a student" , JOptionPane.OK_CANCEL_OPTION);
        
        if(res == JOptionPane.OK_OPTION){
            String name = nameField.getText();
            Student s= Student.searchStudent(name);
            if(s==null){
                JOptionPane.showMessageDialog(null,"Stuent Not Found ! ","",JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, " Student name :  "+s.getName() + " \n Grade : "+s.getGrade()+" ", "Student ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
