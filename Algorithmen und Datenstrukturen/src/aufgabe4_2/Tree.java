package aufgabe4_2;

import java.util.Stack;


public class Tree {


	    private Node root = new Node(' ');

	    public Node getRoot() {
	        return root;
	    }

	    /**
	     * Append a new text to tree.
	     * If first append, start with root node.
	     * Otherwise start after current left end.
	     *
	     * @param text Text to append to.
	     */
	    public void appendText(final String text) {
	        char[] chars = text.toCharArray();
	        Node currentEnd = getLeftEnd();
	        Stack<String> s1 = new Stack<>();
	        if (currentEnd.getParentNode() != null) {
	            s1.push(" ");
	        } else {
	            s1.push("");
	        }
	        for (char c : chars) {
	            if (c == 32 || c == 46 || c == 44 || c == 33 || c == 63) {
	                s1.push("" + c);
	            } else {
	                String pop = s1.pop();
	                s1.push(pop + c);

	            }
	        }
	        String[] strings = s1.toArray(new String[0]);
	        for (String aS1 : strings) {
	            currentEnd = getLeftEnd();
	            if (strings[strings.length -1].equals(aS1)) {
	            	appendWord(currentEnd, aS1, true);
	            }else {
	            	appendWord(currentEnd, aS1, false);
	            }
	        }
	    }

	    /**
	     * Append a word to a node.
	     *
	     * @param node Node to append word to, node is part of word
	     * @param word Word to append
	     */
	    private void appendWord(final Node node, final String word, boolean lastWord) {
	        char[] chars = word.toCharArray();
	        Node currentNode = node;
	        currentNode.setCharacter(chars[0]);
	        for (int i = 1; i < chars.length; i++) {
	            currentNode = currentNode.appendRightNode(chars[i]);
	        }
	        if(!lastWord) {
	        	node.appendLeftNode(' ');
	        }
	    }

	    /**
	     * Get left end of tree.
	     *
	     * @return Node at left end
	     */
	    private Node getLeftEnd() {
	        Node currentNode = root;
	        Node endNode = null;
	        do {
	            endNode = currentNode;
	            currentNode = currentNode.getLeftNode();
	        }
	        while (currentNode != null);
	        return endNode;
	    }

	    /**
	     * Get right end of a node.
	     *
	     * @return node at right end of node
	     */
	    private Node getRightEnd() {
	        Node currentNode = root;
	        Node endNode = null;
	        do {
	            endNode = currentNode;
	            currentNode = currentNode.getRightNode();
	        }
	        while (currentNode != null);
	        return endNode;
	    }

	    /**
	     * Print current tree content.
	     */
	    public void printTree() {
	        Node currentNode = root;
	        while (currentNode != null) {
	            System.out.print(currentNode.getCharacter());
	            Node rightNode = currentNode.getRightNode();
	            while (rightNode != null) {
	                System.out.print(rightNode.getCharacter());
	                rightNode = rightNode.getRightNode();
	            }
	            currentNode = currentNode.getLeftNode();
	        }
	    }
	}

