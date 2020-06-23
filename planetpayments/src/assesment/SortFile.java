package assesment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import assesment.Comparators.*;

public class SortFile {
	static ArrayList<Record> allRecordObjects = new ArrayList<Record>();
	static String fileType = "";
	
	public static void main(String[] args) {
		
		//Read file and detect filetype automatically, sort the file by sort Type
		/*
		 * arg[0] - file path to read
		 * arg[1] - file Sort Type
		 * arg[2] - output file path
		 * 
		 * 1 - Sort By FirstName
		 * 2 - Sort by Last Name
		 * 3- Sort By Start Date
		 * 
		 */
		ReadFile(args[0], args[1]);
		System.out.println("Writing to file");
		
		
		//Write the File to a file named output.txt
		/*
		 * will convert the list into specified format by overriding toString method
		 * 
		 */
		writeToFile(allRecordObjects, args[2]);

	}
	
	
	//Read File using Buffered Reader to read single line
	//Converted line to Array List which i later convert into object records
     private static void ReadFile(String fileName, String sortByType ) {
    		
 		try {

 			FileReader type1 = new FileReader(fileName);
 			BufferedReader br = new BufferedReader(type1);

 			String thisLine = "";
 			// Read File Line By Line
 			ArrayList<String> records = new ArrayList<String>();
 			while ((thisLine = br.readLine()) != null) {

 				records.add(thisLine);
 				// System.out.println(thisLine);
 			}

 			br.close();
 			type1.close();

 			// Sort by param
 			 sortFileType(records, sortByType);

 		} catch (Exception e) {
 			// Catch exception if any
 			System.err.println("Error: " + e.getMessage());
 		}
		
	}
	

	private static void sortFileType(ArrayList<String> records, String sortBy) {
		// TODO Auto-generated method stub
		
		//determine file format type. 1 represents file type 1 
		fileType = records.remove(0);
		
		if (fileType.equalsIgnoreCase("1")) {
			allRecordObjects =  sortRecordsFirstFormat(records);
		}else {
			allRecordObjects =  sortRecordsSecondFormat(",", records);
		}
		
		
		//sort Objects using COmparators
		if(sortBy.equalsIgnoreCase("1")) {
			Collections.sort(allRecordObjects, new CompareByFirstName());			
		}else if(sortBy.equalsIgnoreCase("2")) {
			Collections.sort(allRecordObjects, new CompareByLastName());
		}else {
			Collections.sort(allRecordObjects, new CompareByStartDate());
		}
		
	}
	
	

	private static ArrayList<Record> sortRecordsSecondFormat(String string, ArrayList<String> records) {
		ArrayList<Record> list = new ArrayList<Record>();

		//all records will be seperated using , so split a line into array and convert them to objects 
		for (String line : records) {
			String[] objects = line.split(",");
			try {
				list.add(convertObject(objects));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private static ArrayList<Record> sortRecordsFirstFormat(ArrayList<String> records) {
		ArrayList<Record> list = new ArrayList<Record>();

		//all records will be of specific length so split line into length and convert to object
		for (String line : records) {
			try {
				list.add(convertObject(line));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return list;

	}
	
	
	private static Record convertObject(String[] objects) throws ParseException {
		// convert strings to object and assign default value if missing
		String firstName = objects[0];
		String lastName = objects[1];
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		Date origDate = originalFormat.parse(objects[2]);
		
		String pattern = "MMMM DD, YYYY";
		SimpleDateFormat newDateFormat = new SimpleDateFormat(pattern);
		String startDate = newDateFormat.format(origDate);
		String address1 = objects[3];
		String address2 = objects[4];
		String city = objects[5];
		String state = objects[6];
		String country = objects[7];
		String zip = objects[8];
		
		if(state.equals("")) {
			state = "CA";
		}
		if(country.equals("")) {
			country = "USA";
		}
		
		return new Record(firstName, lastName, startDate, address1, address2, city, state, country, zip);
		
	}

	private static Record convertObject(String line) throws ParseException {
		// convert strings to object and assign default value if missing
		
		String firstName = line.substring(0,9);
		String lastName = line.substring(10, 26);
		
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		Date origDate = originalFormat.parse(line.substring(27, 34));
		
		String pattern = "MMMM DD, YYYY";
		SimpleDateFormat newDateFormat = new SimpleDateFormat(pattern);
		String startDate = newDateFormat.format(origDate);

		String address1 = line.substring(35, 44);
		String address2 = line.substring(45, 54);
		String city = line.substring(55, 64);
		String state = line.substring(65, 66);
		String country = line.substring(67, 69);
		String zip = line.substring(70, 79);
		
		if(state.trim().equals("")) {
			state = "CA";
		}
		if(country.trim().equals("")) {
			country = "USA";
		}
		
		return new Record(firstName, lastName, startDate, address1, address2, city, state, country, zip);
			 
		
	}
	

	private static void writeToFile( ArrayList<Record> list, String outputPath) {
		
		FileWriter writer;
		try {
			writer = new FileWriter(outputPath);
			int index = 1;
			for(Record rec: list) {
				writer.write(index + System.lineSeparator() + rec.toString() + System.lineSeparator());
				index++;
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
	}

}
