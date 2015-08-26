import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Statistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Double> gpa = new ArrayList<Double>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<String> major = new ArrayList<String>();
		ArrayList<String> state = new ArrayList<String>();
		String choice = "y";
		double totalGpa = 0, overallGpa = 0, mGpa = 0, fGpa = 0, aveMGpa = 0, aveFGpa = 0;
		int male = 0, female = 0;
		String majorInput;
		
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Name: ");
			name.add(keyboard.next());
			System.out.print("Grade: ");
			switch (keyboard.next()) {
				case "A":
					gpa.add(4.0);
					break;
				case "B":
					gpa.add(3.5);
					break;
				case "C": 
					gpa.add(2.5);
					break;
				case "D": 
					gpa.add(1.5);
					break;
				case "F": 
					gpa.add(0.5);
					break;
				default: 
					System.out.println("Invalid GPA.");
					break;
			}
			System.out.print("Gender (M/F): ");
			gender.add(keyboard.next());
			System.out.print("Major: ");
			majorInput = keyboard.next();
			major.add(majorInput);
			
			System.out.print("State (No abbreviation): ");
			state.add(keyboard.next());
			System.out.println();
			System.out.print("Continue? (y/n)");
			choice = keyboard.next();
			System.out.println();
		}
		
		for (int i = 0; i < gpa.size(); i++) {
			totalGpa += gpa.get(i);
			if (gender.get(i).equalsIgnoreCase("M")) {
				mGpa += gpa.get(i);
				male++;
			} else {
				fGpa += gpa.get(i);
				female++;
			}
		}
		
		overallGpa = totalGpa / gpa.size();
		aveMGpa = mGpa / male;
		aveFGpa = fGpa / female;
		
		System.out.println("Overall average: " + overallGpa);
		System.out.println("Average for gender: ");
		System.out.println("{M: " + aveMGpa + ", F: " + aveFGpa + "}");
		System.out.println("Average for major: ");
		mapping(major, gpa);
		System.out.println("Average for state: ");
		mapping(state, gpa);
	}

	public static void mapping(ArrayList<String> classification, ArrayList<Double> classGpa) {
        double totalClassGpa = 0.0;
		Map<String, Double> map= new HashMap<String, Double>();
        map.put(classification.get(0), classGpa.get(0));
        
        for (int i = 1; i < classification.size(); i++) {	//Read all the data in class
        	for (String s: map.keySet()) {	//Run through the map
        		if (!map.containsKey(classification.get(i))) {	//Create a new <key, value> if not found in the map
        			map.put(classification.get(i), classGpa.get(i));
        			continue;
        		}
        		if (classification.get(i).equalsIgnoreCase(s)) { // class == key
        			totalClassGpa = map.get(s) + classGpa.get(i);  // Add current GPA to average
        			map.put(s, totalClassGpa / Collections.frequency(classification,s));  // Put average GPA into map
        			break;
        		}
        	}
        }
        System.out.println(map);
    }
	
}
