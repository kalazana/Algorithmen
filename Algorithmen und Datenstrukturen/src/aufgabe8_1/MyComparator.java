package aufgabe8_1;

import java.util.Comparator;

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.getData() - y.getData();
    }
}