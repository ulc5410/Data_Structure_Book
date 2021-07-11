// CH2_3.c 陣列的應用：計算期中考加權值後的總平均
import java.util.Scanner;

public class Main {
    private static final int NUM = 5; // 假設共5科成績

    public static void main(String [] args){
        int w[] = {6,5,5,3,3}, weight = 0;      // 加權值陣列與總加權值
        int [] s = new int [NUM];		            // 成績陣列
        int sum;		                      // sum:總分
        double avg;		                      // avg:平均成績
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        sum = 0;	    	                      // 總分初始值
        for(int i = 0; i < 5; i++){
            System.out.printf("輸入第%d科成績:", i+1);
            s[i] = in.nextInt();            // 讀取成績
            sum += s[i] * w[i];	  		          // 計算加權值後總分
            weight += w[i];                      // 計算總加權值
        }
        avg = (double)sum/weight;	          //計算加權值後的平均值
        System.out.printf("總平均為%.1f分\n", avg);	  //印出平均
    }
}
