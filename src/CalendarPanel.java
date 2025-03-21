import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalendarPanel extends JPanel {
    private final GUI gui;
    private final DayPanel[] days = new DayPanel[28];
    private final Color dayPanelColor = Color.DARK_GRAY;

    private boolean isPaused = false;

    public CalendarPanel(GUI gui) {
        this.gui = gui;
        //setSize(800, 600);
        setBounds(40,40, gui.getWidth()-100, gui.getHeight()-120);
        setLayout(new GridLayout(4,7));

        for (int day = 1; day <= 28; day++) {
            DayPanel newDay = (new DayPanel(day,3));
            add(newDay);
            days[day - 1] = newDay;
        }
    }
    private class DayPanel extends JPanel {

        private final int month;
        private final int day;
        private final TimelinePanel timelinePanel;

        public DayPanel(int day, int month){

            this.day = day;
            this.month = month;
            timelinePanel = new TimelinePanel(gui,day,month);

            setBackground(dayPanelColor);
            setBorder(BorderFactory.createLineBorder(Color.black));
            setLayout(new BorderLayout());

            JLabel dayLabel = new JLabel(day + "/" + month);
            dayLabel.setForeground(Color.WHITE);
            add(dayLabel, BorderLayout.CENTER);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!isPaused) {
                        gui.add(timelinePanel);
                        timelinePanel.repaint();
                        pause();
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!isPaused) {
                        setBackground(dayPanelColor);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!isPaused) {
                        setBackground(new Color(100,100,100));
                    }
                }
            });
        }
    }
    public void unpause() {
        isPaused = false;
    }
    public void pause() {
        isPaused = true;
    }
    public boolean isPaused() {
        return isPaused;
    }
    public void repaintDays() {
        for (DayPanel day : days) {
            day.setBackground(dayPanelColor);
        }
    }
}
