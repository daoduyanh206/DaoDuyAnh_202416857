import java.util.Scanner;
public class Bai6_6 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập kích thước :");
        int n= sc.nextInt(),m=sc.nextInt();
        int[][] a=new int[n][m];
        int[][] b=new int[n][m];
        System.out.println("Nhập ma trận A: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Nhập ma trận B: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][j]=sc.nextInt();
                a[i][j]+=b[i][j];
            }
        }
        System.out.println("Tổng 2 ma trận: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
