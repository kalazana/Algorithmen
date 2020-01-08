package aufgabe6_2;

	import java.util.ArrayList;

	public class Sort {
	    /**
	     * @param hospitals - List of hospitals
	     * @param sorting - term to be sort for
	     * @return - Sorted list
	     */
	    public ArrayList<Hospital> insertionSort(ArrayList<Hospital> hospitals, String sorting) {
	        ArrayList<Hospital> temporary_list = new ArrayList<>(hospitals);
	        ArrayList<Hospital> sorted_list = new ArrayList<>();
	        boolean insert;
	        int expense = 0;
	        switch (sorting) {


	            case "Postleitzahl":
	                sorted_list.add(temporary_list.get(0));
	                temporary_list.remove(0);
	                do {
	                    insert = false;
	                    for (int i = 0; sorted_list.size() > i; i++) {
	                        expense++;
	                        if (temporary_list.get(0).getPostcode() < sorted_list.get(i).getPostcode()) {
	                            sorted_list.add(i, temporary_list.get(0));
	                            insert = true;
	                            break;
	                        }
	                    }
	                    if (!insert) {
	                        sorted_list.add(temporary_list.get(0));
	                        temporary_list.remove(0);
	                    }
	                    if (temporary_list.size() == 0) {
	                        System.out.println("Einfügesortierung: " + expense);
	                        return sorted_list;
	                    }
	                } while (true);

	            case "Ort":
	                sorted_list.add(temporary_list.get(0));
	                temporary_list.remove(0);
	                do {
	                    insert = false;
	                    for (int i = 0; sorted_list.size() > i; i++) {
	                        expense++;
	                        int sort = temporary_list.get(0).getLocation().toLowerCase().compareTo(sorted_list.get(i).getLocation().toLowerCase());
	                        if (sort < 0) {
	                            sorted_list.add(i, temporary_list.get(0));
	                            temporary_list.remove(0);
	                            insert = true;
	                            break;
	                        }
	                    }
	                    if (!insert) {
	                        sorted_list.add(hospitals.get(0));
	                        temporary_list.remove(0);
	                    }
	                    if (temporary_list.size() == 0) {
	                        System.out.println("Einfügesortierung: " + expense);
	                        return sorted_list;
	                    }
	                } while (true);

	            case "Bettenanzahl":
	                sorted_list.add(temporary_list.get(0));
	                temporary_list.remove(0);
	                do {
	                    insert = false;
	                    for (int i = 0; sorted_list.size() > i; i++) {
	                        expense++;
	                        if (temporary_list.get(0).getNumberOfBeds() < sorted_list.get(i).getNumberOfBeds()) {
	                            sorted_list.add(i, temporary_list.get(0));
	                            insert = true;
	                            break;
	                        }
	                    }
	                    if (!insert) {
	                        sorted_list.add(temporary_list.get(0));
	                    }
	                    temporary_list.remove(0);
	                    if (temporary_list.size() == 0) {
	                        System.out.println("Einfügesortierung: " + expense);
	                        return sorted_list;
	                    }
	                } while (true);
	        }
	        return null;
	    }

	    /**
	     *
	     * @param hospitals - List of hospitals
	     * @param sorting - term to be sort for
	     * @return - Sorted list
	     */
	    public ArrayList<Hospital> selectionSort(ArrayList<Hospital> hospitals, String sorting) {
	        ArrayList<Hospital> sorted_list = new ArrayList<>();
	        ArrayList<Hospital> temporary_list = new ArrayList<>(hospitals);
	        boolean sorted = true;
	        int expense = 0;
	        switch (sorting) {
	            // sorts by name
	            case "Name":
	                while (sorted) {
	                    int temp = 0;
	                    for (int i = 1; temporary_list.size() > i; i++) {
	                        expense++;
	                        int sort = temporary_list.get(temp).getName().toLowerCase().compareTo(temporary_list.get(i).getName().toLowerCase());
	                        if (sort > 0) {
	                            temp = i;
	                        }
	                    }
	                    sorted_list.add(hospitals.get(temp));
	                    temporary_list.remove(temp);
	                    if (temporary_list.size() == 0) {
	                        sorted = false;
	                    }
	                }
	                break;

	            // sorts by street
	            case "Straße":
	                while (sorted) {
	                    int temp = 0;
	                    for (int i = 1; temporary_list.size() > i; i++) {
	                        expense++;
	                        int sort = temporary_list.get(temp).getStreet().toLowerCase().compareTo(temporary_list.get(i).getStreet().toLowerCase());
	                        if (sort > 0) {
	                            temp = i;
	                        }
	                    }
	                    sorted_list.add(temporary_list.get(temp));
	                    temporary_list.remove(temp);
	                    if (temporary_list.size() == 0) {
	                        sorted = false;
	                    }
	                }
	                break;

	            // sorts by postcode
	            case "Postleitzahl":
	                while (sorted) {
	                    int temp = 0;

	                    for (int i = 1; temporary_list.size() > i; i++) {
	                        expense++;
	                        if (temporary_list.get(i).getPostcode() < temporary_list.get(temp).getPostcode()) {
	                            temp = i;
	                        }
	                    }
	                    sorted_list.add(temporary_list.get(temp));
	                    temporary_list.remove(temp);
	                    if (temporary_list.size() == 0) {
	                        sorted = false;
	                    }
	                }
	                break;

	            // sorts by location
	            case "Ort":
	                while (sorted) {
	                    int temp = 0;
	                    for (int i = 1; temporary_list.size() > i; i++) {
	                        expense++;
	                        int sort = temporary_list.get(temp).getLocation().toLowerCase().compareTo(temporary_list.get(i).getLocation().toLowerCase());
	                        if (sort > 0) {
	                            temp = i;
	                        }
	                    }
	                    sorted_list.add(temporary_list.get(temp));
	                    temporary_list.remove(temp);
	                    if (temporary_list.size() == 0) {
	                        sorted = false;
	                    }
	                }
	                break;

	            // sorts by number of beds
	            case "Bettenanzahl":
//	                int smallestPossible = 0;
	                while (sorted) {
	                    int temp = 0;
	                    for (int i = 1; temporary_list.size() > i; i++) {
	                        expense++;
	                        if (temporary_list.get(i).getNumberOfBeds() < temporary_list.get(temp).getNumberOfBeds()) {
	                            temp = i;
//	                            if(temporary_list.get(temp).getNumberOfBeds() == smallestPossible){
//	                                break;
//	                            }
	                        }
	                    }
	                    sorted_list.add(temporary_list.get(temp));
//	                    smallestPossible = temporary_list.get(temp).getNumberOfBeds();
	                    temporary_list.remove(temp);
	                    if (temporary_list.size() == 0)
	                        sorted = false;
	                }
	                break;
	        }
	        System.out.println("Auswahlsortierung: " + expense);
	        return sorted_list;
	    }
	}