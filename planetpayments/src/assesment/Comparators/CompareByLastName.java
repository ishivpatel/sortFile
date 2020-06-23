package assesment.Comparators;

import java.util.Comparator;

import assesment.Record;

public class CompareByLastName  implements Comparator<Record> {
	
	public int compare(Record a, Record b) 
    { 
        return a.getLastName().compareTo(b.getLastName()); 
    }

}
