// CH2_4_2.java 陣列的應用：計算最高分數、最低分數與平均總成績
import java.util.Scanner;

public class Main {
    private static final int STU_NUM = 10;      // 學生人數10名

    static int findmax(int a[], int n){         // 比較最高分
        int max = 0;                             // 因成績介於0~100之間
        for (int i = 0; i < n; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    static int findmin(int a[], int n){         // 比較最低分
        int min = 100;                          // 因成績介於0~100之間
        for (int i = 0; i < n; i++)
            if (a[i] < min) min = a[i];
        return min;
    }

    static double findmean(int a[], int n){     // 計算平均分
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        return (double) sum / n;
    }

    public static void main(String [] args){
        int [] s = new int[STU_NUM];	       // 成績陣列s
        int highest, lowest;		      // 最高分、最低分與總分
        double avg;		                      // 平均成績
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        for(int i = 0; i < STU_NUM; i++){
            System.out.printf("輸入第%d位同學的成績:", i+1);
            s[i] = in.nextInt();	        // 讀取成績
        }
        highest = findmax(s, STU_NUM);       // 比較最高分
        lowest = findmin(s, STU_NUM);        // 比較最低分
        avg = findmean(s, STU_NUM);          // 計算平均分
        System.out.printf("最高分為%d分\n", highest);
        System.out.printf("最低分為%d分\n", lowest);
        System.out.printf("總平均為%.1f分\n", avg);
    }
}