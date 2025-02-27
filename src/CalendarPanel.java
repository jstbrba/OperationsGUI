import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalendarPanel extends JPanel {
    private final GUI gui;
    public CalendarPanel(GUI gui) {
        this.gui = gui;
        //setSize(800, 600);
        setBounds(40,40,1000,640);
        setLayout(new GridLayout(4,7));

        for (int day = 1; day <= 28; day++) {
            add(new DayPanel(1,day));
        }
    }
    private class DayPanel extends JPanel {

        private final int month;
        private final int day;

        public DayPanel(int day, int month){

            this.day = day;
            this.month = month;

            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(Color.black));
            setLayout(new BorderLayout());

            JLabel dayLabel = new JLabel(day + "/" + month);
            add(dayLabel, BorderLayout.CENTER);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    gui.viewTimeline(day);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(Color.WHITE);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(Color.LIGHT_GRAY);
                }
            });
        }
    }
}
