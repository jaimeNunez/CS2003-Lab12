package BinaryTrees;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

public class CompareStudents {

	//ArrayList<StudentGPA> students = new ArrayList<StudentGPA>();
	//ArrayList<GraduateStudentGPA> gradStudents = new ArrayList<GraduateStudentGPA>();
	StudentGPA [] students = new StudentGPA[5];
	GraduateStudentGPA [] gradStudents = new GraduateStudentGPA[5];
	
	public void readFile() {
		try {
		    File inputFile = new File("students.in");
		    Scanner input = new Scanner(inputFile);
		  
		    //initialize all of the variables you will use in the readFile method
		    //count should determine the number of names in the list
		    int count = 0;
		    while (input.hasNextLine()){
		    	System.out.println();
		    	count++;
		    }
		    
		    int i = 0;
		    input.close();
		    while (input.hasNextLine()){
		    	int id;
		    	String name;
		    	Double gpa;
		    	String advisor;
		    	id = input.nextInt();
		    	name = input.next();
		    	gpa = input.nextDouble();
		    	advisor = input.nextLine();
		    	if(advisor == null) {
		    		students[i] = new StudentGPA(id, name, gpa);
		    		i++;
		    	}
		    	else {
		    		gradStudents[i] = new GraduateStudentGPA(id, name, gpa, advisor);	
		    		i++;
		    	}
		    	
		    }
		}
		
		catch (IOException e) {
		    System.err.println("IOException in reading input file!!!");
		}	
	    } //end readFile()
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree theTree = new BinarySearchTree(students[0]);
		int i = 0;
		while(i < 6) {
			theTree.insert(students[i]);
			theTree.insert(gradStudents[i]);
			i++;
		}
		TreeIterator iterate = new TreeIterator(theTree);
		iterate.printPreorder();
		

	}

}
