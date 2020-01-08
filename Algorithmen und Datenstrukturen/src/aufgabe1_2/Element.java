package aufgabe1_2;


import java.io.Serializable;

public class Element implements Serializable {
    private String firstName;
    private String lastName;
    private String birthDay;
    private int insuranceNumber;
    private int previous = -1;
    private int next = -1;
    private boolean free = true;

    public Element() {
    }

    /**
     * Constructor to set values.
     *
     * @param firstName       - first name
     * @param lastName        - last name
     * @param birthDay        - birthday
     * @param insuranceNumber - insurance number
     * @param previous        - (index of the) previous element
     * @param next            - (index of the) next element
     */
    public void setElement(final String firstName, final String lastName, final String birthDay, final int insuranceNumber, final int previous, final int next) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDay(birthDay);
        setInsuranceNumber(insuranceNumber);
        setPrevious(previous);
        setNext(next);
        setFree(false);
    }

    /**
     * Removes/deletes an element.
     */
    public void delete() {
        setFirstName(null);
        setLastName(null);
        setBirthDay(null);
        setInsuranceNumber(0);
        setPrevious(-1);
        setNext(-1);
        setFree(true);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final String birthDay) {
        this.birthDay = birthDay;
    }

    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(final int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(final int previous) {
        this.previous = previous;
    }

    public int getNext() {
        return next;
    }

    public void setNext(final int next) {
        this.next = next;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(final boolean free) {
        this.free = free;
    }

    /**
     * Creates a representation of the element.
     *
     * @return - String containing representation of the element.
     */
    public String toString() {
        return firstName + " "
                + lastName + " "
                + birthDay + " "
                + insuranceNumber + "\n";
    }
}