import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private final ImageIcon logo = new ImageIcon("src/assets/cblooded1.jpeg");
    private final CalendarPanel calendarPanel;
    private final MenuPanel menuPanel;
    private final MenuUI menuUI;
    private boolean menuPanelVisible = false;
    public static final Color backgroundColor = new Color(18,32,35);
    public static final Color accentColor = new Color(46,204,65);

    private Timer timer;

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

        menuUI = new MenuUI();
        menuUI.setBounds(getWidth()/3,20,getWidth()*2/3,getHeight()-40);
        add(menuUI);
        menuPanel = new MenuPanel(this);
        menuPanel.setBounds(-getWidth()/4,0,getWidth()/4,getHeight());
        add(menuPanel);

        menuButton.addActionListener(e -> {
            toggleMenuPanel();
            if (!menuPanelVisible && !calendarPanel.isPaused()) {
                calendarPanel.pause();
                menuPanel.repaint();
            } else {
                calendarPanel.unpause();
                if (menuUI.isVisible()){
                    menuUI.changeVisibility(false);
                }
                repaint();
            }
        });
    }
    public CalendarPanel getCalendarPanel() {
        return calendarPanel;
    }
    public MenuUI getMenuUI() {
        return menuUI;
    }

    public void toggleMenuPanel() {
        int targetX = menuPanelVisible ? -getWidth()/4 : 0;
        int step = menuPanelVisible ? -45 : 45;

        getContentPane().setComponentZOrder(menuPanel, 0);
        revalidate();
        repaint();

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = menuPanel.getX();
                if ((step > 0 && x >= targetX) || (step < 0 && x <= targetX)) {
                    timer.stop();
                    menuPanelVisible = !menuPanelVisible;
                } else {
                    menuPanel.setLocation(x + step, 0);
                    repaint();
                    System.out.println(menuPanelVisible);
                }
            }
        });
        timer.start();
    }
}
