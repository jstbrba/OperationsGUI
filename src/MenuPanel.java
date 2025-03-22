import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
    private final GUI gui;

    public MenuPanel(GUI gui) {
        this.gui = gui;

        int width = gui.getWidth()/4;
        int height = gui.getHeight();

        setBounds(0,0,width,height);
        setBackground(GUI.backgroundColor);
        //setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setLayout(null);

        ImageIcon logo = new ImageIcon("src/assets/lmh_logo.png");
        Image scaledLogo = logo.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon logo2 = new ImageIcon(scaledLogo);
        JLabel logoLabel = new JLabel(logo2);

        logoLabel.setBounds(0,0,width/3,width/3);
        add(logoLabel);

        JLabel userLabel = new JLabel("[username]");
        userLabel.setBounds(width/3,0,width*2/3,width/3);
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
        add(userLabel);

        JPanel linePanel = new JPanel();
        linePanel.setBounds(10,90,width-20,1);
        linePanel.setBackground(Color.white);
        add(linePanel);

        String[] menuItems = {"Profile","Settings","History","Finance Tracker","Logout"};
        for (int i = 0; i < menuItems.length; i++) {
            MenuItem menuItem = new MenuItem(menuItems[i]);
            menuItem.setBounds(10,100 + 30 * i,width-20,30);
            menuItem.setPreferredSize(new Dimension(width,40));
            add(menuItem);
        }

    }
    private class MenuItem extends JLabel {
        public MenuItem(String item) {
            super(item);

            setText(item);
            setFont(new Font("SansSerif", Font.PLAIN, 15));
            setForeground(Color.white);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    gui.getMenuUI().changeCard(item.toLowerCase());
                    gui.getMenuUI().changeVisibility(true);
                    gui.getMenuUI().repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setForeground(GUI.accentColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setForeground(Color.white);
                }
            });
        }
    }
}
