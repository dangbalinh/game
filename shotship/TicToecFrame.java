import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
public class TicToecFrame extends JFrame implements ActionListener
{
    int stt = 0;
    TicToecPanel mainPanel;
    JButton button[] = new JButton[9];
    JButton continuePlaying,stop,reset;
    TicToecFrame()
    {
       
        mainPanel = new TicToecPanel();
        for(int i = 0; i < 9; i++)
        {
            button[i] = new JButton();
            button[i].setBounds((i % 3) * 300, (i/3) * 300, 300, 300);
            button[i].setBackground(Color.black);
            button[i].setFont(new Font("Fira Code",Font.BOLD,120));
            this.add(button[i]);
            button[i].addActionListener(this);
        }
        continuePlaying = new JButton();
        stop = new JButton();
        reset = new JButton();
        continuePlaying.setBounds(0, 900, 300, 100);
        stop.setBounds(300, 900, 300, 100);
        reset.setBounds(600, 900, 300, 100);
        continuePlaying.setFont(new Font("Fira Code",Font.ITALIC,29));
        continuePlaying.setBackground(Color.red);
        stop.setFont(new Font("Fira Code",Font.ITALIC,29));
        stop.setBackground(Color.yellow);
        reset.setFont(new Font("Fira Code",Font.ITALIC,29));
        reset.setBackground(Color.gray);
        continuePlaying.setText("continuePlay");
        stop.setText("stop");
        reset.setText("reset");
        continuePlaying.addActionListener(this);
        stop.addActionListener(this);
        reset.addActionListener(this);
        this.add(continuePlaying);
        this.add(stop);
        this.add(reset);
        this.add(mainPanel);
        this.setTitle("Caro 9o");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource() == button[i])
            {
                if(button[i].getText() == "")
                {
                    if(stt % 2 == 0)
                    {
                        button[i].setForeground(Color.red);
                        button[i].setText("X");
                        stt++;
                        System.out.print(stt);
                        CheckWin();
                    }
                    else
                    {
                        button[i].setForeground(Color.red);
                        button[i].setText("O");
                        stt++;
                        System.out.print(stt);
                        CheckWin();
                    }
                }
            }
        }
        if(e.getSource() == stop)
        {
            for(int i = 0; i < 9; i++)
                button[i].setEnabled(false);
        }
        if(e.getSource() == reset)
        {
            for(int i = 0; i < 9; i++)
            {
                button[i].setEnabled(true);
                button[i].setBackground(Color.black);
                button[i].setText("");
                continuePlaying.setEnabled(true);
                stop.setEnabled(true);
            }
        }
        if(e.getSource() == continuePlaying)
        {
            for(int i = 0; i < 9; i++)
                button[i].setEnabled(true);
        }
    }
    public void CheckWin()
    {
        if(button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "X")
            XWin(0, 1, 2);
        if(button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "X")
            XWin(3,4,5);
        if(button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "X")
            XWin(6,7,8);
        if(button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "X")
            XWin(0,3,6);
        if(button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "X")
            XWin(1,4,7);
        if(button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X")
            XWin(2,5,8);
        if(button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "X")
            XWin(0,4,8);
        if(button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "X")
            XWin(2,4,6);
        if(button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "O")
            OWin(0, 1, 2);
        if(button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "O")
            OWin(3,4,5);
        if(button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "O")
            OWin(6,7,8);
        if(button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "O")
            OWin(0,3,6);
        if(button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "O")
            OWin(1,4,7);
        if(button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O")
            OWin(2,5,8);
        if(button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "O")
            OWin(0,4,8);
        if(button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "O")
            OWin(2,4,6);
    }
    public void XWin(int a, int b, int c)
    {
        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);
        for(int i = 0; i < 9; i++)
            button[i].setEnabled(false);
        continuePlaying.setEnabled(false);
        stop.setEnabled(false);

        System.out.println("X win");
    }
    public void OWin(int a, int b, int c)
    {
        button[a].setBackground(Color.blue);
        button[b].setBackground(Color.blue);
        button[c].setBackground(Color.blue);
        for(int i = 0; i < 9; i++)
            button[i].setEnabled(false);
        continuePlaying.setEnabled(false);
        stop.setEnabled(false);
        System.out.println("0 win");
    }
    
}
