// 程式 ch8_2.java	  插入排序法
import java.util.*;

public class Main {
    static final int NUM = 8;

    public static void main(String [] args){
        int [] list = new int[]{9, 18, 6, 33, 27, 56, 13, 42};
        System.out.printf("\n     **********   插入排序法   **********\n");
        System.out.printf("\n初     值: ");
        display(list,NUM);
        insertionsort(list, NUM);          // 執行選擇排序法
        System.out.printf("\n結     果: ");
        display(list,NUM);
    }

    static void insertionsort(int a[], int n)
    {
        int i, j, key;
        for(i = 1; i <= n-1; i++){               //將a[1]~a[n-1]插入至已排序資料中
            key = a[i];                       //從未排序資料中取出第一筆設為key
            for(j = i-1; j>=0 && a[j] > key; j--)   //和已排序的資料由後往前逐一比較
                a[j+1] = a[j];                 //若已排序之資料較大，則此資料向後移
            a[j+1] = key;                     //停止比較後，插入資料key
            System.out.printf("\n第 %d 回合: ", i);    //列印排序中間過程
            display(a,NUM);
        }
    }

    static void display(int a[], int n) {
        for(int i = 0; i < n; i++)
            System.out.printf("%5d", a[i]);
        System.out.printf("\n");
    }
}