// 程式 ch8_3_2.java	  改良式氣泡排序法
import java.util.*;

public class Main {
    static final int NUM = 8;

    public static void main(String [] args){
        int [] list = new int[]{9, 18, 6, 33, 27, 56, 13, 42};
        System.out.printf("\n     **********   改良式氣泡排序法   **********\n");
        System.out.printf("\n初     值: ");
        display(list,NUM);
        bubblesort(list, NUM);          // 執行氣泡排序法
        System.out.printf("\n結     果: ");
        display(list,NUM);
    }

    static void bubblesort(int a[], int n) {
        int i, j, temp, flag = 1;       //flag儲存資料交換的紀錄
        for(i = n-1; i>=1 && flag==1; i--){
            flag = 0;                    //重設 flag
            for(j = 0; j < i; j++)        //每回合未排序資料a[0]~a[i]
                if(a[j] > a[j+1]){        //由前向後比較相鄰資料
                    temp = a[j+1];         //若順序不符則交換相鄰資料
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = 1;              //資料交換過，則必須執行下一回合
                }
            System.out.printf("\n第 %d 回合: ", n-i);    //列印排序中間過程
            display(a,NUM);
        }
    }

    static void display(int a[], int n) {
        for(int i = 0; i < n; i++)
            System.out.printf("%5d", a[i]);
        System.out.printf("\n");
    }
}