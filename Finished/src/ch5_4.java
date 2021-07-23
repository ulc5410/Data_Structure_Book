//   程式ch5_4.java    鏈結堆疊
import java.util.*;

class SNODE{ //定義節點
    int data;
    SNODE link;

    static SNODE newsnode(int key){
        SNODE p =new SNODE();
        p.data = key;
        p.link = null;
        return p;
    }


    //插入節點p至堆疊頂端
    static void push(SNODE stack, int key) {
        SNODE p = newsnode(key);
        p.link = stack.link;
        stack.link = p;
    }

    //取出堆疊頂端後，刪除節點
    static int pop(SNODE stack) {
        int key;
        key = stack.link.data;
        stack.link = stack.link.link;
        return key;
    }
}

public class Main {

    public static void main(String [] args){
        int key;
        String input;
        boolean loop = true;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件
        SNODE top = SNODE.newsnode(-1); // -1 的下一個node為實際的top

        System.out.printf("***鏈結堆疊***\n");
        System.out.printf("指令如下：push,pop,exit\n");


        do{
            System.out.printf("==>");
            input = in.nextLine();
            if(input.equals("push")){
                System.out.printf("輸入資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                SNODE.push(top, key); 	   //將新資料加入堆疊
            }
            else if(input.equals("pop")){
                if(top.link == null )
                    System.out.printf("空堆疊無法刪除\n");
                else
                    System.out.printf("%d\n",SNODE.pop(top));	 //刪除頂端資料
            }
            else if(input.equals("exit"))
                loop = false;
            else
                System.out.printf("輸入錯誤\n");
        } while(loop);
    }
}