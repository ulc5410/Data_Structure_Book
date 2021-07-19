//程式ch3_1.java  陣列堆疊
import java.util.Scanner;

public class Main {
    private static final int N = 100;
    static int [] stack = new int[N];
    static int top = -1;

    static void push(int d)	//加入資料d於堆疊內
    {
        if(top==N-1){
            System.out.printf("堆疊滿了\n");
            System.exit(1);
        }
        stack[++top]=d;
    }

    static int pop()	//傳回並刪除堆疊的頂端資料
    {
        if(top==-1){
            System.out.printf("堆疊空了\n");
            System.exit(1);
        }
        return stack[top--];
    }

    public static void main(String [] args){
        int d;
        boolean loop = true;	//loop為迴圈之控制變數
        String input;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("***陣列堆疊***\n");
        System.out.printf("可執行下列指令：push, pop, +, -, exit\n\n");

        do {
            System.out.printf("==>");
            input = in.nextLine();
            if(input.equals("push")){	//字串比較
                System.out.printf("輸入數值：");
                d = in.nextInt();
                in.nextLine(); //去除多餘的換行
                push(d);
            }
            else if(input.equals("pop"))
                System.out.printf("%d\n",pop());
            else if(input.equals("+"))
                push(pop()+pop());
            else if(input.equals("-"))
                push(pop()-pop());
            else if(input.equals("exit"))
                loop = false;
            else
                System.out.printf("輸入錯誤！\n");
        } while(loop);

        System.out.printf("Bye-Bye！\n");
    }
}