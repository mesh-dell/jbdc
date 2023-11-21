import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class MainPage extends JFrame{
    private JPanel mainPanel;
    static MainPage m  = new MainPage();

    MainPage()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem viewRecords = new JMenuItem("View Records");
        JMenuItem insert = new JMenuItem("Insert Records");
        this.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(insert);
        menu.add(viewRecords);

        //Event listeners for switching frames
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                m.setVisible(false);
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
        });
        viewRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                m.setVisible(false);
                ViewRecords v = new ViewRecords();
                v.setContentPane(v.mainPanel);
                int width = 700, height = 400;
                int x = (1368 - width) / 2;
                int y = (768 - height) / 2;
                v.setSize(width, height);
                v.setBounds(x, y, width, height);
                v.setVisible(true);
                v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    public static void main(String[] args) {
        m.setContentPane(m.mainPanel);
        int width = 700, height = 400;
        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        m.setSize(width, height);
        m.setBounds(x, y, width, height);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
