import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final GUI gui;

    public MenuPanel(GUI gui) {
        this.gui = gui;

        setBounds(0,0,gui.getWidth()/4,gui.getHeight());
        setBackground(Color.DARK_GRAY);
    }
}
