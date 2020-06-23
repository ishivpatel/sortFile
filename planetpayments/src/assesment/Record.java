package assesment;

//Convert Line into Object
public class Record {
	
	String firstName;
	String lastName;
	String startDate;
	String address1;
	String address2;
	String city;
	String state;
	String country;
	String zip;
	
	public Record() {
		
	}
	
	public Record(String firstName, String lastName, String startDate, String address1, String address2, String city,
			String state, String country, String zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	
	@Override
	//Override to print to file in specified format
	public String toString() {
		
		return String.format(firstName + " " + lastName + ", (" + startDate + ")" + "%n" 
		                     + address1 + ", " + address2 + "," + "%n" 
				             +city + ", " + state + "," + "%n"
		                     + country + ", " + zip);
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
