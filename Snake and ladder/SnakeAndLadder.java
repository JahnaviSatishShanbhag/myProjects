import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class SnakeAndLadder extends Frame implements ActionListener{
    Scanner s=new Scanner(System.in);
    int number=1;
    int initial_number=0;
    int num=0;
    int xco=82;
    int yco=620;
    int number1=1;
    int initial_number1=0;
    int xco1=62;
    int yco1=620;
    int c=0;
    TextField myTextField;
    public SnakeAndLadder() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        myTextField=new TextField(10);
        setLayout(new FlowLayout());
        add(myTextField);
        myTextField.addActionListener(this);
    }
    void update_position(int number,int xwidth,Graphics g)
    {
        if (number>=1 && number<=10)
        {
            num=number-1;
            xco=(90*num)+xwidth;
            yco=620;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=11 && number<=20)
        {
            num=20-number;
            xco=(90*num)+xwidth;
            yco=560;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=21 && number<=30)
        {
            num=10-(30-number)-1;
            xco=(90*num)+xwidth;
            yco=500;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=31 && number<=40)
        {
            num=40-number;
            xco=(90*num)+xwidth;
            yco=440;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=41 && number<=50)
        {
            num=10-(50-number)-1;
            xco=(90*num)+xwidth;
            yco=380;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=51 && number<=60)
        {
            num=60-number;
            xco=(90*num)+82;
            yco=320;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=61 && number<=70)
        {
            num=10-(70-number)-1;
            xco=(90*num)+xwidth;
            yco=260;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=71 && number<=80)
        {
            num=80-number;
            xco=(90*num)+xwidth;
            yco=200;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=81 && number<=90)
        {
            num=10-(90-number)-1;
            xco=(90*num)+xwidth;
            yco=140;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else
        {
            num=100-number;
            xco=(90*num)+xwidth;
            yco=80;
            g.fillArc(xco,yco,10,10,0,360);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if ((c%4)==1)
        {
            number1 = Integer.parseInt(myTextField.getText());
        }
        else
        {
            number=Integer.parseInt(myTextField.getText());
        }
        c=c+1;
        repaint();
    }
    public void paint(Graphics g)
    {
        Font myFont=new Font("Courier",Font.BOLD,15);
        int i=1;
        g.setColor(Color.YELLOW);
        for (int x=50;x<=950;x++)
        {
            g.drawLine(x,50,x,650);
        }
        for (int y=50;y<=650;y++)
        {
            g.drawLine(50,y,950,y);
        }
        g.setColor(Color.BLUE);
        for (int x=50;x<1000;x+=90)
        {
            g.drawLine(x,50,x,650);
        }
        for (int y=50;y<700;y+=60)
        {
            g.drawLine(50,y,950,y);
        }

        g.setFont(myFont);
        g.setColor(Color.RED);
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,620);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,560);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,500);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,440);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,380);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,320);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,260);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,200);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,140);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,80);
            i++;
        }
        if (c==0)
        {
            g.setColor(Color.YELLOW);
            g.fillArc(xco1,yco1,10,10,0,360);
            number1=initial_number1+number1;
            initial_number1=number1;
            g.setColor(Color.DARK_GRAY);
            update_position(number1,62,g);

            g.fillArc(xco,yco,10,10,0,360);
            number=initial_number+number;
            initial_number=number;
            g.setColor(Color.MAGENTA);
            update_position(number,82,g);
            c=c+1;
        }
        else if (c%4==0)
        {
            g.setColor(Color.YELLOW);
            g.fillArc(xco,yco,10,10,0,360);
            number=initial_number+number;
            initial_number=number;
            g.setColor(Color.MAGENTA);
            update_position(number,82,g);
            c=c+1;
        }
        else
        {
            g.setColor(Color.YELLOW);
            g.fillArc(xco1,yco1,10,10,0,360);
            number1=initial_number1+number1;
            initial_number1=number1;
            g.setColor(Color.DARK_GRAY);
            update_position(number1,62,g);
            c=c+1;
        }
    }
    public static void main(String[] args)
    {
        SnakeAndLadder appwin = new SnakeAndLadder();
        appwin.setSize(new Dimension(1000,700));
        appwin.setTitle("Snake and ladder demo");
        appwin.setVisible(true);
    }
}


