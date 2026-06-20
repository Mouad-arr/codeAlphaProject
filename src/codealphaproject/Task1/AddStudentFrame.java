
package codealphaproject.Task1;
import java.awt.*;
import javax.swing.*;
public class AddStudentFrame  {
    
    public AddStudentFrame(){

        JTextField nameField = new JTextField(15);
        JTextField gradeField = new JTextField(15);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeField);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Enter Information",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            if(name.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Enter a valid name ! ","Error",JOptionPane.ERROR_MESSAGE);
            }
            try{
                double grade=Double.parseDouble(gradeField.getText().trim());
                Student.addStudent(new Student(name,grade));
                 JOptionPane.showMessageDialog(null,"The student was added succefully !","Succes", JOptionPane.PLAIN_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Grade must a double !","Error", JOptionPane.ERROR_MESSAGE);
            }
      
            
        }
    }
}

