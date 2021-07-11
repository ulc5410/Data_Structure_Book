// CH2_4_1.java 陣列的應用：計算最高分數、最低分數與平均總成績
import java.util.Scanner;

public class Main {
    private static final int STU_NUM = 10;      // 學生人數10名

    public static void main(String [] args){
        int [] s = new int[STU_NUM];	       // 成績陣列s
        int highest, lowest, sum;		      // 最高分、最低分與總分
        double avg;		                      // 平均成績
        highest = 0;                             // 因成績介於0~100之間
        lowest = 100;
        sum = 0;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        for(int i = 0; i < STU_NUM; i++){
            System.out.printf("輸入第%d位同學的成績:", i+1);
            s[i] = in.nextInt();            // 讀取成績

            if(s[i] > highest)                   // 比較最高分
                highest = s[i];
            else if(s[i] < lowest)              // 比較最低分
                lowest = s[i];
            sum += s[i];                          // 計算總分
        }
        avg = (double)sum/STU_NUM;            // 計算平均分
        System.out.printf("最高分為%d分\n", highest);
        System.out.printf("最低分為%d分\n", lowest);
        System.out.printf("總平均為%.1f分\n", avg);
    }
}
