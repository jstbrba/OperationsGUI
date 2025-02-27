import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimelinePanel extends JPanel {

    private int day;
    private int month;

    public TimelinePanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Timeline");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel roomsPanel = new JPanel();
        roomsPanel.setLayout(new BoxLayout(roomsPanel, BoxLayout.Y_AXIS));

        roomsPanel.add(createRoomTimeline("Main Hall"));
        roomsPanel.add(createRoomTimeline("Small Hall"));
        roomsPanel.add(createRoomTimeline("Meeting Room 1"));
        roomsPanel.add(createRoomTimeline("Meeting Room 2"));
        roomsPanel.add(createRoomTimeline("Meeting Room 3"));
        roomsPanel.add(createRoomTimeline("Meeting Room 4"));
        roomsPanel.add(createRoomTimeline("Meeting Room 5"));

        JScrollPane scroll = new JScrollPane(roomsPanel);
        add(scroll, BorderLayout.CENTER);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            System.out.println("Exit attempt");
            ((CardLayout) getParent().getLayout()).show(getParent(), "Calendar");
        });
        add(exitButton, BorderLayout.SOUTH);
    }

    private JPanel createRoomTimeline(String room){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(room + " Events for Day " + day));
        panel.add(new JLabel("9:00 AM - Event 1 in " + room));

        return panel;
    }
}
