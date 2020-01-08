package aufgabe1_1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Liste {
	private Element anfang = null;
	private Element zeiger = null;

	// speichern einer Liste als csv-Datei
	public void writeList(String _dName) throws IOException {
		zeiger = anfang;
		BufferedWriter out = new BufferedWriter(new FileWriter(_dName + ".csv"));
		out.write("Vorname;Nachname;Geb. Datum;Ver. Nummer\r\n");
		while (zeiger != null) {
			out.write(zeiger.getVName() + ";" + zeiger.getNName() + ";" + zeiger.getGDatum() + ";" + zeiger.getVerNum()
					+ "\r\n");
			zeiger = zeiger.getNext();
		}
		out.close();
	}

	public static String loadListe(String _dName) throws IOException{
		File file = new File(_dName+".csv");

		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while((st = br.readLine())!= null){
			System.out.println(st);
		}
		return st;
	}

	public Liste() {
	}

	// Konstruktor, der eine bereits vorhandene liste lädt
	public Liste(String _dName) throws IOException {
		File f = new File(_dName + ".csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		br.readLine();
		// System.out.println("ja");
		String line = br.readLine();
		String[] spalte = new String[4];
		while (line != null) {
			spalte = line.split(";");
			append(spalte[0], spalte[1], spalte[2], Integer.parseInt(spalte[3]));
			line = br.readLine();
		}
		br.close();
	}

	// fügt ein Element ans Ende an
	public void append(String _vName, String _nName, String _gDatum, int _verNum) {
		Element ele = new Element(_vName, _nName, _gDatum, _verNum);
		if (anfang == null) {
			ele.setNext(null);
			ele.setPre(null);
			anfang = ele;
		} else {
			zeiger = anfang;
			while (zeiger.getNext() != null)
				zeiger = zeiger.getNext();

			ele.setPre(zeiger);
			ele.setNext(null);
			zeiger.setNext(ele);
		}
	}

	// zählt die Elemente in der Liste und gibt sie zürück
	public int countEle() {
		if (anfang == null) {
			return 0;
		} else {
			zeiger = anfang;
			int count = 0;
			while (zeiger != null) {
				zeiger = zeiger.getNext();
				count++;
			}
			return count;
		}
	}

	// gibt die ganze Liste auf der Konsole aus
	public void print() {
		if (anfang == null) {
			System.out.println("Kein Element vorhanden!");
		} else {
			zeiger = anfang;
			int count = 0;
			while (zeiger != null) {
				count++;
				System.out.print("(" + count + ") ");
				System.out.println(zeiger.print());
				zeiger = zeiger.getNext();
			}
		}
	}

	// findet ein Element und gibt es zurück

	public String find(int _verNum) {
		if (anfang == null) {
			return "Die Liste ist leer!";
		} else {
			zeiger = anfang;
			while (zeiger != null) {
				if (zeiger.getVerNum() == _verNum)
					return zeiger.print();

				zeiger = zeiger.getNext();
			}
			return ("Das Element mit der Ver. Nummer (" + _verNum + ") ist in der Liste nicht enthalten!");
		}
	}

	// löschen eines Elementes
	public boolean delete(int _verNum) {
		if (anfang != null) {
			zeiger = anfang;
			while (zeiger != null) {
				if (zeiger.getVerNum() == _verNum) {
					if (zeiger.getPre() != null && zeiger.getNext() != null) { // Element in der Mitte
						zeiger.getNext().setPre(zeiger.getPre());
						zeiger.getPre().setNext(zeiger.getNext());
						return true;
					}
					if (zeiger.getPre() == null && zeiger.getNext() != null) { // erstes Element
						zeiger.getNext().setPre(null);
						anfang = zeiger.getNext();
						return true;
					}
					if (zeiger.getPre() != null && zeiger.getNext() == null) { // letztes Element
						zeiger.getPre().setNext(null);
						return true;
					}
					if (zeiger.getPre() == null && zeiger.getNext() == null) { // einziges Element
						anfang = null;
						return true;
					}
				} else {
					zeiger = zeiger.getNext();
				}
			}
			return false;
		}
		return false;
	}
}
