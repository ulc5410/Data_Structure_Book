// CH2_2.c 陣列的應用：計算期中考的總平均
import java.util.Scanner;

public class Main {
    private static final int NUM = 5; // 假設共5科成績

    public static void main(String [] args){
        int [] s = new int [NUM];		                      // 成績陣列s
        int i, sum;		                      // sum:總分
        double avg;		                      // avg:平均成績
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        sum=0;	    	                      // 總分初始值
        for(i=0; i<NUM; i++){
            System.out.printf("輸入第%d科成績:%n", i+1);
            s[i] = in.nextInt();            // 讀取成績
            sum+=s[i];	     		          // 計算總分
        }
        avg=(double)sum/NUM;	              //計算平均
        System.out.printf("總平均為%.1f分%n", avg);	  //印出平均
    }
}
