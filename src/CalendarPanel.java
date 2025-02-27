import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends JPanel {
    public CalendarPanel() {
        //setSize(800, 600);
        setBounds(40,40,1000,640);
        setLayout(new GridLayout(4,7));

        for (int day = 1; day <= 28; day++) {
            add(new DayPanel(1,day,this));
        }
    }
}
