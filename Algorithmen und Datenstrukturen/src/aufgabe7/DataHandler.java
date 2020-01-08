package aufgabe7;


import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataHandler {
	private File filename = new File("data/KHR95_red.txt");
	private int counter = 0;
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private Search search = new Search();

	/**
	 * Reads a list of hospitals from the hard drive.
	 *
	 * @return - List of hospitals
	 */
	public ArrayList<Hospital> read_data() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "windows-1252"));

			ArrayList<Hospital> hospitals = new ArrayList<>();
			if (filename.exists()) {
				String fileContent = bufferedReader.readLine();
				fileContent = bufferedReader.readLine();
				counter++;
				while (fileContent != null) {
					int index = 0;
					Hospital hospital = new Hospital();
					if (!fileContent.equals("")) {
						for (int i = 0; i < 5; i++) {
							switch (i) {
							case 0:
								hospital.setName(fileContent.substring(index, fileContent.indexOf("\t", index)));
								break;
							case 1:
								hospital.setStreet(fileContent.substring(index, fileContent.indexOf("\t", index)));
								break;
							case 2:
								hospital.setPostcode(Integer
										.parseInt(fileContent.substring(index, fileContent.indexOf("\t", index))));
								break;
							case 3:
								hospital.setLocation(fileContent.substring(index, fileContent.indexOf("\t", index)));
								break;
							case 4:
								hospital.setNumberOfBeds(Integer.parseInt(fileContent.substring(index)));
								break;
							}

							index = fileContent.indexOf("\t", index);
							index++;
						}
						hospitals.add(hospital);
					}
					fileContent = bufferedReader.readLine();
					counter++;
				}
			}
			return hospitals;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Writes a list of hospitals on the hard drive.
	 *
	 * @param hospitals - List of hospitals
	 * @param filename  - name of the file to be write
	 */
	public void write_data(ArrayList<Hospital> hospitals, String filename) {
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "windows-1252"));

			bufferedWriter.write("Name" + "\t" + "StrHausNr" + "\t" + "PLZ" + "\t" + "Ort" + "\t" + "Bettenanzahl\n");
			for (Hospital hospital : hospitals) {
				bufferedWriter.write(hospital.getName() + "\t" + hospital.getStreet() + "\t" + hospital.getPostcode()
						+ "\t" + hospital.getLocation() + "\t" + hospital.getNumberOfBeds() + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Writes one record of the hospital list on the console.
	 */
	public void output() {
		try {
			int input;
			bufferedReader = new BufferedReader(new FileReader(filename));

			System.out.println("There are " + counter + " records.");
			System.out.print("Specify a record to output: ");
			Scanner scanner = new Scanner(System.in);
			input = Integer.parseInt(scanner.next());
			for (int i = 0; i < input; i++) {
				if (filename.exists()) {
					bufferedReader.readLine();
				}
			}
			System.out.println(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Searches for an entry by postcode.
	 *
	 * @param hospitals - List of hospitals
	 */
	public void search(ArrayList<Hospital> hospitals, int postcode) {
		int result = search.sequentialSearch(hospitals, postcode);
//        if (result == -1) {
//            System.out.println("Element not present.");
//        } else {
//            System.out.println("Element found at index " + (result + 2) + ".");
//        }
	}

	/**
	 * @param hospitals - List of hospitals
	 * @param sorting
	 * @return
	 */
	public ArrayList<Hospital> selectionSort(ArrayList<Hospital> hospitals, String sorting) {
		Sort sort = new Sort();
		hospitals = sort.selectionSort(hospitals, sorting);
		write_data(hospitals, "data/selectionSort.txt");
		return hospitals;
	}

	/**
	 * @param hospitals - List of hospitals
	 * @param sorting
	 * @return
	 */
	public ArrayList<Hospital> insertionSort(ArrayList<Hospital> hospitals, String sorting) {
		Sort sort = new Sort();
		hospitals = sort.insertionSort(hospitals, sorting);
		write_data(hospitals, "data/insertionSort.txt");
		return hospitals;
	}

	/**
	 * @param hospitals - List of hospitals
	 * @param postcode  - postcode to be searched for
	 */
	public void binarySearch(ArrayList<Hospital> hospitals, int postcode) {

		int result = search.binarySearch(hospitals, 0, hospitals.size(), postcode, 0);
//        if (result == -1) {
//            System.out.println("Element not present.");
//        } else {
//            System.out.println("Element found at index " + (result + 2) + ".");
//        }
	}

	public void getAverageEffort() {

		System.out.println("Average effort (entry found): " + (search.getExpenseFound() / 1000));
		System.out.println("Average effort (entry not found): " + (search.getExpenseNotFound() / 1000));

		search.setCounterFound(0);
		search.setCounterNotFound(0);
		search.setExpenseFound(0);
		search.setExpenseNotFound(0);
	}

	/**
	 * @param hospitals - List of hospitals
	 * @param postcode  - postcode to be searched for
	 */
	public void interpolSearch(ArrayList<Hospital> hospitals, int postcode) {

		int result = search.interpolationSearch(hospitals, postcode, 0);
//        if (result == -1) {
//            System.out.println("Element not present.");
//        } else {
//            System.out.println("Element found at index " + (result + 2) + ".");
//        }
	}

	/**
	 * Determines postcodes that are not included in the hospitals list.
	 *
	 * @param hospitals - List of hospitals
	 * @return - List of not included postcodes
	 */
	public int[] getNotIncludedPostcodes(ArrayList<Hospital> hospitals) {
		Random rnd = new Random();
		int[] postcodes = new int[1000];
		int counter = 0;
		boolean included = false;
		int indexcounter = 0;
		while(postcodes[999] == 0) {
			counter = rnd.nextInt(98999);
			counter += 1000;
			for (Hospital hospital : hospitals) {
				if (counter == hospital.getPostcode()) {
					included = true;
				}
			}
			if (included) {
				included = !included;
				continue;
			}
			postcodes[indexcounter++] = counter;
		}
		return postcodes;
	}

	/**
	 * Selects 1000 random entries from the hospitals list.
	 *
	 * @param hospitals - List of hospitals
	 * @return - List with 1000 random entries from the hospitals list.
	 */
	public int[] getRandomEntries(ArrayList<Hospital> hospitals) {
		Random rnd = new Random();
		int[] postcodes = new int[1000];
		int counter;
		for (int i = 0; i < 1000; i++) {
			counter = rnd.nextInt(hospitals.size());
			postcodes[i] = hospitals.get(counter).getPostcode();
		}
		return postcodes;
	}

	/**
	 * Generates 1000 random numbers between 1000 and 99999.
	 *
	 * @return - int array with 1000 random numbers
	 */
	public int[] getRandomPostcodes() {
		Random rnd = new Random();
		int[] postcodes = new int[1000];
		for (int i = 0; i < 1000; i++) {
			postcodes[i] = (rnd.nextInt(98999) + 1000);
		}
		return postcodes;
	}
}
