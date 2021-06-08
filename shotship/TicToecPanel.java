import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
public class TicToecPanel extends JPanel
{
    TicToecPanel()
    {
        this.setPreferredSize(new Dimension(900,1000));
        this.setBackground(Color.gray);
        this.setFocusable(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.setColor(Color.black);
        g2D.setStroke(new BasicStroke(2));
        for(int i = 1; i <= 2; i++)
        {
            g2D.drawLine(300 * i, 0, 300 * i, 900);
            g2D.drawLine(0, 300 * i, 900, 300 * i);
        }
    }
}
