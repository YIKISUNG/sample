package Clock;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class TimerPanel extends JPanel {

    private String dateString;
    private final SimpleDateFormat format;
    private final Font font;
    private final Date date;

    public TimerPanel() {
        format = new SimpleDateFormat("hh:mm:ss a");
        font = new Font("impact", Font.PLAIN, 30);
        date = new Date();

        date.setTime(System.currentTimeMillis());
        dateString = format.format(date);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setTime(System.currentTimeMillis());
                dateString = format.format(date);
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(font);
        FontMetrics fm = g.getFontMetrics(font);
        int width = fm.stringWidth(dateString);
        int height = fm.getAscent();
        int x = getWidth() / 2 - width / 2;
        int y = getHeight() / 2 + height / 2;

        g.drawString(dateString, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimerPanel timer = new TimerPanel();
                JOptionPane.showMessageDialog(
                        null, timer, "Digital Clock", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}
