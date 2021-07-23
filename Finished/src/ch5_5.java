//   程式ch5_5.java    鏈結佇列
import java.util.*;
class Queue{
    public QNODE front = null, rear = null;

    class QNODE{ //定義節點
        int data;
        QNODE link;

        QNODE(int key) {
            this.data = key;
            this.link = null;
        }
    }

    void add(int key){       //加入資料至佇列尾端
        QNODE p = new QNODE(key);
        if(front == null)
            front = p;
        else
            rear.link = p;
        rear = p;
    }

    int delete(){           //刪除佇列前端資料
        int key = front.data;
        front = front.link;
        return key;
    }
}


public class Main {

    public static void main(String [] args){
        Queue q = new Queue();
        int key;
        String input;
        boolean loop = true;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("*** 鏈結佇列 ***\n");
        System.out.printf("指令如下：add,delete,exit\n\n");
        do{
            System.out.printf ("==>");
            input = in.nextLine();
            if(input.equals("add")){
                System.out.printf("輸入資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                q.add(key);	//將新資料加入佇列
            }
            else if(input.equals("delete")){
                if(q.front == null)
                    System.out.printf("空佇列無法刪除\n");
                else
                    System.out.printf("%d\n",q.delete());  //刪除佇列前端節點
            }
            else if(input.equals("exit"))
                loop = false;
            else
                System.out.printf("輸入錯誤\n");
        }while(loop);
    }
}