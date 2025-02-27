import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    ImageIcon logo = new ImageIcon("src/assets/cblooded1.jpeg");
    private CardLayout cardLayout;
    private JPanel currentPanel;
    private CalendarPanel calendarPanel;

    JLabel calendarLbl = new JLabel();

    public GUI() {
        setTitle("Operations Calendar");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(cardLayout);
        setResizable(false);
        setIconImage(logo.getImage());
        getContentPane().setBackground(new Color(128, 0, 32));

        cardLayout = new CardLayout();
        currentPanel = new JPanel(cardLayout);

        calendarLbl.setText("CALENDAR");
        calendarLbl.setBounds(0, 0, 1080, 50);
        calendarLbl.setHorizontalAlignment(JLabel.CENTER);
        add(calendarLbl);

        calendarPanel = new CalendarPanel(this);
        currentPanel.add(calendarPanel);

        TimelinePanel timelinePanel = new TimelinePanel();
        currentPanel.add(timelinePanel, "Timeline");

        add(currentPanel);

    }
    public void viewTimeline(int day){
        cardLayout.show(currentPanel, "Timeline");
    }
    public void viewCalendar(){
        cardLayout.show(calendarPanel, "Calendar");
    }
}
