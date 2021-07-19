//  程式ch5_1.java    動態記憶體
import java.util.*;

public class Main {

    public static void main(String [] args){
        ArrayList<String> p = new ArrayList<>();/*宣告p為字串陣列*/
        ArrayList<Integer> q = new ArrayList<>();/*宣告p為整數陣列*/
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("輸入您的姓名：");
        p.add(in.nextLine());	  /*設定p的資料*/
        System.out.printf("輸入您的年齡：");
        q.add(in.nextInt());	  /*設定q的資料*/
        in.nextLine(); //去除多餘的換行
        System.out.printf("Hello %s:\n",p.get(0));	  /*印出p所指的記憶體資料*/
        System.out.printf("十年後您將是%d歲",q.get(0)+10);/*指標q所指記憶體資料加10*/
    }
}