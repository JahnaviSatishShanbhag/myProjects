import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CalculatorDemoJava extends Frame implements ActionListener{
    TextField content;
    Panel panel;
    String setContent="";
    int endIndex=0;
    double result=0;
    int i=0;
     String[] btnString = {"AC","DEL","M+","M-",
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "x",
        "0", ".", "=", "/"};
    Button[] btn = new Button[20];
    CalculatorDemoJava() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        Font f = new Font("Cambria", Font.BOLD, 18);
        content = new TextField(10);
        content.setFont(f);
        panel = new Panel();
        add(content, "North");
        add(panel, "Center");
        panel.setLayout(new GridLayout(5,4));
        for(int i=0; i < 20; i++) {
            btn[i] = new Button(btnString[i]);
            btn[i].setFont(f);
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
    }
    int F(String symbol)
    {
        int number;
        switch(symbol)
        {
            case "+":
            case "-":number=2;
                break;
            case "x":
            case "/":number=4;
                break;
            case "^":
            case "$":number=5;
                break;
            case "(":number=0;
                break;
            case "#":number=-1;
                break;
            default:number=8;
                break;
        }
        return number;
    }
    int G(String symbol)
    {
        int number;
        switch(symbol)
        {
            case "+":
            case "-":number=1;
                break;
            case "x":
            case "/":number=3;
                break;
            case "^":
            case "$":number=6;
                break;
            case "(":number=9;
                break;
            case ")":number=0;
                break;
            default:number=7;
                break;
        }
        return number;
    }
    void infix_postfix(String[] infix,String[] postfix)
    {
        int top,i,j;
        String[] s=new String[30];
        String symbol;
        top=-1;
        s[++top]="#";
        j=0;
        for (i=0;i<infix.length;i++)
        {
            symbol=infix[i];
            if (symbol==null)
            {
                break;
            }
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
        while (!s[top].equals("#"))
        {
            postfix[j++]=s[top--];
        }
    }
    double compute(String symbol,double op1,double op2)
    {
        switch (symbol)
        {
            case "+":result=op1+op2;
                break;
            case "-":result=op1-op2;
                break;
            case "x":result=op1*op2;
                break;
            case "/":result=op1/op2;
                break;
            case "$":
            case "^":result=Math.pow(op1,op2);
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
        else if (s.equals("+") || s.equals("-") || s.equals("x") || s.equals("/"))
        {
            setContent+=s;
            content.setText(setContent);
        }
        else if (s.equals("="))
        {
            String[] infix=new String[30];
            String[] postfix =new String[30];
            StringBuilder postString= new StringBuilder();
            String regex = "[0-9]+\\.[0-9]+|[0-9]+|\\+|-|x|\\/";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(setContent);
            String regex1 = "[0-9]+\\.[0-9]+|[0-9]+";
            Pattern pattern1 = Pattern.compile(regex1);
            int i=0;
            while (matcher.find()) {
                infix[i]=matcher.group();
                i++;
            }
            infix_postfix(infix,postfix);
            double[] stack=new double[20];
            double res;
            double op1=0;
            double op2=0;
            int top=-1;
            String symbol;
            for (String c:postfix)
            {
                symbol=c;
                if (c==null)
                {
                    break;
                }
                else
                {
                    Matcher matcher1=pattern1.matcher(c);
                    if (matcher1.find())
                    {
                        stack[++top]=Double.parseDouble(c);
                    }
                    else
                    {
                        op2=stack[top--];
                        op1=stack[top--];
                        res=compute(symbol,op1,op2);
                        stack[++top]=res;
                    }
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
        cd.setSize(new Dimension(250,300));
        cd.setTitle("Calculator Demo");
        cd.setVisible(true);
    }
}
