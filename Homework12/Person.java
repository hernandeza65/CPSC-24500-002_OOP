package hw11;

import java.io.Serializable;

public class Person implements Serializable
{
	String name;
    String phoneNumber;
    String dateOfBirth;
    String email;
    
    
    public Person() {
		super();
	}

	public Person(String name, String phoneNumber, String dateOfBirth, String email) 
    {
        this.name = name; 
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        
    }

	@Override
	public String toString() {
		return "Person [Name = " + name + ", Phone Number = " + phoneNumber + ", Date Of Birth = " + dateOfBirth + ", Email Address = "
				+ email + "]" + "\n";
	}
    
    
}
