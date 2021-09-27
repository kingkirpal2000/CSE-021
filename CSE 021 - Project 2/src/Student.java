
public class Student {

	private String name;
	private char gender; 
	private Date date; 
	private Preference pref;
	private Boolean matched;


	public Student(String n, char g, Date d, Preference p, Boolean m) {
		name = n;
		gender = g;
		date = d;
		pref = p;
		matched = m;
	}

	public String getName() {
		return name;
	}
	public char getGender() {
		return gender;
	}
	public Date getDate() {
		return date;
	}
	public Preference getPreference() {
		return pref;
	}
	public Boolean getMatched() {
		return matched;
	}

	public String didMatch(Student studentMatched) {
		matched = true;
		studentMatched.matched = true; //is this accessing the correct matched?
		return studentMatched.getName();
	}

	public int compare(Student st) {

		int compatibility = 0;

		if( gender != st.gender ) {

			return compatibility;
		}else {
			compatibility = (int)((40 - pref.compare(st.pref)) + (60 - date.compare(st.date)));

			return compatibility;
		}

	} 





}
