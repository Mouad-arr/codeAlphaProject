package Task1;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class DisplayStudentFrame {
    
    
    public DisplayStudentFrame(){
        List<Student> students = Student.getStudents();
        if(students.isEmpty()){
            JOptionPane.showMessageDialog(null,"No Students yet ! ","", JOptionPane.INFORMATION_MESSAGE);
        }else{
            DefaultTableModel model = new DefaultTableModel( new String[]{"Student", "Grade"}, 0);
            for(Student s : students){
                model.addRow(new Object[]{s.getName(),s.getGrade()});
            }
            JTable table = new JTable(model);
            table.setEnabled(false);
            
            int rowHeight = table.getRowHeight();
            int headerHeight = table.getTableHeader().getPreferredSize().height;
            int preferredHeight = (students.size() * rowHeight) + headerHeight + 5;
            int preferredWidth = 250;
        
            table.setPreferredScrollableViewportSize(new Dimension(preferredWidth, preferredHeight));
        
             
            JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
            statsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
            
            String[][] stats = {
            {"Average", String.format("%.2f",Student.getAverage())},
            {"Max", String.format("%.2f", Student.getMax())},
            {"Min", String.format("%.2f", Student.getMin())}
           };
            
           String[] statColumns = {"Statistic", "Value"};
           
            JTable statsTable = new JTable(stats, statColumns);
            statsTable.setEnabled(false);
            statsTable.setBackground(new Color(240, 248, 255)); 
            statsTable.setFont(new Font("Arial", Font.BOLD, 12));
            
            int statsHeight = (3 * statsTable.getRowHeight()) + statsTable.getTableHeader().getPreferredSize().height + 5;
            statsTable.setPreferredScrollableViewportSize(new Dimension(250, statsHeight));
            
             statsPanel.add(new JScrollPane(statsTable), BorderLayout.CENTER);
           
             
            JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
            mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
            mainPanel.add(statsPanel, BorderLayout.SOUTH);
            
            JFrame frame = new JFrame("Student Grades");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
            
        }
    }
}
