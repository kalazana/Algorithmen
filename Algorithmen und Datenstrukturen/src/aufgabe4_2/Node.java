package aufgabe4_2;


public class Node {

    private char character;
    private Node parentNode = null;
    private Node rightNode = null;
    private Node leftNode = null;

    public Node(char character) {
        this.character = character;
    }


    /**
     * Create new node with content c and append right of current node
     *
     * @param c Content of Right-Sub-Node
     * @return new Right-Sub-Node
     */
    public Node appendRightNode(char c) {
        Node right = new Node(c);
        right.setParentNode(this);
        this.setRightNode(right);
        return right;
    }

    /**
     * Create new node with content c and append left of current node
     *
     * @param c Content of Left-Sub-Node
     * @return new Left-Sub-Node
     */
    public Node appendLeftNode(char c) {
        Node left = new Node(c);
        left.setParentNode(this);
        this.setLeftNode(left);
        return left;
    }

    /**
     * Remove Node and all of its sub-nodes
     */
    public void remove() {
        if (getRightNode() != null) {
            this.removeRightNode();
        }
        if (getLeftNode() != null) {
            this.removeLeftNode();
        }
    }

    /**
     * Remove Right-Sub-Node and all of it's nodes
     */
    public void removeRightNode() {
        getRightNode().remove();
        setRightNode(null);
    }

    /**
     * Remove Right-Sub-Node and all of it's nodes
     */
    public void removeLeftNode() {
        getLeftNode().remove();
        setLeftNode(null);
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
}


