// 程式ch2_6.java  結構的應用
import java.util.Scanner;

class employee{
    String id;   //員工編號
    String name;  //姓名
    int sale;  //銷售金額
}

public class Main {
    public static void main(String [] args){
        employee e = new employee();	     //宣告銷售員資料變數
        int salary;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        //輸入銷售員資料並計算薪水
        System.out.printf("銷售員編號：");
        e.id = in.nextLine();
        System.out.printf("姓名：");
        e.name = in.nextLine();
        System.out.printf("銷售金額：");
        e.sale = in.nextInt();
        salary = (int)(20000 + e.sale * 0.1);

        //輸出銷售員資料
        System.out.printf("\n薪資：%d",salary);
    }
}