import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final ImageIcon logo = new ImageIcon("src/assets/cblooded1.jpeg");
    private final CalendarPanel calendarPanel;
    private final MenuPanel menuPanel;
    private boolean menuPanelVisible = false;
    public static final Color backgroundColor = new Color(18,32,35);
    public static final Color accentColor = new Color(46,204,65);

    public GUI() {
        setTitle("Operations Calendar");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(logo.getImage());
        getContentPane().setBackground(backgroundColor.darker());

        setLayout(null);

        JLabel title = new JLabel("Calendar");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.PLAIN, 30));
        title.setBounds(40, 0, 300, 40);
        add(title);

        calendarPanel = new CalendarPanel(this);
        calendarPanel.setBounds(40,40,getWidth()-80,getHeight()-120);
        add(calendarPanel);

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0,0,20,20);
        add(menuButton);
        menuPanel = new MenuPanel(this);

        menuButton.addActionListener(e -> {
            if (!menuPanelVisible && !calendarPanel.isPaused()) {
                calendarPanel.pause();
                add(menuPanel);
                menuPanel.repaint();
                menuPanelVisible = true;
            } else {
                remove(menuPanel);
                calendarPanel.unpause();
                repaint();
                calendarPanel.repaintDays();
                menuPanelVisible = false;
            }
        });
    }
    public CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }
}
