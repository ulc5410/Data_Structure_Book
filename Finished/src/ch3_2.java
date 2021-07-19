//程式ch3_2.java  利用堆疊將中序式轉為後序式
import java.util.Scanner;

public class Main {
    private static final int N = 80;
    static char [] stack = new char[N];
    static int top = -1;
    static char [] infix = new char[N];	//儲存中序運算式
    static char [] postfix = new char[N];	//儲存後序運算式

    static void push(char d)	//加入資料d於堆疊內
    {
        if(top==N-1){
            System.out.printf("堆疊滿了\n");
            System.exit(1);
        }
        stack[++top]=d;
    }

    static char pop()	//傳回並刪除堆疊的頂端資料
    {
        if(top==-1){
            System.out.printf("堆疊空了\n");
            System.exit(1);
        }
        return stack[top--];
    }

    static void infix_to_postfix()	//中序轉後序運算式
    {
        char token;
        int i = 0, j = 0;

        while(i < infix.length){
            token=infix[i++];
            switch(token){
                case '(':push(token);
                    break;
                case ')':while(stack[top]!='(' )
                    postfix[j++]=pop();
                    pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':	//若非空堆疊則比較優先權
                    while((top!=-1)&&(p(stack[top])>=p(token)))
                        postfix[j++]=pop();
                    push(token);
                    break;
                default:postfix[j++]=token;	//運算元直接輸出至後序式
            }
        }

        while(top!=-1)
            postfix[j++]=pop();
    } /*end of infix-to-postfix*/

    static int  p(char d)	//取得運算符的優先權
    {
        if(d=='*' || d=='/')		  //乘除運算符優先權最高
            return(2);
        else if(d=='+' || d=='-')	//加減運算符優先權次之
            return(1);
        else
            return(0);			  //否則必為(，優先權最低
    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        System.out.printf("輸入中序四則運算式：");
        infix = in.nextLine().toCharArray();
        infix_to_postfix();				  //呼叫中序式轉後序式函數
        System.out.printf("則後序四則運算式為：%s\n", new String(postfix, 0, infix.length));
    }
}