package aufgabe4_2;

import java.util.LinkedList;
import java.util.Queue;


public class Travesierung {

	    public void preOrder(final Node node) {
	        System.out.print(node.getCharacter());
	        if (node.getLeftNode() != null) {
	            preOrder(node.getLeftNode());
	        }
	        if (node.getRightNode() != null) {
	            preOrder(node.getRightNode());
	        }
	    }

	    public void inOrder(final Node node) {
	        if (node.getLeftNode() != null) {
	            inOrder(node.getLeftNode());
	        }
	        System.out.print(node.getCharacter());
	        if (node.getRightNode() != null) {
	            inOrder(node.getRightNode());
	        }
	    }

	    public void postOrder(final Node node) {
	        if (node.getLeftNode() != null) {
	            postOrder(node.getLeftNode());
	        }
	        if (node.getRightNode() != null) {
	            postOrder(node.getRightNode());
	        }
	        System.out.print(node.getCharacter());
	    }

	    public void levelOrder(final Node root) {
	        if (root == null) {
	            return;
	        }

	        Queue<Node> q = new LinkedList<Node>();

	        q.add(root);

	        while (true) {
	            int nodeCount = q.size();
	            if (nodeCount == 0) {
	                break;
	            }

	            while (nodeCount > 0) {
	                Node node = q.peek();
	                assert node != null;
	                System.out.print(node.getCharacter() + " ");
	                q.remove();
	                if (node.getLeftNode() != null) {
	                    q.add(node.getLeftNode());
	                }
	                if (node.getRightNode() != null) {
	                    q.add(node.getRightNode());
	                }
	                nodeCount--;
	            }
	            System.out.println();
	        }
	    }

	    public int maxDepth(final int depth, final Node node) {
	        if (node != null) {
	            return Math.max(
	                    maxDepth(depth + 1, node.getLeftNode()),
	                    maxDepth(depth + 1, node.getRightNode())
	            );
	        }
	        return depth - 1;
	    }

	    public int numberNodes(int number, final Node node){
	        number++;
	        if (node.getLeftNode() != null) {
	            number = numberNodes(number, node.getLeftNode());
	        }
	        if (node.getRightNode() != null) {
	            number = numberNodes(number, node.getRightNode());
	        }
	        return number;
	    }

	    public int numberLeaves(int number, final Node node) {
	        if (node.getLeftNode() != null) {
	            number = numberLeaves(number, node.getLeftNode());
	        }
	        if (node.getRightNode() != null) {
	            number = numberLeaves(number, node.getRightNode());
	        }
	        if(node.getLeftNode() == null && node.getRightNode() == null)
	        {
	            number++;
	        }
	        return number;
	    }

	    public int pathLength(int number, final Node root) {
	        int counter = -1;

	        if (root == null) {
	            return 0;
	        }

	        Queue<Node> q = new LinkedList<Node>();

	        q.add(root);

	        while (true) {
	            counter++;
	            int nodeCount = q.size();
	            if (nodeCount == 0) {
	                break;
	            }

	            number += nodeCount * counter;

	            while (nodeCount > 0) {
	                Node node = q.peek();
	                assert node != null;
	                q.remove();
	                if (node.getLeftNode() != null) {
	                    q.add(node.getLeftNode());
	                }
	                if (node.getRightNode() != null) {
	                    q.add(node.getRightNode());
	                }
	                nodeCount--;
	            }
	        }
	        return number;
	    }
	}


