import java.util.Objects;

public class TableData {
    private String lastName;
    private String firstName;
    private String email;
    private String due;
    private String website;

    public TableData() {
    	
    }
    public TableData(String lastName, String firstName, String email, String due, String website) {
	    this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.due = due;
		this.website = website;
	}

	public String getLastName() {
        return lastName;
    }

    public TableData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public TableData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TableData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDue() {
        return due;
    }

    public TableData withDue(String due) {
        this.due = due;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public TableData withWebsite(String website) {
        this.website = website;
        return this;
    }

	@Override
	public int hashCode() {
		return Objects.hash(due, email, firstName, lastName, website);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableData other = (TableData) obj;
		return Objects.equals(due, other.due) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(website, other.website);
	}

	@Override
	public String toString() {
		return "TableData [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", due=" + due
				+ ", website=" + website + "]";
	}
    
    
    
    
}