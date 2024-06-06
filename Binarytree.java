
import java.util.*;



/**
 * Binarytree
 */
public class Binarytree {

    public Binarytree(){

    }
private static class Node{
    int value;
    Node left;
    Node right;


public Node(int value){
    this.value=value;

}
}
private Node root;

//insert
public void populate(Scanner sc){
    System.out.println("enter root value");
    int value= sc.nextInt();
    root = new Node(value);
    populate(sc,root);
}
private void populate(Scanner sc ,Node node){
   System.err.println("Do you want to enter left node"+node.value); 
boolean left= sc.nextBoolean();
if(left){
    System.err.println("enter value"+node.value);
    int value= sc.nextInt();
    node.left=new Node(value);
    populate(sc, node.left);
}
System.out.println("Do you want to enter right of " + node.value);
    boolean right = sc.nextBoolean();
    if (right) {
      System.out.println("Enter the value of the right of " + node.value);
      int value = sc.nextInt();
      node.right = new Node(value);
      populate(sc, node.right);
    }

}
public void display() {
    display(this.root, "");
  }

  private void display(Node node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(indent + node.value);
    display(node.left, indent + "\t");
    display(node.right, indent + "\t");
  }
  public static void main(String[] args) {
    Scanner scc= new Scanner(System.in);

    Binarytree b= new Binarytree();
    b.populate(scc); 
    b.display();



    
  }
}

  