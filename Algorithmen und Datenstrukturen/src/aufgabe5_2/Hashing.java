package aufgabe5_2;

public class Hashing {

    /**
     * calculates a hash value for a first name.
     *
     * @param firstName - first name of a person
     * @return - hash value
     */
    public static int hashfunction(final String firstName) {
        int key = 0;
        for (int i = 0; i < firstName.length(); i++) {
            key += firstName.charAt(i);
        }
        return key % 32;
    }
}
