import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Random;
public class SnakeAndLadder extends Frame implements ActionListener{
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
    public SnakeAndLadder() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
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
        if (number>=1 && number<=10)
        {
            num=number-1;
            xco=(90*num)+xwidth;
            yco=645;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=11 && number<=20)
        {
            num=20-number;
            xco=(90*num)+xwidth;
            yco=585;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=21 && number<=30)
        {
            num=10-(30-number)-1;
            xco=(90*num)+xwidth;
            yco=525;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=31 && number<=40)
        {
            num=40-number;
            xco=(90*num)+xwidth;
            yco=465;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=41 && number<=50)
        {
            num=10-(50-number)-1;
            xco=(90*num)+xwidth;
            yco=405;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=51 && number<=60)
        {
            num=60-number;
            xco=(90*num)+82;
            yco=345;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=61 && number<=70)
        {
            num=10-(70-number)-1;
            xco=(90*num)+xwidth;
            yco=285;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=71 && number<=80)
        {
            num=80-number;
            xco=(90*num)+xwidth;
            yco=225;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else if (number>=81 && number<=90)
        {
            num=10-(90-number)-1;
            xco=(90*num)+xwidth;
            yco=165;
            g.fillArc(xco,yco,10,10,0,360);
        }
        else
        {
            num=100-number;
            xco=(90*num)+xwidth;
            yco=105;
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
        }
        else
        {
            if (s.equals("Roll the dice"))
            {
                computerNumber=rand.nextInt(6)+1;
                number= computerNumber;
            }
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
            g.drawLine(x,75,x,675);
        }
        for (int y=75;y<=675;y++)
        {
            g.drawLine(50,y,950,y);
        }
        g.setColor(Color.BLUE);
        for (int x=50;x<1000;x+=90)
        {
            g.drawLine(x,75,x,675);
        }
        for (int y=75;y<725;y+=60)
        {
            g.drawLine(50,y,950,y);
        }

        g.setFont(myFont);
        g.setColor(Color.RED);
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,645);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,585);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,525);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,465);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,405);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,345);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,285);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,225);
            i++;
        }
        for (int x=95;x<950;x+=90)
        {
            g.drawString(String.valueOf(i),x,165);
            i++;
        }
        for (int x=905;x>50;x-=90)
        {
            g.drawString(String.valueOf(i),x,105);
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

            g.setColor(Color.DARK_GRAY);
            update_position(number1,62,g);

            g.setColor(Color.MAGENTA);
            g.drawString("",580,85);
            g.drawString("Computer's magic number : "+computerNumber,580,62);
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

            g.setColor(Color.MAGENTA);
            update_position(number,82,g);

            g.setColor(Color.DARK_GRAY);
            g.drawString("",580,85);
            g.drawString("Your magic number : "+userNumber,580,62);
        }
    }
    public static void main(String[] args)
    {
        SnakeAndLadder appwin = new SnakeAndLadder();
        appwin.setSize(new Dimension(1000,725));
        appwin.setTitle("Snake and ladder demo");
        appwin.setVisible(true);
    }
}

