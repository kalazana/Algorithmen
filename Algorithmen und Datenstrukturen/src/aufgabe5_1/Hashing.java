package aufgabe5_1;


public class Hashing {

    /**
     * calculates a hash value for a first name.
     *
     * @param firstName - first name of a person
     * @return - hash value
     * ascii werte werden zusammengerechnet und mod 32, damit man den index vom array erhält
     */
    public static int hashfunction(final String firstName) {
        int key = 0;
        for (int i = 0; i < firstName.length(); i++) {
            key += firstName.charAt(i);
        }
        return key % 32;
    }
}
