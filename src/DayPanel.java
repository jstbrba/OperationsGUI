import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class DayPanel extends JPanel {
    private final int month;
    private final int day;
    private final Timeline timeline;

    public DayPanel(int month, int day, CalendarPanel calendar) {
        this.month = month;
        this.day = day;
        timeline = new Timeline();
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel dayLbl = new JLabel(day + "/" + month);
        add(dayLbl, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new TimelineWindow(day,month);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE);
            }
        });
    }
}
