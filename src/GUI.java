import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    ImageIcon logo = new ImageIcon("src/assets/cblooded1.jpeg");
    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
    JPanel panel = new JPanel();

    JLabel calendarLbl = new JLabel();

    public GUI() {
        setTitle("Operations Calendar");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setIconImage(logo.getImage());
        getContentPane().setBackground(new Color(128, 0, 32));

        calendarLbl.setText("CALENDAR");
        calendarLbl.setBounds(0, 0, 1080, 50);
        calendarLbl.setHorizontalAlignment(JLabel.CENTER);
        add(calendarLbl);

        CalendarPanel calendarPanel = new CalendarPanel();
        add(calendarPanel);
    }
}
