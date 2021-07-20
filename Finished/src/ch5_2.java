//  程式ch5_2.java  製作兩個節點的鏈結串列
import java.util.*;

class ListNode{ //定義節點
    char info;
    ListNode next;

    static ListNode getNode(){ //產生新節點
        ListNode p = new ListNode();
        return p;
    }

    static ListNode two_nodes() {    //建立兩個節點的鏈結串列
        ListNode p, q;//宣告p,q
        p = getNode();   //分配新節點空間
        p.info = 'a';   //儲存資料值'a'
        q = getNode();   //分配新節點空間
        q.info = 'b';   //儲存資料值'b'
        q.next = null;  //q無下一節點，故其鏈結指向NULL
        p.next = q;        //讓p的鏈結指向節點q
        //即q為p的下一個節點
        return p;        //傳回指向串列開頭的指標p
    }
}

public class Main {
    public static void main(String [] args){
        ListNode list;
        list = ListNode.two_nodes();	               //建立兩個節點之串列
        System.out.printf("%c\n",list.info);	       //印出串列的第一筆資料
        System.out.printf("%c\n",list.next.info);  //印出串列的第二筆資料
    }
}