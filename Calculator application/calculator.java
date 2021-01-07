import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class CalculatorDemoJava extends Frame implements ActionListener{
    TextField content;
    Button ac,del,per,div,seven,eight,nine,mul,four,five,six,sub,one,two,three,add,zero,dot,equal;
    String setContent="";
    int endIndex=0;
    double result=0;
//    String[] setContentArray=new String[25];
    int i=0;
//    String setContentCopy="";
    CalculatorDemoJava() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        content=new TextField(80);
        setLayout(new GridLayout(5, 4));
        setFont(new Font("Arial", Font.BOLD, 14));
//        content=new TextField(80);
        ac=new Button("AC");
        del=new Button("DEL");
        per=new Button("%");
        div=new Button("/");
        seven=new Button("7");
        eight=new Button("8");
        nine=new Button("9");
        mul=new Button("x");
        four=new Button("4");
        five=new Button("5");
        six=new Button("6");
        sub=new Button("-");
        one=new Button("1");
        two=new Button("2");
        three=new Button("3");
        add=new Button("+");
        zero=new Button("0");
        dot=new Button(".");
        equal=new Button("=");
        add(content);
        add(ac);
        add(del);
        add(per);
        add(div);
        add(seven);
        add(eight);
        add(nine);
        add(mul);
        add(four);
        add(five);
        add(six);
        add(sub);
        add(one);
        add(two);
        add(three);
        add(add);
        add(zero);
        add(dot);
        add(equal);
        content.addActionListener(this);
        ac.addActionListener(this);
        del.addActionListener(this);
        per.addActionListener(this);
        div.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        mul.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        sub.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        add.addActionListener(this);
        zero.addActionListener(this);
        dot.addActionListener(this);
        equal.addActionListener(this);
    }
    int F(char symbol)
    {
        int number;
        switch(symbol)
        {
            case '+':
            case '-':number=2;
                break;
            case 'x':
            case '/':number=4;
                break;
            case '^':
            case '$':number=5;
                break;
            case '(':number=0;
                break;
            case '#':number=-1;
                break;
            default:number=8;
                break;
        }
        return number;
    }
    int G(char symbol)
    {
        int number;
        switch(symbol)
        {
            case '+':
            case '-':number=1;
                break;
            case 'x':
            case '/':number=3;
                break;
            case '^':
            case '$':number=6;
                break;
            case '(':number=9;
                break;
            case ')':number=0;
                break;
            default:number=7;
                break;
        }
        return number;
    }
    void infix_postfix(char[] infix,char[] postfix)
    {
        int top,i,j;
        char[] s=new char[30];
        char symbol;
        top=-1;
        s[++top]='#';
        j=0;
        for (i=0;i<infix.length;i++)
        {
            symbol=infix[i];
            while (F(s[top])>G(symbol))
            {
                postfix[j]=s[top--];
                j++;
            }
            if (F(s[top])!=G(symbol))
            {
                s[++top]=symbol;
            }
            else top--;
        }
        while (s[top]!='#')
        {
            postfix[j++]=s[top--];
        }
    }
    double compute(char symbol,double op1,double op2)
    {
        switch (symbol)
        {
            case '+':result=op1+op2;
                break;
            case '-':result=op1-op2;
                break;
            case 'x':result=op1*op2;
                break;
            case '/':result=op1/op2;
                break;
            case '$':
            case '^':result=Math.pow(op1,op2);
                break;
        }
        return result;
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") ||
                s.equals("8") || s.equals("9") || s.equals("."))
        {
            setContent += s;
//            setContentCopy+=s;
            endIndex=setContent.length()-1;
            content.setText(setContent);
        }
        else if (s.equals("DEL"))
        {
            setContent=setContent.substring(0,endIndex);
            content.setText(setContent);
            endIndex=endIndex-1;
        }
        else if (s.equals("AC"))
        {
            setContent="";
            content.setText(setContent);
        }
        else if (s.equals("+") || s.equals("-") || s.equals("x") || s.equals("/") || s.equals("%"))
        {
//            setContentArray[i]=setContentCopy;
//
//            System.out.printf("setContentArray[%d]=%s\n",i,setContentArray[i]);
//            i=i+1;
//            setContentArray[i]=s;
            setContent+=s;
//            System.out.printf("setContentArray[%d]=%s\n",i,setContentArray[i]);
//            i=i+1;
//            setContentCopy="";
            content.setText(setContent);
        }
        else if (s.equals("="))
        {
            char[] infix=new char[30];
            char[] postfix =new char[30];
            StringBuilder postString= new StringBuilder();
            for (i=0;i<setContent.length();i++)
            {
                infix[i]=setContent.charAt(i);
            }
            infix_postfix(infix,postfix);
            for (char c : postfix) {
                if (Character.isDigit(c) || c=='+' || c=='-' || c=='x' || c=='/')
                {
                    postString.append(c);
                }
            }
            double[] stack=new double[20];
            double res;
            double op1=0;
            double op2=0;
            int top=-1;
            char symbol;
            for (i=0;i<postString.length();i++)
            {
                symbol=postString.charAt(i);
                if (Character.isDigit(symbol))
                {
                    StringBuilder sym=new StringBuilder();
                    sym.append(symbol);
                    stack[++top]=Integer.parseInt(sym.toString());
                }
                else
                {
                    op2=stack[top--];
                    op1=stack[top--];
                    res=compute(symbol,op1,op2);
                    stack[++top]=res;
                }
            }
            res=stack[top];
            setContent=String.valueOf(res);
            content.setText(setContent);
        }
    }
    public static void main(String[] args)
    {
        CalculatorDemoJava cd=new CalculatorDemoJava();
        cd.setSize(new Dimension(300,300));
        cd.setTitle("Calculator Demo");
        cd.setVisible(true);
    }
}
