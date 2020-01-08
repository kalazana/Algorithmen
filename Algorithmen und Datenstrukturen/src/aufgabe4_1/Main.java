package aufgabe4_1;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.appendText("Dies ist ein binaerer Baum zum traversieren.");
		tree.printTree();

		Traversal traversal = new Traversal();

		System.out.println("\n\nPreOrder:");
		traversal.preOrder(tree.getRoot());

		System.out.println("\n\nInOrder:");
		traversal.inOrder(tree.getRoot());

		System.out.println("\n\nPostOrder:");
		traversal.postOrder(tree.getRoot());

		System.out.println("\n\nLevelOrder:");
		traversal.levelOrder(tree.getRoot());
	}
}
