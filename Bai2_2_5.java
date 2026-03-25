import javax.swing.JOptionPane;
public class Bai2_2_5 {
    public static void main(String[] args) {
        String strNum1,strNum2;
        String strNotification="";
        strNum1= JOptionPane.showInputDialog(null,"Please input the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        double num1= Double.parseDouble(strNum1);
        strNum2= JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double num2= Double.parseDouble(strNum2);
        strNotification+="num1+num2="+(num1+num2)+"\nnum1-num2="+(num1-num2)+"\nnum1*num2="+(num1*num2)+"\nnum1/num2= ";
        if(num2==0) strNotification+="null";
        else strNotification+= num1/num2;
        JOptionPane.showMessageDialog(null,strNotification,"Show results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
    
}
