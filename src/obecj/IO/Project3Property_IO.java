package obecj.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project3Property_IO {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Path to Property file to read
				String inputFile="./Properties.txt";
				
				//Path to Property file to write
				String outFile="./PropertyOut.txt";
				
				//Initializing Property array of object
				//Property proArray[] = new Property[13]; 
				ArrayList<Property> proArray = new ArrayList<>();
				
				//Read Property.txt file
				readFileInClassObject(inputFile);
				
				//read Property.txt and populate Property object
				readFileInClassObject(proArray,inputFile);
				
				//Menu board for users to update delete and addProperty
				upDdateProperty(proArray);
				
				//write to the file and console output
				printDataFromArray(proArray,outFile);
				
			

			}
			
			//Reading Property.txt file and printing it on the console as it is
			public static void readFileInClassObject(String inf) throws FileNotFoundException{
				System.out.println("\n\nOutput of file using the scanner object");
				File inputFile = new File(inf);
				
				Scanner sc = new Scanner(inputFile);
				
				while(sc.hasNextLine()){
					String line = sc.nextLine();
					System.out.println(line);
					
				}
				sc.close();
				System.out.println();
			}
			
			
			//This method read data from files and set the Property object variable for each object of the array
			public static void readFileInClassObject(ArrayList<Property> proArray, String inf)throws FileNotFoundException{
				
				File inputFile = new File(inf);
				//PrintWriter output = new PrintWriter(of);
				Scanner sc = new Scanner(inputFile);
				String line = sc.nextLine();
				//output.println(line);
				int count = 0;
				String tempNum;
				//Looping through the file by reading each line and populating array of Property
				while(sc.hasNextLine()){
					line = sc.nextLine();
					
					//Holding each line to String array which is split by a comma
					String[] words = line.trim().split("\t");
					int id = Integer.parseInt(words[0]);
					String address = words[1];
					
				     tempNum = words[2].replace("$", "");
				     double purchasePrice = Integer.parseInt(tempNum.replaceAll(",", ""));
					
					 tempNum = words[3].replace("$", "");
					double rehabCost = Integer.parseInt(tempNum.replaceAll(",", ""));
					
					 
					 tempNum = words[4].replace("$", "");
					 double priceSold = Integer.parseInt(tempNum.replaceAll(",", ""));
					 
					 proArray.add(new Property(id,address,purchasePrice,rehabCost, priceSold));
					
					count++;
				}
				sc.close();
				
			}
			
			//Provide a menu board for user to update, delete and add property
			public static void upDdateProperty(ArrayList<Property> proArray) throws NoSuchElementException{
				//Scanner inputChoice = new Scanner(System.in);
				int choice;
				do{
					Scanner inputChoice = new Scanner(System.in);
				//Giving user a choice
				System.out.println("1.Delete a property");
				System.out.println("2.Add a property");
				System.out.println("3. Update a property");
				System.out.println("4. Enter 4 to exit");
				System.out.print("Enter 1, 2 , 3 0r 4 : ");
				
				choice= inputChoice.nextInt();
			
				System.out.println();
				
				//Switch statement to implement method as the choice
				switch(choice){
				case 1:
					//call deleteProperty method to delete a property
					System.out.println("You choose to delete a property");
					deleteProperty(proArray,inputChoice);
					
					break;
				case 2:
					//call addProperty  to a property to the array
					System.out.println("You choose to add a propery");
					addProperty(proArray,inputChoice);
					break;
				case 3:
					//end the loop
					System.out.println("You choose to update a property");
					updateProperty(proArray);
					break;
				case 4:
					//end the loop
					System.out.println("Enter 4 to exit");
					break;
				default:
						System.out.println("Wrong entry! You entered " + choice);
				
				}
				}while (choice!=4);
				
			}

			//This method implement to update a property
			private static void updateProperty(ArrayList<Property> proArray) {
				// TODO Auto-generated method stub

				Scanner input = new Scanner(System.in);
				Scanner inputAddress = new Scanner(System.in);
				System.out.println("Ary trying to update a propery, if yes go ahead");
				
				System.out.print("\nEnter property id: ");
				int propertyID = input.nextInt();
				
				
				
				for(int i=0;i<proArray.size();i++){
					if(proArray.get(i).getID()==propertyID){
						System.out.print("\nEnter Updated Address: ");
						String updatedAddress = inputAddress.nextLine();
						proArray.get(i).setAddress(updatedAddress);
					}
				}
				
				
			}

			//This method implement to add a property from user input. Asking user for 
			private static void addProperty(ArrayList<Property> proArray, Scanner inputPrice) {
				// TODO Auto-generated method stub
				
				Scanner inputProperety = new Scanner(System.in);
				Scanner input = new Scanner(System.in);
				String newAdderss="";
				System.out.println("Ary trying to add a propery, if yes go ahead");
				
				System.out.print("Enter address: ");
				if(inputProperety.hasNextLine())
					 newAdderss = inputProperety.nextLine();
				
				System.out.print("\nEnter Purchase price: ");
				double newPurchasePrice = inputProperety.nextDouble();
				
				System.out.print("\nEnter Rehab Price: ");
				double newRehabPrice = inputProperety.nextDouble();
				
				System.out.print("\n Enter Price Sold: ");
				double newPriceSold = inputProperety.nextDouble();
				proArray.add(new Property(proArray.size()+1,newAdderss,newPurchasePrice,newRehabPrice,newPriceSold));
				
				System.out.println("\nNew Property added is: \naddress: "+newAdderss+" Purchase Price: "+newPurchasePrice+" Rehab Price: "+newRehabPrice
						            +" Price Sold: "+newPriceSold+"\n");
			
				
			}

			//This method implement to delete a property by ID. 
			//Program will asks the user for a property ID.using the ID, remove the item from the array
			private static void deleteProperty(ArrayList<Property> proArray, Scanner inputId) {
				// TODO Auto-generated method stub
				//Scanner inputId = new Scanner(System.in);
				int idNumber = inputId.nextInt();
				for(int i = 0; i<proArray.size();i++){
					if(proArray.get(i).getID() == idNumber){
						proArray.set(i, new Property(0,"",0,0,0));
					}
				}
				//inputId.close();
				
			}

			//Writing data to Propertyout.txt file from the array of Property object and printing it to console
			public static void printDataFromArray(ArrayList<Property> proArray,String of) throws FileNotFoundException{
				
				//Initializing Writer class with out file path
				PrintWriter output = new PrintWriter(of);
				
				//Printing header to Propertyout.txt and console
				System.out.println("This is what is being written on PropertyOut.txt file with final grade included\n");
				System.out.format("%-15s%-15s%-10s%4s%6s%8s%9s%11s\n","First Name", "Last Name","SSN","Test1","Test2","Test3","Test4","FinalGrade");
				output.format("%-15s%-15s%-10s%4s%6s%8s%9s%11s\n","First Name", "Last Name","SSN","Test1","Test2","Test3","Test4","FinalGrade");
				output.println();
				System.out.println(proArray.size());
				//Looping through each object and writing and printing each variable of the object to Propertyout.txt and console
				for(int i = 0; i<proArray.size(); i++)
				{
					output.print(proArray.get(i).getID()+"\t"+proArray.get(i).getAddress()+"\t"+proArray.get(i).getPurchasePrice());
					output.print("\t"+proArray.get(i).getRehabCost()+"\t"+proArray.get(i).getPriceSold()+"\t"+proArray.get(i).getTotalCost());
					output.print("\t"+proArray.get(i).getNetIncome()+"\t"+proArray.get(i).getTaxes()+"\t"+proArray.get(i).getProfitLoss());
					output.print("\t"+proArray.get(i).getPercentGainLoss());
					
					output.println();
				}
				
				output.close();
			}

		}
