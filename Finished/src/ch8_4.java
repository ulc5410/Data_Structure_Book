// 程式 ch8_4.java	  快速排序法
import java.util.*;

public class Main {
    static final int NUM = 8;
    static int pass = 1;

    public static void main(String [] args){
        int [] list = new int[]{9, 18, 6, 33, 27, 56, 13, 42};
        System.out.printf("\n     **********   快速排序法   **********\n");
        System.out.printf("\n初     值: ");
        display(list,NUM);
        quicksort(list,0,NUM-1);        //執行快速排序法
        System.out.printf("\n結     果: ");
        display(list,NUM);
    }

    static void quicksort(int a[],int left,int right) {
        int key, i, j, temp;
        if(left < right) {	    //當兩筆資料以上才要排序
            key = a[left];  	    //以第一筆為基準值
            i = left; 	        //左端位置
            j = right+1; 	        //右端位置
            while(i < j) {
                while(i<right && a[++i]<=key);  //由前向後找第一筆比基準值大的資料
                while(j>left && a[--j]>=key);   //由後向前找第一筆比基準值小的資料
                if(i < j) {	    //若與排序規則不符，將資料交換
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            temp=a[left];	    //將基準值之資料與目前位置j的資料交換
            a[left]=a[j];
            a[j]=temp;
            System.out.printf("\n第 %d 回合: ", pass++);    //列印排序中間過程
            display(a,NUM);
            //使用遞迴，對兩個子集合分別作排序
            quicksort(a, left, j-1);
            quicksort(a, j+1, right);
        }
    }

    static void display(int a[], int n) {
        for(int i = 0; i < n; i++)
            System.out.printf("%5d", a[i]);
        System.out.printf("\n");
    }
}