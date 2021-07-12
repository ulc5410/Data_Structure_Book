// CH2_5.java 二維陣列的應用：計算三位同學期中考5科的總平均
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        int [][] s = new int [3][6];		 // 成績陣列s
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        for(int i = 0; i < 3; i++){
            System.out.printf("第%d位同學\n",i+1);
            s[i][5] = 0;	    	          // 總分初始值
            for(int j = 0; j < 5; j++){
                System.out.printf("\t第%d科成績:",j+1);
                s[i][j] = in.nextInt();              // 讀取成績
                s[i][5] += s[i][j];     		      // 計算總分
            }
        }

        for(int i = 0; i < 3; i++)                          // 印出總分
            System.out.printf("第%d位同學總分為%d\n", i+1, s[i][5]);
    }
}