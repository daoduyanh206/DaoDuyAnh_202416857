import java.util.Arrays;
import java.util.Scanner;

public class Bai6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử: ");
        int n= sc.nextInt();
        int[] a = new int[n];
        int sum=0;
        System.out.println("Nhập các phần tử: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        double tb= (double)sum/n;
        System.out.println("Tổng các phần tử: "+sum);
        System.out.println("Trung bình các phần tử: "+tb);
        Arrays.sort(a);
        System.out.println("Mảng đã sắp xếp :");
        System.out.println(Arrays.toString(a));
    }
}
