import java.util.Scanner;
public class Bai6_4{
    public static int parseMonth(String input) {
        input = input.toLowerCase().trim(); 

        if (input.equals("1") || input.equals("january") || input.equals("jan.") || input.equals("jan")) return 1;
        if (input.equals("2") || input.equals("february") || input.equals("feb.") || input.equals("feb")) return 2;
        if (input.equals("3") || input.equals("march") || input.equals("mar.") || input.equals("mar")) return 3;
        if (input.equals("4") || input.equals("april") || input.equals("apr.") || input.equals("apr")) return 4;
        if (input.equals("5") || input.equals("may") || input.equals("may.") || input.equals("may")) return 5;
        if (input.equals("6") || input.equals("june") || input.equals("jun.") || input.equals("jun")) return 6;
        if (input.equals("7") || input.equals("july") || input.equals("jul.") || input.equals("jul")) return 7;
        if (input.equals("8") || input.equals("august") || input.equals("aug.") || input.equals("aug")) return 8;
        if (input.equals("9") || input.equals("september") || input.equals("sept.") || input.equals("sep")) return 9;
        if (input.equals("10") || input.equals("october") || input.equals("oct.") || input.equals("oct")) return 10;
        if (input.equals("11") || input.equals("november") || input.equals("nov.") || input.equals("nov")) return 11;
        if (input.equals("12") || input.equals("december") || input.equals("dec.") || input.equals("dec")) return 12;

        return -1; 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = -1;
        String month="";
        while (true) {
            System.out.print("Nhập năm: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 1000 && year <= 9999) { 
                    sc.nextLine();
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Năm không hợp lệ! Vui lòng nhập lại: ");
        }
        while (true) {
            System.out.print("Nhập tháng: ");
                month=sc.nextLine();
                int m=parseMonth(month);
                if(m==-1){
                    System.out.println("Tháng không hợp lệ! Vui lòng nhập lại: ");
                    continue;
                }
                switch(m){
                    case 1: case 3:case 5:case 7:case 8:case 10:case 12:
                        System.out.printf("Tháng %d có 31 ngày\n",m);
                        break;
                    case 2:
                        if(year%400==0||(year%4==0&&year%100!=0)) System.out.println("Tháng 2 có 29 ngày\n");
                        else System.out.println("Tháng 2 có 28 ngày\n");
                        break;
                    case 4:case 6:case 9:case 11:
                        System.out.printf("Tháng %d có 30 ngày\n",m);
                        break;
                    default:
                        System.out.println("Tháng không hợp lệ! Vui lòng nhập lại: ");
                }
                break;
        }
    }
}
