// 程式ch7_1.java  圖形的建立與走訪
import java.util.*;

class Graph {
    GNODE front, rear;
    Graph.GNODE [] g;
    int [] visited;

    class GNODE {
        int vertex;
        GNODE link;
    }

    void make_list(int i) {
        GNODE  p, q;
        int d;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        p = g[i];
        System.out.printf("\n***若無相鄰頂點請輸入0***\n");
        do {
            System.out.printf("輸入與頂點%d相鄰的頂點：", i);
            d = in.nextInt();
            if (d == i)
                System.out.printf("不能有自身迴路！請重新輸入！\n");
            else if (d != 0) {
                q = new GNODE();
                q.vertex = d;
                q.link = null;

                if (g[i] == null)
                    g[i] = q;
                else
                    p.link = q;

                p = q;
            }
        } while (d != 0);
    }


    //深度優先搜尋：利用遞迴
    void dfs(int v)
    {
        GNODE p;

        System.out.printf("%3d",v);
        visited[v] = 1;

        for(p = g[v]; p != null ; p = p.link)
            if(visited[p.vertex] == 0)
                dfs(p.vertex);
    }

    //將頂點放入等待訪走的佇列中
    void add_queue(int d) {
        GNODE p = new GNODE();
        p.vertex = d;
        p.link = null;

        if(front == null)
            front = p;
        else
            rear.link=p;
        rear = p;
    }

    //從等待走訪的佇列中取出頂點
    int delete_queue() {
        int d = front.vertex;
        front = front.link;
        return d;
    }

    //廣度優先搜尋：利用佇列
    void bfs(int v) {
        GNODE p;

        visited[v] = 1;
        add_queue(v);

        while(front != null){
            v = delete_queue();
            System.out.printf("%3d", v);
            for(p = g[v]; p != null ; p = p.link)
                if(visited[p.vertex] == 0){
                    visited[p.vertex] = 1;
                    add_queue(p.vertex);
                }
        }
    } //end of bfs()
}

public class Main {

    public static void main(String [] args){
        int n;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件
        Graph graph = new Graph();

        System.out.printf("***圖形的建立***\n\n");
        System.out.printf("輸入頂點個數：");
        n = in.nextInt();
        graph.g = new Graph.GNODE[n+1];
        graph.visited = new int[n+1];

        for(int i = 1; i <= n; i++) graph.g[i] = null;
        for(int i = 1; i <= n; i++) graph.make_list(i);

        System.out.printf("\n\n***圖形的走訪***");
        System.out.printf("\n\n深度優先搜尋：");
        for(int i = 1; i <= n; i++)  graph.visited[i] = 0;
        graph.dfs(1);

        System.out.printf("\n\n廣度優先搜尋：");
        for(int i = 1; i <= n; i++) graph.visited[i] = 0;
        graph.bfs(1);
    }
}