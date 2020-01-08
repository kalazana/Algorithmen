package aufgabe7;

import java.util.ArrayList;

public class Search {

    private int counterFound = 0;
    private int counterNotFound = 0;
    private long expenseFound = 0;
    private long expenseNotFound = 0;

    /**
     * @param hospitals - List of hospitals
     * @param postcode  - postcode to be searched for
     * @return - index of postcode if found, else -1
     */

    //geht von links nach rechts und guckt ob ele. passt
    public int sequentialSearch(ArrayList<Hospital> hospitals, int postcode) {
        int expense = 0;
                     for (int i = 0; i < hospitals.size() - 1; i++) {
                if (postcode == hospitals.get(i).getPostcode()) {
                    expense++;
//                    System.out.println("Postcode found.");
//                    System.out.println(hospitals.get(i).getName() + "\t" + hospitals.get(i).getStreet() + "\t" + hospitals.get(i).getPostcode() + "\t" + hospitals.get(i).getLocation() + "\t" + hospitals.get(i).getNumberOfBeds());
//                    System.out.println("expense:  " + expense);
                    counterFound++;
                    expenseFound += expense;
                    return i;
                } else {
                    expense++;
                }
            }

//        System.out.println("Postcode not found.");
//        System.out.println("expense:  " + expense);
        counterNotFound++;
        expenseNotFound += expense;
        return -1;
    }

    /**
     * Returns index of x if it is present in arr[l..r], else returns -1.
     *
     * @param hospitals - List of hospitals
     * @param l         -
     * @param r         -
     * @param postcode  - postcode to be searched for
     * @return - index of postcode if found, else -1
     */
    //halbiert und guckt ob hoch oder runter bis es am element ankommt
    public int binarySearch(ArrayList<Hospital> hospitals, int l, int r, int postcode, int expense) {
        expense++;
        if (r > l) {
            int mid = l + (int)((double)((r - l)+1) / 2);

            if (hospitals.get(mid).getPostcode() == postcode) {
//                System.out.println("Expense binary search: " + expense);
                counterFound++;
                expenseFound += expense;
                return mid;
            }

            if (hospitals.get(mid).getPostcode() > postcode) {
                return binarySearch(hospitals, l, mid - 1, postcode, expense);
            }

            return binarySearch(hospitals, mid, r, postcode, expense);
        }
        counterNotFound++;
        expenseNotFound += expense;
        return -1;
    }

    /**
     * Returns index of postcode if it is present in arr[l..r], else returns -1.
     *
     * @param hospitals - List of hospitals
     * @param postcode  - postcode to be searched for
     * @return - index of postcode if found, else -1
     */
    public int interpolationSearch(ArrayList<Hospital> hospitals, int postcode, int expense) {
        // Find indexes of two corners
        int l = 0, r = (hospitals.size() - 1);

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (l <= r && postcode >= hospitals.get(l).getPostcode() && postcode <= hospitals.get(r).getPostcode()) {
            expense++;

            // Probing the position with keeping
            // uniform distribution in mind.
            int pos = l +((postcode -hospitals.get(l).getPostcode())*(r-l)/(hospitals.get(r).getPostcode()-hospitals.get(l).getPostcode()));

            // Condition of target found
            if (hospitals.get(pos).getPostcode() == postcode) {
//                System.out.println("Expense interpolation search: " + expense);
                counterFound++;
                expenseFound += expense;
                return pos;
            }

            // If postcode is larger, postcode is in upper part
            if (hospitals.get(pos).getPostcode() < postcode) {
                l = pos + 1;
            }
            // If postcode is smaller, postcode is in the lower part
            else {
                r = pos - 1;
            }
        }
        counterNotFound++;
        expenseNotFound += expense;
        return -1;
    }

    public long getExpenseFound() {
        return expenseFound;
    }

    public void setExpenseFound(long expenseFound) {
        this.expenseFound = expenseFound;
    }

    public long getExpenseNotFound() {
        return expenseNotFound;
    }

    public void setExpenseNotFound(long expenseNotFound) {
        this.expenseNotFound = expenseNotFound;
    }

    public int getCounterFound() {
        return counterFound;
    }

    public void setCounterFound(int counterFound) {
        this.counterFound = counterFound;
    }

    public int getCounterNotFound() {
        return counterNotFound;
    }

    public void setCounterNotFound(int counterNotFound) {
        this.counterNotFound = counterNotFound;
    }
}
