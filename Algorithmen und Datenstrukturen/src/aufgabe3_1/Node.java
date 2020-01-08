package aufgabe3_1;


public class Node {
	private char wert;
	private Node rechts = null;
	private Node links = null;

	public Node(char _wert) {
		setWert(_wert);
	}

	public Node links() {
		return links;
	}

	public void setLinks(Node links) {
		this.links = links;
	}

	public Node rechts() {
		return rechts;
	}

	public void setRechts(Node rechts) {
		this.rechts = rechts;
	}

	public char getWert() {
		return wert;
	}

	public void setWert(char wert) {
		this.wert = wert;
	}

	@Override
	public String toString() {
		return wert + "";
	}
}
