// CH2-1.java 陣列的基本運算：存入(store)與取出(retrieve)

public class Main {
    public static void main(String [] args){
        int [] a = new int [3];                    //宣告整數陣列
        int i;

        a[0]=1;                    //資料存入陣列中
        a[1]=3;
        a[2]=5;

        for(i = 0; i < 3; i++){
            System.out.printf(a[i] + "\n"); //列印陣列資料
        }
    }
}
