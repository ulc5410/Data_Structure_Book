//  程式ch6_1.java   二元樹的建立及走訪
import java.util.*;

class BinaryTree{
    TNODE root;

    BinaryTree(char d){
        root = make_tree(d);
    }

    class TNODE{
        char data;
        TNODE left;
        TNODE right;

        TNODE(char d){
            left = null;
            right = null;
            data = d;
        }
    }

    //建立二元樹：以資料d為樹根
    TNODE make_tree(char d) {
        TNODE tree= null;
        char lchild, rchild;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件

        if(d != '0'){
            tree = new TNODE(d);
            System.out.printf("\n輸入%c的左兒子節點：",d);
            lchild = in.next().charAt(0);
            System.out.printf("\n輸入%c的右兒子節點：",d);
            rchild = in.next().charAt(0);
            tree.left = make_tree(lchild); 	//建立左子樹
            tree.right = make_tree(rchild); 	//建立右子樹
        }
        return tree;
    }

    //前序走訪
    void preorder(TNODE root){
        if(root != null){
            System.out.printf("%2c",root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    //中序走訪
    void inorder(TNODE root) {
        if(root != null){
            inorder(root.left);
            System.out.printf("%2c",root.data);
            inorder(root.right);
        }
    }

    //後序走訪
    void postorder(TNODE root) {
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%2c",root.data);
        }
    }
}
public class Main {

    public static void main(String [] args){
        BinaryTree tree;
        char data;
        Scanner in = new Scanner(System.in); // 讀取輸入用的物件


        System.out.printf("***二元樹的建立***\n");
        System.out.printf("若無節點，請輸入數字0\n\n");
        System.out.printf("輸入樹根節點：");
        data = in.next().charAt(0);
        tree = new BinaryTree(data);
        System.out.printf("\n\n***二元樹的走訪***");
        System.out.printf("\n前序走訪：");
        tree.preorder(tree.root);
        System.out.printf("\n中序走訪：");
        tree.inorder(tree.root);
        System.out.printf("\n後序走訪：");
        tree.postorder(tree.root);
    }
}