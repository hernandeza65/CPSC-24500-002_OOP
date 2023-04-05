// This program uses Serialization to add people and their information to an array list
// Author: Alex Hernandez

package hw11;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class hw11 
{
	public static void main(String[] args) 
    {
               
		// Scanner that takes in user input and ArrayList that saves the information 
        Scanner kb = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        
        // Asks the user to select from the menu
        System.out.println("Please select one from the following");
        System.out.println("""
                           1. Add information into a file
                           2. Retrieve information from a file and display them
                           3. Delete information
                           4. Update information
                           5. Exit""");
        int choice = kb.nextInt(); 
        
        // While loop that keeps going until the user enters 0 or anything equal to or over 5
        while (choice < 5 && choice > 0)
        {
        	// Switch statement that determines what happens when the user selects a number on the menu 
            switch (choice) 
            {
            	// First case allows the user to enter new information 
            	// and writes this information to a file
                case 1:
                	kb.nextLine();
                    System.out.println("Please enter your name: ");
                    String name = kb.nextLine();
                    
                    
                    System.out.println("Please enter a phone number: ");
                    String phoneNum = kb.nextLine();
                    
                   
                    System.out.println("Please enter the date of birth: ");
                    String DOB = kb.nextLine();
                    
                    
                    System.out.println("Please enter the email address: ");
                    String email = kb.nextLine();
                    
                    
                    Person newPerson = new Person(name, phoneNum, DOB, email);
                    people.add(newPerson);
                    
                    
                    try 
                    {
                        writeToFile(people);
                    } 
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    
                    
                    break;
                    
                // Second case that displays the information from the file 
                case 2:
                	try 
                	{
                		
                        readFile();
                    } 
                	catch (IOException | ClassNotFoundException e)
                	{
                        System.out.println(e.getMessage());
                    }
                    break;
                
                // Allows the user to remove information from the file 
                case 3:
                	System.out.println("Which person did you want to remove?");
                	try 
                	{
                        readFile();
                    } 
                	catch (IOException | ClassNotFoundException e)
                	{
                        System.out.println(e.getMessage());
                    }
                	
                	int deleteChoice = kb.nextInt();
                	people.remove(deleteChoice - 1);
                	
                	try 
                    {
                        writeToFile(people);
                    } 
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                
                    break;
                    
                // Allows the user to update information in the file
                case 4: 
                	System.out.println("Which person's information did you want to update?");
                	try 
                	{
                        readFile();
                    } 
                	catch (IOException | ClassNotFoundException e)
                	{
                        System.out.println(e.getMessage());
                    }
                	
                	int updateChoice = kb.nextInt();
                	
                	kb.nextLine();
                	System.out.println("Please enter the updated name: ");
                    String newName = kb.nextLine();
                    
                    
                    System.out.println("Please enter the updated phone number: ");
                    String newPhoneNum = kb.nextLine();
                    
                   
                    System.out.println("Please enter the updated date of birth: ");
                    String newDOB = kb.nextLine();
                    
                    
                    System.out.println("Please enter the updated email address: ");
                    String newEmail = kb.nextLine();
                    
                    people.set(updateChoice - 1, new Person(newName, newPhoneNum, newDOB, newEmail));
                    try 
                    {
                        writeToFile(people);
                    } 
                    catch (IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                	
                    break;
                default:
                    break;
            }
            System.out.println("""
                           1. Add information into a file
                           2. Retrieve information from a file and display them
                           3. Delete information
                           4. Update information
                           5. Exit""");
            choice = kb.nextInt(); 
            }
        	System.out.println("Thank you for using this information application!");
        }
        
	// Allows the file to be converted to a binary file as well as writing to it 
	public static void writeToFile(ArrayList<Person> people) throws FileNotFoundException, IOException
    {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin"));
        
        objectOutputStream.writeObject(people);
    }
    
	// Reads the file
    public static void readFile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
        
        ArrayList<Person> name = (ArrayList<Person>) objectInputStream.readObject();
        
        for (int x = 0; x < name.size(); x++)
        {
        	System.out.print(x+1 + ". ");
        	System.out.println(name.get(x));
        }
    	
        
        
    }
}
