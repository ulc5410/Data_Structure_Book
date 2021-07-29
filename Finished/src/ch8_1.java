// 程式 ch8_2.java	  插入排序法
import java.util.*;

public class Main {
    static final int NUM = 8;

    public static void main(String [] args){
        int [] list = new int[]{9, 18, 6, 33, 27, 56, 13, 42};
        System.out.printf("\n     **********   選擇排序法   **********\n");
        System.out.printf("\n初     值: ");
        display(list,NUM);
        selectionsort(list, NUM);          // 執行選擇排序法
        System.out.printf("\n結     果: ");
        display(list,NUM);
    }

    static void selectionsort(int a[], int n) {
        int min, temp;		//最小值的索引設為min
        for(int i = 0; i < n-1; i++){        //重覆執行 n-1 次
            min = i;					//假設最小值為未排序中的第一筆
            for(int j = i+1; j < n; j++)      //與其他資料作比較
                if(a[j] < a[min]) 	    //找出最小值在陣列中的索引
                    min = j;
            if(min != i){			//若最小值不是未排序中的第一筆
                temp = a[i];           //則將最小值與未排序中的第一筆做交換
                a[i] = a[min];
                a[min] = temp;
            }
            System.out.printf("\n第 %d 回合: ", i+1);  //列印排序中間過程
            display(a,NUM);
        }
    }

    static void display(int a[], int n) {
        for(int i = 0; i < n; i++)
            System.out.printf("%5d", a[i]);
        System.out.printf("\n");
    }
}