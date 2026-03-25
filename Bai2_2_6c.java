import javax.swing.JOptionPane;
public class Bai2_2_6c {
    public static void solveLinear(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm", "Kết quả", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null,"Phương trình có nghiệm x="+x,"Kết quả",JOptionPane.INFORMATION_MESSAGE);
        }       
    }
    public static void main(String[] args) {
        String s="",sa,sb,sc;
        sa=JOptionPane.showInputDialog(null,"Nhập a","Giải phương trình bậc 2",JOptionPane.INFORMATION_MESSAGE);
        sb=JOptionPane.showInputDialog(null,"Nhập b","Giải phương trình bậc 2",JOptionPane.INFORMATION_MESSAGE);
        sc=JOptionPane.showInputDialog(null,"Nhập c","Giải phương trình bậc 2",JOptionPane.INFORMATION_MESSAGE);

        double a=Double.parseDouble(sa),
                b=Double.parseDouble(sb),
                c=Double.parseDouble(sc);
        if(a==0) solveLinear(b, c);
        else{
            double delta=b*b-4*a*c;
            if(delta==0){
                JOptionPane.showMessageDialog(null,"Phương trình có nghiệm x1=x2="+-b/(2*a),"Kết quả",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(delta<0){
                JOptionPane.showMessageDialog(null,"Phương trình vô nghiệm","Kết quả",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                s+="x1="+(-b+Math.sqrt(delta))/(2*a)+"\nx2="+(-b-Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null,"Phương trình có nghiệm:\n"+s,"Kết quả",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
