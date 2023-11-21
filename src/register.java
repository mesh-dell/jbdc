import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class register extends JFrame{
    JPanel mainPanel;
    private JTextField idNo;
    private JTextField name;
    private JTextField dob;
    private JButton registerBtn;

    public register() {
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "****");
                    String sql = "INSERT INTO owner(IDNO, NAMES, DOB) VALUES(?,?,?)";
                    PreparedStatement pr = con.prepareStatement(sql);
                    pr.setString(1, idNo.getText());
                    pr.setString(2, name.getText());
                    pr.setString(3, dob.getText());
                    int count = pr.executeUpdate();
                    System.out.println(idNo.getText());
                    //com.mysql.cj.jdbc.Driver;
                    if (count==1)
                    {
                        JOptionPane.showMessageDialog(null, "Record added successfully");
                        con.close();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No record added");
                        con.close();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        register r = new register();
        r.setContentPane(r.mainPanel);
        int width = 700, height = 400;
        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        r.setSize(width, height);
        r.setBounds(x, y, width, height);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
