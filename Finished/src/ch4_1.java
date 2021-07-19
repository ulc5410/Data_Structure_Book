//  程式ch4_1.java  陣列環狀佇列
import java.util.Scanner;

public class Main {
    private static final int N = 100;	//假設環狀佇列之大小為100
    static int [] queue = new int[N];
    static int front = N-1, rear = N-1;	//front與rear初值皆為N-1

    /*加入資料於環狀佇列內*/
    static void add(int d)
    {
        if(front==(rear+1)%N){	//檢查是否只剩一個空間
            System.out.printf("環狀佇列滿了\n");	//若是則不允許加入資料
            System.exit(1);	//加入失敗，結束程式之執行
        }
        rear=(rear+1)%N;	//rear改為下個空間之索引值
        queue[rear]=d;	//將資料d加入目前rear位置內
    }

    /*傳回並刪除環狀佇列的前端元素*/
    static int delete()
    {
        if(front==rear){	//檢查環狀佇列是否空了
            System.out.printf("環狀佇列已空\n");	//若是空了則無法刪除
            System.exit(1);	//刪除失敗，結束程式之執行
        }
        front=(front+1)%N;	//front改為下個空間之索引值
        return(queue[front]);	//傳回目前front位置之資料
    }

    public static void main(String [] args){
        int d;
        boolean loop = true;	/*loop為迴圈控制變數*/
        String input;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("***陣列環狀佇列***\n");
        System.out.printf("可執行下列指令:add, delete, +, -, exit\n\n");
        do {
            System.out.printf("==>");
            input = in.nextLine();
            if(input.equals("add")){
                System.out.printf("輸入數值：");
                d = in.nextInt();
                in.nextLine(); //去除多餘的換行
                add(d);
            }
            else if(input.equals("delete"))
                System.out.printf("%d\n", delete());
            else if(input.equals("+"))
                add(delete()+delete());
            else if(input.equals("-"))
                add(delete()-delete());
            else if(input.equals("exit"))
                loop = false;
            else System.out.printf("輸入錯誤！\n");
        }while(loop);
    }
}