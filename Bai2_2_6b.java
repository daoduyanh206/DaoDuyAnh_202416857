import javax.swing.JOptionPane;
public class Bai2_2_6b {
    public static void main(String[] args) {
        String s="",sa11,sa12,sa21,sa22,sb1,sb2;
        sa11=JOptionPane.showInputDialog(null,"Nhập a11","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);
        sa12=JOptionPane.showInputDialog(null,"Nhập a12","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);
        sa21=JOptionPane.showInputDialog(null,"Nhập a21","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);
        sa22=JOptionPane.showInputDialog(null,"Nhập a22","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);
        sb1=JOptionPane.showInputDialog(null,"Nhập b1","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);
        sb2=JOptionPane.showInputDialog(null,"Nhập b2","Giải hệ phương trình",JOptionPane.INFORMATION_MESSAGE);

        double a11=Double.parseDouble(sa11),
                a12=Double.parseDouble(sa12),
                a21=Double.parseDouble(sa21),
                a22=Double.parseDouble(sa22),
                b1=Double.parseDouble(sb1),
                b2=Double.parseDouble(sb2);
        double D=a11*a22-a21*a12,
                D1=b1*a22-b2*a12,
                D2=a11*b2-a21*b1;
        if(D==0){
            if(D1==0&&D2==0) JOptionPane.showMessageDialog(null, "Hệ vô số nghiệm","Kết quả",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Hệ vô nghiệm","Kết quả",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            s+="x1="+ (D1/D) +"\nx2="+(D2/D);
            JOptionPane.showMessageDialog(null, "Hệ có nghiệm:\n"+s,"Kết quả",JOptionPane.INFORMATION_MESSAGE);

        }

    }
}
