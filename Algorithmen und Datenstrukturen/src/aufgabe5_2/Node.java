package aufgabe5_2;

public class Node {
    /**
     * @param left - left node
     */
    private Node left;
    /**
     * @param right - right node
     */
    private Node right;
    /**
     * @param name - name of the node
     */
    private String name;


    public Node(String name) {
        setName(name);
        setLeft(null);
        setRight(null);
    }

    public void show() {
        System.out.println(this.name);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
