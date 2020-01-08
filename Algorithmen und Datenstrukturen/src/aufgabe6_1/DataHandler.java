package aufgabe6_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataHandler {
    private File filename = new File("data/KHR95_red.txt");
    private int counter = 0;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

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
                                    hospital.setPostcode(Integer.parseInt(fileContent.substring(index, fileContent.indexOf("\t", index))));
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
                bufferedWriter.write(hospital.getName() + "\t" + hospital.getStreet() + "\t" + hospital.getPostcode() + "\t" + hospital.getLocation() + "\t" + hospital.getNumberOfBeds() + "\n");
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

            System.out.println("Es wurden " + counter + " Einträge gefunden.");
            System.out.print("\nWelcher Eintrag soll ausgeben werden: ");
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
     * Writes one record of the hospital list on the console.
     */
    public void toSting() {
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String readLine;
            if (filename.exists()) {
                while ((readLine = bufferedReader.readLine()) != null) {
                    System.out.println(readLine);
                }
            }
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
}
