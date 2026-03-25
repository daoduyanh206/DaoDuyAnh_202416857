import javax.swing.JOptionPane;
public class Bai2_2_6a {
    public static void main(String[] args){
        String s="",sa,sb;
        sa=JOptionPane.showInputDialog(null,"Nhập a: ","Giải phương trình ax+b=0",JOptionPane.INFORMATION_MESSAGE);
        sb=JOptionPane.showInputDialog(null,"Nhập b: ","Giải phương trình ax+b=0",JOptionPane.INFORMATION_MESSAGE);
        double a= Double.parseDouble(sa);
        double b= Double.parseDouble(sb);
        if(a==0){
            if(b==0) JOptionPane.showMessageDialog(null, "Vô số nghiệm","Kết quả",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Vô nghiệm","Kết quả",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            s+=-b/a;
            JOptionPane.showMessageDialog(null, "Phương trình có nghiệm x="+s,"Kết quả",JOptionPane.INFORMATION_MESSAGE);
        }
    }


}

