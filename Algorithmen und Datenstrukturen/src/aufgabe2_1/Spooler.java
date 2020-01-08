package aufgabe2_1;

public class Spooler {

    private Byte[] spooler = new Byte[20];
    private int counter = 0;
    private boolean stopOutput = false;
    int z = 0;

    public void addByte(Byte input) {
        if (input == 11) {
            stopOutput = false;
            for (int i = 10; i < spooler.length; i++) {
                if (spooler[i] != null) {
                    System.out.println("Output: " + spooler[i]);
                    spooler[i] = null;
                }
            }
            if (spooler[10] != null) {
                counter = 11;
            }
        } else if (input == 13) {
            stopOutput = true;
        } else if (input == 0) {
            for (int i = 0; i < spooler.length; i++) {
                if (spooler[i] != null) {
                    System.out.println("Output: " + spooler[i]);
                    spooler[i] = null;
                }
            }
            System.exit(0);
        } else if (counter >= 10 && !stopOutput && counter<20) {
            System.out.println("Output: " + spooler[counter-10+z]);
            z++;
        } else if (counter == 20) {
            System.out.println("Spooler ist voll.");
        } else {
            spooler[counter] = input;
            counter++;
        }
    }
}

