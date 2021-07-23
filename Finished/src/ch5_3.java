//  程式ch5_3.java   單向鏈結串列
import java.util.*;

class NODE{ //定義節點
    int data;
    NODE link;
    static NODE newnode(int key) {
        NODE p = new NODE();
        if(p == null){
            System.out.printf("記憶體不足");
            System.exit(1);
        }
        p.data = key;
        return p;
    }

    static NODE create(int n){           //建立n個節點的鏈結串列
        NODE list, p, q;
        int key;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        list = newnode(0);
        p = list;
        for(int i = 1; i <= n;i++){
            System.out.printf("輸入第%d筆資料：",i);
            key = in.nextInt();
            in.nextLine();//去除多餘的換行
            q = newnode(key);
            p.link = q;
            p = q;
        }
        p.link = null;
        return list;
    }

    static NODE findnode(NODE list, int key){   //搜尋節點
        NODE p = list.link;
        while(p!=null && p.data!=key)
            p = p.link;
        return p;
    }

    static NODE findnode_n(NODE list, int n){  //搜尋第n個節點
        NODE p;
        int counter = 0;
        p = list;
        while(p!=null && counter<n){
            p = p.link;
            counter++;
        }
        return p;
    }

    static NODE prenode(NODE list, int key){  //搜尋前一個節點
        NODE p = list;
        while(p!=null && p.link.data!=key)
            p = p.link;
        return p;
    }

    static NODE nextnode(NODE p){   //搜尋下一個節點
        if(p != null)
            return p.link;
        return p;
    }

    static int value(NODE p) {      //傳回節點資料
        return p.data;
    }

    static void insert(NODE p, NODE q){       //新增節點
        q.link = p.link;
        p.link = q;
    }

    static void delete(NODE p, NODE q) {     //刪除節點
        p.link = q.link;
    }

    static void update(NODE p, int newkey){   //更新資料
        p.data = newkey;
    }

    static int length(NODE list){           //計算串列長度
        NODE p;
        int counter = 0;

        p = list.link;
        while(p!=null){
            counter++;
            p = p.link;
        }
        return counter;
    }

    static void display(NODE list){        //列印串列所有資料
        NODE p = list.link;

        while(p!=null){
            System.out.printf("%d ",p.data);
            p = p.link;
        }
        System.out.printf("\n");
    }
}

public class Main {

    public static void main(String [] args){
        NODE list, p, q;
        int n, key, newkey, pre;
        String input;
        boolean loop = true;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("***鏈結串列***\n");
        System.out.printf("指令如下：\n");
        System.out.printf("create,insert,insert_n,delete,delete_n,\n");
        System.out.printf("update,update_n,nextdata,predata,\n");
        System.out.printf("display,length,exit\n");

        list = null;

        do{
            System.out.printf("==>");
            input = in.nextLine();
            if(input.equals("create")){
                System.out.printf("輸入資料個數：");
                n = in.nextInt();
                in.nextLine(); //去除多餘的換行
                list = NODE.create(n);        //建立n個節點的鏈結串列
            }
            else if(input.equals("insert")){
                System.out.printf("輸入欲加入的資料");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                System.out.printf("新資料加入於哪筆資料值之後？");
                pre = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode(list,pre);   //尋找插入點
                if(p == null)
                    System.out.printf("找不到資料%d，無法加入資料%d\n",pre,key);
                else{
                    q = NODE.newnode(key);      //製作新節點
                    NODE.insert(p,q);         //新節點q插入於節點p之後
                }
            }
            else if(input.equals("insert_n")){
                System.out.printf("輸入欲加入的資料: ");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                System.out.printf("新資料加入於第幾筆資料之後？");
                n = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode_n(list,n);     //尋找插入點
                if(p == null)
                    System.out.printf("無第%d筆資料，無法加入資料%d\n",n,key);
                else{
                    q = NODE.newnode(key);        //製作新節點
                    NODE.insert(p,q);           //新節點q插入於節點p之後
                }
            }
            else if(input.equals("delete")){
                System.out.printf("輸入欲刪除的資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.prenode(list,key);
                if(p == null)
                    System.out.printf("找不到資料%d，故無法刪除\n",key);
                else
                    NODE.delete(p, p.link);         //刪除節點p之後的節點q
            }
            else if(input.equals("delete_n")){
                System.out.printf("欲刪除第幾筆資料：");
                n = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode_n(list,n-1);
                if(p == null)
                    System.out.printf("找不到第%d筆資料，故無法刪除\n",n);
                else
                    NODE.delete(p,p.link);         //刪除節點p之後的節點q
            }
            else if(input.equals("update")){
                System.out.printf("輸入原資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                System.out.printf("資料更新為：");
                newkey = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode(list,key);
                if(p == null)
                    System.out.printf("找不到資料%d，故無法更新\n",key);
                else
                    NODE.update(p,newkey);
            }
            else if(input.equals("update_n")){
                System.out.printf("欲更新第幾筆資料：");
                n = in.nextInt();
                in.nextLine(); //去除多餘的換行
                System.out.printf("資料更新為：");
                newkey = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode_n(list,n);
                if(p == null)
                    System.out.printf("無第%d筆資料，故無法更新\n",n);
                else
                    NODE.update(p,newkey);
            }
            else if(input.equals("nextdata")){
                System.out.printf("請輸入欲查詢的資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.findnode(list,key);
                if(p == null)
                    System.out.printf("查無資料%d \n",key);
                else{
                    q = NODE.nextnode(p);
                    if(q == null)
                        System.out.printf("%d 無下一筆資料\n",key);
                    else
                        System.out.printf("%d 下一筆為 %d\n",key, NODE.value(q));
                }
            }
            else if(input.equals("predata")){
                System.out.printf("請輸入欲查詢的資料：");
                key = in.nextInt();
                in.nextLine(); //去除多餘的換行
                p = NODE.prenode(list,key);
                if(p==null)
                    System.out.printf("查無資料%d \n",key);
                else if(p==list)
                    System.out.printf("%d 無前一筆資料\n",key);
                else
                    System.out.printf("%d 的前一筆為 %d\n",key,NODE.value(p));
            }
            else if(input.equals("display"))
                NODE.display(list);
            else if(input.equals("length"))
                System.out.printf("串列中資料的個數為 %d\n",NODE.length(list));
            else if(input.equals("exit"))
                loop = false;
            else
                System.out.printf("輸入錯誤\n");
        } while(loop);
    }
}