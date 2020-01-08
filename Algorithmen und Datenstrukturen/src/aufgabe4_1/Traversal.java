package aufgabe4_1;

import java.util.LinkedList;
import java.util.Queue;


public class Traversal {
	public void preOrder(final Node node) {
		System.out.print(node.getCharacter());
		if (node.getLeftNode() != null) {
			preOrder(node.getLeftNode());
		}
		if (node.getRightNode() != null) {
			preOrder(node.getRightNode());
		}
	}

	public void inOrder(Node node) {
		if (node.getLeftNode() != null)
			inOrder(node.getLeftNode());
		System.out.print(node.getCharacter());
		if (node.getRightNode() != null)
			inOrder(node.getRightNode());
	}

	public void postOrder(Node node) {
		if (node.getLeftNode() != null)
			postOrder(node.getLeftNode());
		if (node.getRightNode() != null)
			postOrder(node.getRightNode());
		System.out.print(node.getCharacter());
	}

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {
				Node node = q.peek();
				assert node != null;
				System.out.print(node.getCharacter() + " ");
				q.remove();
				if (node.getLeftNode() != null)
					q.add(node.getLeftNode());
				if (node.getRightNode() != null)
					q.add(node.getRightNode());
				nodeCount--;
			}
			System.out.println();
		}
	}
}
