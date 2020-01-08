package aufgabe1_1;


public class Element {
	private String vName;
	private String nName;
	private String gDatum;
	private int verNum;
	private Element next;
	private Element pre;

	public Element(String _vName, String _nName, String _gDatum, int _verNum) {
		vName = _vName;
		nName = _nName;
		gDatum = _gDatum;
		verNum = _verNum;
	}

	public void setNext(Element _next) {
		next = _next;
	}

	public Element getNext() {
		return next;
	}

	public void setPre(Element _pre) {
		pre = _pre;
	}

	public Element getPre() {
		return pre;
	}

	public String getGDatum() {
		return gDatum;
	}

	public String getNName() {
		return nName;
	}

	public String getVName() {
		return vName;
	}

	public int getVerNum() {
		return verNum;
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		if (vName.length() > 7)
			sb.append(vName + "	");
		else
			sb.append(vName + "	");

		if (nName.length() > 7)
			sb.append(nName + "	");
		else
			sb.append(nName + "		");

		sb.append(gDatum + "	");
		sb.append(verNum);
		return sb.toString();
	}
}
