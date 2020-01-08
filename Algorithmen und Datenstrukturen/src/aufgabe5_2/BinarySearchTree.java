package aufgabe5_2;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public BinarySearchTree insert(String name) {
        root = insertRecursive(root, name);
        return this;
    }

    private Node insertRecursive(Node root, String name) {
        if (root == null) {
            root = new Node(name);
        }
        int compare = name.compareTo(root.getName());
        if (compare < 0) {
            root.setLeft(insertRecursive(root.getLeft(), name));
        } else  if (compare > 0) {
            root.setRight(insertRecursive(root.getRight(), name));
        }
        return root;
    }

    public void show() {
        showRecursive(root);
    }

    private void showRecursive(Node node) {
        if (node != null) {
            showRecursive(node.getLeft());
            node.show();
            showRecursive(node.getRight());
        }
    }

    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node node) {
        System.out.print(node.getName() + " ");
        if (node.getLeft() != null) {
            preOrderRecursive(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrderRecursive(node.getRight());
        }
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {
        if (node.getLeft() != null) {
            inOrderRecursive(node.getLeft());
        }
        System.out.print(node.getName() + " ");
        if (node.getRight() != null) {
            inOrderRecursive(node.getRight());
        }
    }

    public void postOrder() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(Node node) {
        if (node.getLeft() != null) {
            postOrderRecursive(node.getLeft());
        }
        if (node.getRight() != null) {
            postOrderRecursive(node.getRight());
        }
        System.out.print(node.getName() + " ");
    }


    public void maxDepth() {
        System.out.println(maxDepth(0, root));
    }

    private int maxDepth(final int depth, final Node node) {
        return node != null ? Math.max(maxDepth(depth+1, node.getLeft()), maxDepth(depth+1, node.getRight())) : depth;
    }
}