package aufgabe4_2;

public class Main {

	    public static void main(final String... args) {
	        Tree tree = new Tree();
	        tree.appendText("Dies ist ein binaerer Baum zum traversieren.");
	        tree.printTree();

	        Travesierung travesierung = new Travesierung();

	        System.out.println("\n\nPreOrder:");
	        travesierung.preOrder(tree.getRoot());

	        System.out.println("\n\nInOrder:");
	        travesierung.inOrder(tree.getRoot());

	        System.out.println("\n\nPostOrder:");
	        travesierung.postOrder(tree.getRoot());

	        System.out.println("\n\nLevelOrder:");
	        travesierung.levelOrder(tree.getRoot());

	        System.out.print("\n\nMax Höhe:  ");
	        System.out.println(travesierung.maxDepth(0, tree.getRoot()));
	        System.out.print("Amzahl an Knoten: ");
	        System.out.println(travesierung.numberNodes(-1, tree.getRoot()));
	        System.out.print("Anzahl an Blätter: ");
	        System.out.println(travesierung.numberLeaves(0, tree.getRoot()));
	        System.out.print("Pfadlänge: ");
	        System.out.println(travesierung.pathLength(0, tree.getRoot()));
	    }
	}
