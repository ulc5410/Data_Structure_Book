// 程式ch2_7.java  結構陣列
import java.util.Scanner;

class employee{
    String id;   //員工編號
    String name;  //姓名
    int sale;  //銷售金額
    int salary; //薪資
}

public class Main {

    private static final int N = 3; // 假設共5科成績

    public static void main(String [] args){
        employee [] e = new employee[3];	     //宣告銷售員資料變數
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        for(int i = 0; i < N; i++){
            e[i] = new employee();
            //輸入銷售員資料並計算薪水
            System.out.printf("銷售員編號：");
            e[i].id = in.nextLine();
            System.out.printf("姓名：");
            e[i].name = in.nextLine();
            System.out.printf("銷售金額：");
            e[i].sale = in.nextInt();
            in.nextLine(); //去除多餘的換行
            e[i].salary = (int)(20000 + e[i].sale * 0.1);
        }


        //輸出銷售員資料
        System.out.printf("\n");
        for(int i = 0; i < N; i++){
            System.out.printf("%s %s薪資：%d \n", e[i].id, e[i].name, e[i].salary);
        }
    }
}