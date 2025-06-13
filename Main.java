import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinarySearchTree tree = new BinarySearchTree();
    tree.populate(scanner);
    tree.prettyDisplay();
  }
}