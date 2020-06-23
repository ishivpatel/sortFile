package assesment.Comparators;

import java.util.Comparator;

import assesment.Record;

public class CompareByFirstName implements Comparator<Record> {
	
	public int compare(Record a, Record b) 
    { 
        return a.getFirstName().compareTo(b.getFirstName()); 
    }

}
