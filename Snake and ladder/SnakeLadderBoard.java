import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
class SnakeDialog extends Dialog implements ActionListener
{
    SnakeLadderBoard s;
    SnakeDialog(Frame parent,String title)
    {
        super(parent,title,false);
        s=(SnakeLadderBoard)parent;
        setLayout(new FlowLayout());
        setSize(380,100);
        add(new Label(s.msg));
        Button btn=new Button("Close");
        add(btn);
        btn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        dispose();
    }
}
public class SnakeLadderBoard extends Frame implements ActionListener
{
    ImageIcon b;
    Image board;
    Random rand=new Random();
    Scanner s=new Scanner(System.in);
    int number=1;
    int initial_number=0;
    int num=0;
    int xco=82;
    int yco=645;
    int number1=1;
    int initial_number1=0;
    int xco1=62;
    int yco1=645;
    int c=0;
    int userNumber=0;
    int computerNumber=0;
    Button myButton;
    String msg="";
    SnakeLadderBoard()
    {
        b=new ImageIcon("C:\\Users\\HP-PC\\Pictures\\Snake and ladder\\board.jpg");
        board=b.getImage();
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        myButton=new Button("Roll the dice");
        add(myButton);
        setLayout(new FlowLayout());
        myButton.addActionListener(this);
    }
    void update_position(int number,int xwidth,Graphics g)
    {
        if (number==3)
        {
            xco=55*+xwidth;
            yco=432;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==10)
        {
            xco=(55*8)+xwidth;
            yco=544;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==27)
        {
            xco=(55*7)+xwidth;
            yco=320;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==56)
        {
            xco=(55*3)+xwidth;
            yco=152;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==72)
        {
            xco=(55*9)+xwidth;
            yco=152;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==61)
        {
            xco=55+xwidth;
            yco=96;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==31)
        {
            num=number-1;
            xco=(55*3)+xwidth;
            yco=600;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==16)
        {
            xco=(55*7)+xwidth;
            yco=544;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==47)
        {
            xco=(55*4)+xwidth;
            yco=488;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==66)
        {
            xco=(55*8)+xwidth;
            yco=320;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==63)
        {
            xco=(55*9)+xwidth;
            yco=376;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number==97)
        {
            xco=(55*5)+xwidth;
            yco=208;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=1 && number<=10)
        {
            num=number-1;
            xco=(55*num)+xwidth;
            yco=600;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=11 && number<=20)
        {
            num=20-number;
            xco=(55*num)+xwidth;
            yco=544;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=21 && number<=30)
        {
            num=10-(30-number)-1;
            xco=(55*num)+xwidth;
            yco=488;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=31 && number<=40)
        {
            num=40-number;
            xco=(55*num)+xwidth;
            yco=432;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=41 && number<=50)
        {
            num=10-(50-number)-1;
            xco=(55*num)+xwidth;
            yco=376;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=51 && number<=60)
        {
            num=60-number;
            xco=(55*num)+xwidth;
            yco=320;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=61 && number<=70)
        {
            num=10-(70-number)-1;
            xco=(55*num)+xwidth;
            yco=264;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=71 && number<=80)
        {
            num=80-number;
            xco=(55*num)+xwidth;
            yco=208;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=81 && number<=90)
        {
            num=10-(90-number)-1;
            xco=(55*num)+xwidth;
            yco=152;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else
        {
            num=100-number;
            xco=(55*num)+xwidth;
            yco=96;
            g.fillArc(xco,yco,10,10,0,360);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if ((c%4)==1)
        {
            if (s.equals("Roll the dice"))
            {
                userNumber=rand.nextInt(6)+1;
                number1= userNumber;
            }
//            number1 = Integer.parseInt(myTextField.getText());
        }
        else
        {
            if (s.equals("Roll the dice"))
            {
                computerNumber=rand.nextInt(6)+1;
                number= computerNumber;
            }
//            number=Integer.parseInt(myTextField.getText());
        }
        c=c+1;
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawImage(board,6,68,this);
        Font myFont=new Font("Courier",Font.BOLD,15);
        g.setFont(myFont);
        if (c==0)
        {
            g.setColor(Color.YELLOW);
            g.fillArc(xco1,yco1,10,10,0,360);
            number1=initial_number1+number1;
            initial_number1=number1;
            g.setColor(Color.DARK_GRAY);
            update_position(number1,27,g);

            g.fillArc(xco,yco,10,10,0,360);
            number=initial_number+number;
            initial_number=number;
            g.setColor(Color.MAGENTA);
            update_position(number,40,g);
            c=c+1;
        }
        else if (c%4==0)
        {
            if (initial_number%2==1)
            {
                g.setColor(Color.YELLOW);
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillArc(xco,yco,10,10,0,360);
            number=initial_number+number;
            if (number>100)
            {
                number=initial_number;
            }
            else if (number==100)
            {
                msg="You lost the match";
                SnakeDialog snake=new SnakeDialog(this,"Winner message box");
                snake.setVisible(true);
                return;
            }
            else if (number==3)
            {
                number=39;
            }
            else if (number==10)
            {
                number=12;
            }
            else if (number==27)
            {
                number=53;
            }
            else if (number==56)
            {
                number=84;
            }
            else if (number==72)
            {
                number=90;
            }
            else if (number==61)
            {
                number=99;
            }
            else if (number==31)
            {
                number=4;
            }
            else if (number==16)
            {
                number=13;
            }
            else if (number==47)
            {
                number=25;
            }
            else if (number==66)
            {
                number=52;
            }
            else if (number==63)
            {
                number=50;
            }
            else if (number==97)
            {
                number=75;
            }
            initial_number=number;
            g.setColor(Color.MAGENTA);
            update_position(number,40,g);
            c=c+1;

            g.setColor(Color.DARK_GRAY);
            update_position(number1,27,g);

            g.setColor(Color.MAGENTA);
            g.drawString("Computer's magic number : "+computerNumber,350,52);
        }
        else
        {
            if (initial_number1%2==1)
            {
                g.setColor(Color.YELLOW);
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillArc(xco1,yco1,10,10,0,360);
            number1=initial_number1+number1;
            if (number1>100)
            {
                number1=initial_number1;
            }
            else if (number1==100)
            {
                msg="You won the match";
                SnakeDialog snake=new SnakeDialog(this,"Winner message box");
                snake.setVisible(true);
                return;
            }
            else if (number1==3)
            {
                number1=39;
            }
            else if (number1==10)
            {
                number1=12;
            }
            else if (number1==27)
            {
                number1=53;
            }
            else if (number1==56)
            {
                number1=84;
            }
            else if (number1==72)
            {
                number1=90;
            }
            else if (number1==61)
            {
                number1=99;
            }
            else if (number1==31)
            {
                number1=4;
            }
            else if (number1==16)
            {
                number1=13;
            }
            else if (number1==47)
            {
                number1=25;
            }
            else if (number1==66)
            {
                number1=52;
            }
            else if (number1==63)
            {
                number1=50;
            }
            else if (number1==97)
            {
                number1=75;
            }
            initial_number1=number1;
            g.setColor(Color.DARK_GRAY);
            update_position(number1,27,g);
            c=c+1;

            g.setColor(Color.MAGENTA);
            update_position(number,40,g);

            g.setColor(Color.DARK_GRAY);
            g.drawString("Your magic number : "+userNumber,350,52);
        }
    }
    public static void main(String[] args)
    {
        SnakeLadderBoard appwin = new SnakeLadderBoard();
        appwin.setSize(new Dimension(569,629));
        appwin.setTitle("Snake and ladder");
        appwin.setVisible(true);
    }
