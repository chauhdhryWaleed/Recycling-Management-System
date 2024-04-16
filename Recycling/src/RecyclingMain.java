import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecyclingMain {

	private static ArrayList<RecyclingItem> items;
	private static ArrayList<RecyclingFacility> facilities;

	public static void main(String[] args) {
		items = new ArrayList<>();
		facilities = new ArrayList<>();
		try {
			readRecyclingItems("recycling.txt");
			readRecyclingFacilities("faculties.txt"); /*task 7.5 */
			// printAllRecyclingItems(); /*task 7.4 */
			sortRecyclingItems();
		} catch (IOException e) {
			System.err.println("Failed to read data into the program! Error follows.");
			e.printStackTrace();
		}
	}

	/**
	 * a method to print all the recycling items currently being held
	 */
	public static void printAllRecyclingItems() {

		for (RecyclingItem item : items) {
			System.out.println(item.toString());
		}
			
		
		
		//example output:
		/*
			PlasticRecyclingItem: weight=12.0, volume=42.0, cleanliness=MEDIUM,
			recycling_cost_unit=181.5, melting_point=343.0, food_safe=false
			PaperRecyclingItem: weight=1.0, volume=12.0, cleanliness=MEDIUM,
			recycling_cost_unit=57.0, printed=false, material_density=8.45
		 */
		//todo remember to use inheritance!!!

	}

	public static void sortRecyclingItems() {  //task 7.6
		
	
        for (RecyclingItem item : items) {
			System.out.println("Sent to facility: ");
            boolean processed = false;
			
		
            for (RecyclingFacility facility : facilities) {
                if (facility.checkCanProcess(item)) {
                    System.out.println(item);
                    System.out.println("Sent to facility: " + facility.getName());
                    processed = true;
                    break; // Once a facility is found, no need to check further facilities
                }
            }

            if (!processed) {
                // If no facility can process the item, print an appropriate message
                System.out.println(item);
                System.out.println("No facility available to process this item.");
            }
        }
		
    }
	
	/**
	 * Reads the specified file and parses its contents into various types of
	 * RecyclingItem, adding them to a global static ArrayList as it goes.
	 * 
	 * @param fileName The name of the file to be read.
	 * @throws IOException When an IO error occurs (See Scanner).
	 */
	private static void readRecyclingItems(String fileName) throws IOException {
		File inputFile = new File("../" + fileName);
		Scanner input = new Scanner(inputFile);
		// Tell the scanner that each line of the file is delimited using commas.
		input.useDelimiter(",|\\R");

		// While there are lines in the file
		while (input.hasNextLine()) {
			// Read the first item of the line, the typeOfItem (int):
			int typeOfItem = input.nextInt(); // 0 for paper, 1 for plastic

			// Then, read the second item of the line, the weight (double):
			double weight = input.nextDouble();

			// Then, the third item of the line, the volume (double):
			double volume = input.nextDouble();

			// ... Continue reading the components of the line ...
			
			Cleanliness cleanlinessLevel;

			// Convert integer value to enum value
			int cleanlinessValue = input.nextInt();
			if (cleanlinessValue == 0) {
				cleanlinessLevel = Cleanliness.SOILED;
			} else if (cleanlinessValue == 1) {
				cleanlinessLevel = Cleanliness.MEDIUM;
			} else if (cleanlinessValue == 2) {
				cleanlinessLevel = Cleanliness.CLEAN;
			} else {
				throw new IllegalArgumentException("Invalid cleanliness value: " + cleanlinessValue);
			}
		
			double rCPU = input.nextDouble();
           
			
			// Next steps:
			// - If typeOfItem is 0, then read the remaining data: isPrinted (boolean)
			// and density (int)
			//
			// - If typeOfItem is 1, then read the remaining data: meltingPoint (double) and
			// isFoodSafe (boolean)
			//
			// - When all above data is read, create the appropriate object, and add it to
			// the respective array list.
			//
            if (typeOfItem == 0) {
            boolean printed = Boolean.parseBoolean(input.next());
            double d = input.nextDouble();
			int density = (int) d;
            items.add(new PaperRecyclingItem(weight, volume, cleanlinessLevel, rCPU, printed, density));
        } else if (typeOfItem == 1) {
            double meltingPoint = input.nextDouble();
            boolean isFoodSafe = Boolean.parseBoolean(input.next());
            items.add(new PlasticRecyclingItem(weight, volume, cleanlinessLevel, rCPU, meltingPoint, isFoodSafe));
        }

		input.close();
		}
	
	}
    
	/**
	 * Reads the specified file and parses its contents into RecyclingFacility
	 * objects, adding them to a global static ArrayList as it goes.
	 * 
	 * @param fileName The name of thee file to be read.
	 * @throws IOException When an IO error occurs (See Scanner).
	 */
	private static void readRecyclingFacilities(String fileName) throws IOException {
		File inputFile = new File(fileName);
		Scanner input = new Scanner(inputFile);
		// Plot twist! Different code to read the file compared to readRecyclingItems
		// ;-)

		// While there are lines in the file
		while (input.hasNextLine()) {
			// Read a full line from the file, and split it by commas into parts:
			String[] parts = input.nextLine().split(",");
			// The first part is the maxWeight. Parse it as a double.
			String facilityName = parts[0];
			// The second part is the minCost. Parse it as a double.
			double maxWeight = Double.parseDouble(parts[1]);
			// The third item is wether or not the facility handles dirty items. Parse it as
			// a boolean.
			double minCost = Double.parseDouble(parts[2]);
			// ... Same logic as above ...
			boolean handlesDirty = Boolean.parseBoolean(parts[3]);
			boolean handlesFlammable = Boolean.parseBoolean(parts[4]);

			// Next steps:
			// - Create a RecyclingFactory object with the above information, and add it to
			// the respective array list.

			RecyclingFacility facility = new RecyclingFacility(facilityName, maxWeight, minCost, handlesDirty, handlesFlammable);

        // Add the facility to the ArrayList
            facilities.add(facility);


		}
		input.close();
	}

}
