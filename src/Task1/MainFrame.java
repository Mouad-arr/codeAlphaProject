
package Task1;


import java.awt.*;
import javax.swing.*;


public class MainFrame extends JFrame {
    
    
    public MainFrame(){
        JPanel header = new JPanel(new GridBagLayout());
        JLabel label = new JLabel();
        JPanel body = new JPanel(new GridLayout(4,1,50,10));
        JPanel right = new JPanel();
        JPanel left = new JPanel();
        JPanel buttom = new JPanel();
        
        JButton add = new JButton("Add a Student");
        JButton search = new JButton("Search a student");
        JButton display = new JButton("Display students");
        JButton exit = new JButton("Exit");
        
        add.setFocusable(false);
        search.setFocusable(false);
        display.setFocusable(false);
        exit.setFocusable(false);
        
       
        
        add.addActionListener(e->{
            new AddStudentFrame();
        });
        
        search.addActionListener(e->{
            new SearchStudentFrame();
        });
        display.addActionListener(e->{
            new DisplayStudentFrame();
        });
        exit.addActionListener(e->{
            this.dispose();
        });
        
        
        
        label.setText("Student Grade Tracker ");
        label.setFont(new Font("MyFont",Font.BOLD,30));
        label.setForeground(Color.WHITE);
        header.add(label);
        header.setPreferredSize(new Dimension(70,80));
        header.setBackground(new Color(0x1E3A8A));
        
        body.setPreferredSize(new Dimension(250,250));
        body.add(add);
        body.add(search);
        body.add(display);
        body.add(exit);
        
        
        right.setPreferredSize(new Dimension(50,50));
        left.setPreferredSize(new Dimension(50,50));
        buttom.setPreferredSize(new Dimension(50,50));
        
        this.setSize(1000, 500);
        this.setLayout(new BorderLayout(100,30));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(header,BorderLayout.NORTH);
        this.add(body,BorderLayout.CENTER);
        this.add(left,BorderLayout.EAST);
        this.add(right,BorderLayout.WEST);
        this.add(buttom,BorderLayout.SOUTH);
                
        
        this.setVisible(true);
    }
}
