import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRecords extends JFrame{
    JPanel mainPanel;
    static ViewRecords v = new ViewRecords();

    ViewRecords()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem insert = new JMenuItem("Insert Records");
        this.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(insert);
        //Event listeners for switching frames
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                v.setVisible(false);
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

    }

    public static void main(String[] args) {
        v.setContentPane(v.mainPanel);
        int width = 700, height = 400;
        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        v.setSize(width, height);
        v.setBounds(x, y, width, height);
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
