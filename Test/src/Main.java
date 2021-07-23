//   程式ch5_4.java    鏈結堆疊
import java.util.*;
class Stack{
    public SNODE top = null;

    static class SNODE { //定義節點
        int data;
        SNODE link;
        SNODE(int key) {
            data = key;
            link = null;
        }
    }
    //插入節點p至堆疊頂端
    void push(int key) {
        SNODE p = new SNODE(key);
        p.link = top;
        top = p;
    }

    //取出堆疊頂端後，刪除節點
    int pop() {
        int key;
        key=top.data;
        top=top.link;
        return key;
    }

}

public class Main {

    public static void main(String [] args){
        Stack s = new Stack();
        int key;
        String input;
        boolean loop = true;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("***鏈結堆疊***\n");
        System.out.printf("指令如下：push,pop,exit\n");


        do{
            System.out.printf("==>");
            input = in.nextLine();
            if(input.equals("push")){
                System.out.printf("輸入資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                s.push(key); 	   //將新資料加入堆疊
            }
            else if(input.equals("pop")){
                if(s.top == null )
                    System.out.printf("空堆疊無法刪除\n");
                else
                    System.out.printf("%d\n",s.pop());	 //刪除頂端資料
            }
            else if(input.equals("exit"))
                loop = false;
            else
                System.out.printf("輸入錯誤\n");
        } while(loop);
    }
}