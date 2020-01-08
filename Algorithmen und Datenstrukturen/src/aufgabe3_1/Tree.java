package aufgabe3_1;


public class Tree {
	private Node root = null;
	private Node endeLinks = null;
	private Node endeRechts = null;

	public void add(String _string) {
		for (int i = 0; i < _string.length(); i++)
			add(_string.charAt(i));
	}

	private void add(char _c) {
		if (root == null) {
			root = new Node(_c);
			endeLinks = root;
			endeRechts = root;
		} else {
			if (_c == '_' || _c == '.') {
				endeLinks.setLinks(new Node(_c));
				endeLinks = endeLinks.links();
				endeRechts = endeLinks;
			} else {
				endeRechts.setRechts(new Node(_c));
				endeRechts = endeRechts.rechts();
			}
		}

	}

	public void print() {
		Node zeiger = root;
		Node zeigerLinks = root;
		while (zeigerLinks != null) {
			while (zeiger != null) {
				System.out.print(zeiger.getWert());
				zeiger = zeiger.rechts();
			}
			zeigerLinks = zeigerLinks.links();
			zeiger = zeigerLinks;
		}
		System.out.println();
	}
}
