import javax.swing.*;
import java.awt.*;

public class MenuUI extends JPanel {

    private final CardLayout cardLayout;
    private boolean visible = false;


    public MenuUI() {

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(new ProfilePanel(),"profile");
        add(new SettingsPanel(),"settings");
        add(new HistoryPanel(),"history");
        add(new FinancePanel(),"finance tracker");
        add(new LogoutPanel(),"logout");

        cardLayout.show(this, "profile");
        setVisible(true);
    }
    public boolean isVisible(){
        return visible;
    }
    public void changeVisibility(boolean visible){
        this.visible = visible;
    }
    public void changeCard(String card){
        cardLayout.show(this,card);
    }
    private static class ProfilePanel extends JPanel {
        public ProfilePanel() {
            setBackground(GUI.backgroundColor);
            JLabel profileLabel = new JLabel("Profile");
            profileLabel.setForeground(Color.WHITE);
            add(profileLabel);
        }
    }
    private static class SettingsPanel extends JPanel {
        public SettingsPanel() {
            setBackground(GUI.backgroundColor);
            JLabel settingsLabel = new JLabel("Settings");
            settingsLabel.setForeground(Color.WHITE);
            add(settingsLabel);
        }
    }
    private static class HistoryPanel extends JPanel {
        public HistoryPanel() {
            setBackground(GUI.backgroundColor);
            JLabel historyLabel = new JLabel("History");
            historyLabel.setForeground(Color.WHITE);
            add(historyLabel);
        }
    }
    private static class FinancePanel extends JPanel {
        public FinancePanel() {
            setBackground(GUI.backgroundColor);
            JLabel financeLabel = new JLabel("Finance Tracking");
            financeLabel.setForeground(Color.WHITE);
            add(financeLabel);
        }
    }
    private static class LogoutPanel extends JPanel {
        public LogoutPanel() {
            setBackground(GUI.backgroundColor);
            JLabel logoutLabel = new JLabel("Logout");
            logoutLabel.setForeground(Color.WHITE);
            add(logoutLabel);
        }
    }
}
