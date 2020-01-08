package aufgabe8_1;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        Huffman huffman = new Huffman();

        HashMap<Character, Counter> characters = huffman.count();

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<>(characters.size() - 1, new MyComparator());

        for (Map.Entry<Character, Counter> entry : characters.entrySet()) {

            // creating a huffman node object
            // and adding it to the priority-queue.
            HuffmanNode hn = new HuffmanNode();

            hn.setC(entry.getKey());
            hn.setData(entry.getValue().get());

            hn.setLeft(null);
            hn.setRight(null);

            // add functions adds
            // the huffman node to the queue.
            q.add(hn);
        }

        // create a root node
        HuffmanNode root = null;

        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.
        while (q.size() > 1) {

            // first min extract.
            HuffmanNode x = q.peek();
            q.poll();

            // second min extract.
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            assert y != null;
            f.setData(x.getData() + y.getData());
            f.setC('#');

            // first extracted node as left child.
            f.setLeft(x);

            // second extracted node as the right child.
            f.setRight(y);

            // marking the f node as the root node.
            root = f;

            // add this node to the priority-queue.
            q.add(f);
        }

        // print characters and their numbers
        for (Map.Entry<Character, Counter> entry : characters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get());
        }

        // print the codes by traversing the tree
        huffman.printCode(root, "");

        // calculate number of bits with huffmann
        huffman.getBitsWithHuffmann(root, characters, "");

        // calculate number of bits without huffmann
        huffman.getBitsWithoutHuffmann(characters);

        System.out.println("Anzahl an Bits, ohne Huffmann: " + huffman.getNumberOfBitsWithoutHuffmann());
        System.out.println("Anzahl an Bits, mit Huffmann: " + huffman.getNumberOfBitsWithHuffmann());
    }
}
