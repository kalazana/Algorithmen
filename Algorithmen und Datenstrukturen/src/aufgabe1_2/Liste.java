package aufgabe1_2;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Liste implements Serializable {



    /**
     * Contains (list) entries.
     */
    private Element[] elements;
    /**
     * length of the array/list.
     */
    private int length;

    /**
     * Constructor to create and initialize a new list.
     *
     * @param size - size of the list
     */
    public Liste(final int size) {
        length = size;
        elements = new Element[size];
        for (int i = 0; i < size; i++) {
            elements[i] = new Element();
        }
    }

    /**
     * Adds a new entry to the list.
     *
     * @param firstName       - first name
     * @param lastName        - last name
     * @param birthday        - birthday
     * @param insuranceNumber - insurance number
     * @return - true if entry successfully inserted, otherwise false
     */
    public boolean insert(final String firstName, final String lastName, final String birthday, final int insuranceNumber) {
        int lastElement = lastElement();
        for (int i = 0; i < length; i++) {
            if (elements[i].isFree()) {
                elements[i].setElement(firstName, lastName, birthday, insuranceNumber, lastElement, -1);
                if (lastElement >= 0) {
                    elements[lastElement].setNext(i);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Search and returns the index of the first list entry.
     *
     * @return - index of the first list entry
     */
    private int firstElement() {
        for (int i = 0; i < length; i++) {
            if (!elements[i].isFree() && elements[i].getPrevious() < 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Search and returns the index of the last list entry.
     *
     * @return - index of the last list entry
     */
    private int lastElement() {
        int tempIndex = firstElement();
        while (tempIndex >= 0) {
            if (!elements[tempIndex].isFree() && elements[tempIndex].getNext() < 0) {
                return tempIndex;
            }
            tempIndex = elements[tempIndex].getNext();
        }
        return -1;
    }

    /**
     * Deletes an entry from the list with the specified insurance number.
     *
     * @param insuranceNumber - Insurance number that identifies the entry.
     * @return - true if entry deleted, otherwise false
     */
    public boolean delete(final int insuranceNumber) {
        int tempIndex = firstElement();
        while (tempIndex >= 0) {
            if (elements[tempIndex].getInsuranceNumber() == insuranceNumber) {
                if (tempIndex == 0) {
                    elements[elements[tempIndex].getNext()].setPrevious(-1);
                } else if (elements[tempIndex].getNext() < 0) {
                    elements[elements[tempIndex].getPrevious()].setNext(-1);
                } else {
                    elements[elements[tempIndex].getPrevious()].setNext(elements[tempIndex].getNext());
                    elements[elements[tempIndex].getNext()].setPrevious(elements[tempIndex].getPrevious());
                }
                elements[tempIndex].delete();
                return true;
            }
            tempIndex = elements[tempIndex].getNext();
        }
        return false;
    }

    /**
     * Searches the list for an entry with the specified insurance number.
     *
     * @param insuranceNumber - Insurance number that identifies the entry.
     * @return - Element of the list, if found, otherwise null.
     */
    public Element find(final int insuranceNumber) {
        int tempIndex = firstElement();
        while (tempIndex >= 0) {
            if (elements[tempIndex].getInsuranceNumber() == insuranceNumber) {
                return elements[tempIndex];
            }
            tempIndex = elements[tempIndex].getNext();
        }
        return null;
    }

    /**
     * Determines the number of list entries.
     *
     * @return - number of entries
     */
    public int size() {
        int out = 0;
        int tempIndex = firstElement();
        while (tempIndex >= 0) {
            out++;
            tempIndex = elements[tempIndex].getNext();
        }
        return out;
    }

    /**
     * Finds and prints a list entry to the console.
     *
     * @param insuranceNumber - Insurance number that identifies the entry.
     */
    public void print(final int insuranceNumber) {
        Element element = find(insuranceNumber);
        if (element != null) {
            System.out.println(element.toString());
        } else {
            System.out.println("No entry found.");
        }
    }

    /**
     * Prints the list to the console.
     */
    public void printList() {
        int tempIndex = firstElement();
        while (tempIndex >= 0) {
            System.out.println(elements[tempIndex].toString());
            tempIndex = elements[tempIndex].getNext();
        }
    }

    /**
     * Saves a List object to a file.
     *
     * @param filename - Name of the file to load.
     * @throws IOException - Signals that an I/O exception of some sort has occurred.
     */
    public void save(final String filename) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename + ".ser"));
        out.writeObject(this);
        out.close();
    }

    /**
     * Loads a List object from a file.
     *
     * @param filename - Name of the file to be saved.
     * @return - object of the class List containing the loaded content.
     * @throws IOException            - Signals that an I/O exception of some sort has occurred.
     * @throws ClassNotFoundException - Thrown when an application tries to load in a class but no definition for the class with the specified name could be found.
     */
    public Liste load(final String filename) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new FileInputStream(filename + ".ser"));
        Liste out = (Liste) in.readObject();
        in.close();
        return out;
    }
}
