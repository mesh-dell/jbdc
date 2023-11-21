import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

public class login extends JFrame{
    static login l = new login();
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField usernameTf;
    private JPanel mainPanel;
    private JPasswordField passwordTf;

    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String username = usernameTf.getText();
                    String password = String.valueOf(passwordTf.getPassword());
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "****");
                    String sql = "select * from login where username=? AND password=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next())
                    {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        //Load main form
                        register r = new register();
                        r.setContentPane(r.mainPanel);
                        int width = 700, height = 400;
                        int x = (1368 - width) / 2;
                        int y = (768 - height) / 2;
                        r.setSize(width, height);
                        r.setBounds(x, y, width, height);
                        r.setVisible(true);
                        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        l.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Login Invalid");
                    }
                    con.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        });
    }

    public static void main(String[] args) {
//        login l = new login();
        l.setContentPane(l.mainPanel);
        int width = 550, height = 300;
        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        l.setSize(width, height);
        l.setBounds(x, y, width, height);
        l.setVisible(true);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
