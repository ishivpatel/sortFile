package assesment.Comparators;

import java.util.Comparator;

import assesment.Record;

public class CompareByStartDate implements Comparator<Record>  {
	
	public int compare(Record a, Record b) 
    { 
        return a.getStartDate().compareTo(b.getStartDate()); 
    }

}
