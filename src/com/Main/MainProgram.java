package com.Main;

import java.util.ArrayList;
import java.util.Scanner;

import com.management.School;
import com.management.Student;
import com.management.SupportiveStaff;
import com.management.Teacher;
import com.schoolCrudOperation.School1;
import com.schoolCrudOperation.Student1;
import com.schoolCrudOperation.SupportiveStaff1;
import com.schoolCrudOperation.Teacher1;

public class MainProgram {
	
   

	School1 school1=new School1();
	
	Teacher1 teacher1=new Teacher1();
	
	Student1 student1=new Student1();
	
	SupportiveStaff1 supportivestaff1=new SupportiveStaff1();
	
	
public static void main(String[] args) {
	MainProgram m=new MainProgram();
	
	System.out.println("Welcome to School Management Services.We are providing following functions");
	Scanner sc=new Scanner(System.in);
	int parentChoice=0;
	do {
		System.out.println("1.Enter 1 to perform student related operation \n 2.Enter 2 to perform Supportive Staff related operation \n 3.Enter 3 to perform Teacher related operation \n 4.Enter 4 to perform School related operation \n 5.Enter 5 to exist the program ");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	
		parentChoice=sc.nextInt();
		if(parentChoice>=1 || parentChoice <=5)
		{
			int childChoice=0;
			switch(parentChoice)
			{
			case 1:
				
				System.out.println("1.Enter 1 to create a student \n 2.Enter 2 to get list of Students present at a time \n 3.Enter 3 to get Student based on roll no \n 4.Enter 4 to update student  Details \n 5.Enter 5 to delete student Details \n 6.Enter 6 to go back to main menu  \n");
				childChoice=sc.nextInt();
				m.studentTask(childChoice,sc);
				System.out.println("=======================================================================================");
				break;
			case 2:
				System.out.println("1.Enter 1 to create a supportive staff  \n 2.Enter 2 to get list of supportive staff present at a time \n 3.Enter 3 to get supportive staff based on ID  \n 4.Enter 4 to update Student Details \n 5.Enter 5 to delete Student Details \n 6.Enter 6 to go back to main menu  \n");
				childChoice=sc.nextInt();
				m.supportiveStaffTask(childChoice,sc);
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
				
			case 3:
				System.out.println("1.Enter 1 to create a Teacher \n 2.Enter 2 to get list of Teacher present at a time \n 3.Enter 3 to get Teacher based on id \n 4.Enter 4 to update Teacher Details \n 5.Enter 5 to delete Teacher Details \n 6.Enter 6 to go back to main menu  \n");
				childChoice=sc.nextInt();
				m.teacherTask(childChoice,sc);
				System.out.println("==========================================================================================");
				break;
			
			case 4:
				System.out.println("1.Enter 1 to create a School  \n 2.Enter 2 to get list of School present at a time \n 3.Enter 3 to get School based on id \n 4.Enter 4 to update School Details \n 5.Enter 5 to School Teacher Details \n 6.Enter 6 to go back to main menu  \n");
				childChoice=sc.nextInt();
				m.schoolTask(childChoice,sc);
				System.out.println("=============================================================================================");
				break;
					
				case 5:
				System.out.println("*******Thank You for using our services.Please visit again******");
				System.out.println("============================================================================================");
				break;
			
			}
		}
		else
		{
			System.out.println("Please enter valid choice");
		}
		
		
	}while(parentChoice!=5);
	

}



private void schoolTask(int childChoice, Scanner sc) {
	switch(childChoice)
	{
	case 1:
		System.out.println("Please enter Following details to create School..");
		School school=getSchoolDetailsFromUser(sc);
		System.out.println("School created Successfully with ID" + school1.createSchoolDetails(school));
		break;
		
	case 2:
		ArrayList<School> schoolList=school1.getAllSchoolDetails();
		schoolList.stream().forEach((schoolFromList)-> System.out.println(schoolFromList));
		break;
		
	case 3:
		schoolTask(2,sc);
		System.out.println("Please enter school ID for which you want details:");
		int sid=sc.nextInt();
		School s1=school1.getSchoolDetail(sid);
		if(s1 !=null)
		{
			System.out.println(s1);
		}
		else
		{
			System.out.println("No details found");
		}
		break;
		
	case 4:
		schoolTask(2,sc);
		System.out.println("Please enter school id which you want to update.");
		int sid1=sc.nextInt();
		School updatedObject=getSchoolDetailsFromUser(sc);
		updatedObject.setSchoolID(sid1);
		int value=school1.updateSchoolDetails(updatedObject);
		if(value>0)
		{
			System.out.println(value + "updated successfully.");
		}
		else
		{
			System.out.println("No details found");
		}
		break;
		
	case 5:
		schoolTask(2,sc);
		System.out.println("Please enter school id which you want to delete.");
		int s=sc.nextInt();
	int deletedId =	school1.deleteSchoolDetails(s);
	if(deletedId>0)
	{
		System.out.println(deletedId + "deleted Successfully");
	}
	else
	{
		System.out.println("No details found");
	}
		break;
		
	case 6:
		System.out.println("You are navigating back to main menu");
		break;
	}
	
}



private School getSchoolDetailsFromUser(Scanner sc) {
	System.out.print("Please enter schoolID:");
	int schoolID=sc.nextInt();
	System.out.print("Please enter schoolName:");
	String name=sc.next();
	System.out.print("Please enter year of Opening:");
	String yearOfOpening=sc.next();
	
	
	System.out.println("Please enter medium:");
	String medium=sc.next();
	
	School school=new School(name,yearOfOpening,medium,schoolID);
	return school;
}



private void supportiveStaffTask(int childChoice, Scanner sc) {
	
	switch(childChoice)
	{
	case 1:
		System.out.println("Please enter Supportive staff details..");
		SupportiveStaff ss=getSupportiveStaffDetailsFromUser(sc);
		System.out.println("Staff object created with" + supportivestaff1.createSupportiveStaffDetails(ss));
		
		break;
		
	case 2:
		ArrayList<SupportiveStaff> ssList=supportivestaff1.getAllSupportiveStaffDetails();
		ssList.stream().forEach((ssFromList)->System.out.println(ssFromList));
		break;
		
	case 3:
		supportiveStaffTask(2,sc);
		System.out.println("Please enter id for which you want details:");
		int ssid=sc.nextInt();
		SupportiveStaff ss1=supportivestaff1.getSupportiveStaffDetails(ssid);
		if(ss1 != null)
		{
			System.out.println(ss1);
		}
		else
		{
			System.out.println("No details found");
		}
		break;
		
	case 4:
		supportiveStaffTask(2,sc);
		System.out.println("Enter id for which you want to update the details:");
		int sid=sc.nextInt();
		SupportiveStaff updatedObject=getSupportiveStaffDetailsFromUser(sc);
		updatedObject.setId(sid);
		int updatedID=supportivestaff1.updateSupportiveStaffDetails(updatedObject);
		if(updatedID>0)
		{
			System.out.println(updatedID + "Updated successfully....");
			
		}
		else
		{
			System.out.println("No details found");
		}
		break;
		
	case 5:
		supportiveStaffTask(2,sc);
		System.out.println("Enter  id which you want to delete...");
		int deleteID=sc.nextInt();
	int deletedID=	teacher1.deleteTeacherDetails(deleteID);
	
	if(deletedID>0)
	{
		System.out.println(deletedID + "Deleted successfully....");
	}
	else
	{
		System.out.println("No details found");
	}
		
		break;
		
	case 6:
		System.out.println("You are navigating back to main menu");
		break;
	
	}
	
}



private SupportiveStaff getSupportiveStaffDetailsFromUser(Scanner sc) {
	System.out.println("please enter following details to create Supportive staff detail: ");
	System.out.print("Please enter name:");
	String name=sc.next();
	System.out.print("Please enter age:");
	int age=sc.nextInt();
	System.out.print("Please enter address:");
	String address=sc.next();
	System.out.print("Please enter ID:");
	int id=sc.nextInt();
	System.out.print("Please enter domain:");
	String domain=sc.next();
	SupportiveStaff ss=new SupportiveStaff(name,age,address,id,domain);
	return ss;



}



private void teacherTask(int childChoice, Scanner sc) {
	// TODO Auto-generated method stub
	switch(childChoice)
	{
	case 1:
	Teacher teacher=getTeacherDetailsFromUser(sc);
	System.out.println("Teacher object is created with"+teacher1.createTeacherDetails(teacher)+"id");
	
	break;
	case 2:
		ArrayList<Teacher> teacherList=teacher1.getAllTeacherDetails();
		teacherList.stream().forEach((teacherFromList)->System.out.println(teacherFromList));
		break;
	case 3:
		teacherTask(2,sc);
		System.out.println("Please enter id for which you want details:");
		int teacherID=sc.nextInt();
		Teacher teach=teacher1.getTeacherDetails(teacherID);
		if(teach!=null)
		{
			System.out.println(teach);
		}
		else
		{
			System.out.println("No details found");
		
		}
	case 4:
		teacherTask(2,sc);
		System.out.println("For which id you want to update teacher details.");
		int teacherid=sc.nextInt();
		Teacher t1=getTeacherDetailsFromUser(sc);
		t1.setId(teacherid);
		int updatedID =teacher1.updateTeacherDetails(t1);
		if(updatedID>0)
		{
			System.out.println(updatedID + "Updated Successfully....");
		}
		else
		{
			System.out.println("No details found");
		}
		break;
	case 5:
		teacherTask(2,sc);
		System.out.println("Enter teacher id which ypu want to delete...");
		int id=sc.nextInt();
	int deletedID=	teacher1.deleteTeacherDetails(id);
	if(deletedID>0)
	{
		System.out.println(deletedID + "Deleted successfully....");
	}
	else
	{
		System.out.println("No details found");
	}
	case 6:
		System.out.println("You are navigating back to main menu");
		break;
	}
}



private Teacher getTeacherDetailsFromUser(Scanner sc) {
	// TODO Auto-generated method stub
	System.out.println("please enter following details to create teacher. ");
	System.out.print("Please enter name:");
	String name=sc.next();
	System.out.print("Please enter age:");
	int age=sc.nextInt();
	System.out.print("Please enter address:");
	String address=sc.next();
	System.out.print("Please enter teacher ID:");
	int id=sc.nextInt();
	System.out.print("Please enter qualification(enter in comma seperated mode):");
	String qualification=sc.next();
	System.out.print("Please enter Subject(enter in comma seperated mod):");
	String subject=sc.next();
	Teacher teacher=new Teacher(name,age,address,id,qualification,subject);
	
	return teacher;
}



private  void studentTask(int childChoice, Scanner sc) {
	// TODO Auto-generated method stub
	switch(childChoice)
	{
	case 1:
	Student s=getStudentDetailsFromUser(sc);
	System.out.println("Student is created and added to Student List with"+student1.createStudent(s));
break;
	case 2:
		ArrayList<Student>studentList=student1.getAllStudentDetails();
		studentList.stream().forEach(studentFromList->System.out.println(studentFromList));
		break;
	
		case 3:
			System.out.println("Please enter roll no to get Student detail.");
			int rno=sc.nextInt();
			Student searchStudent=student1.getStudentDetailByRollNo(rno);
			if(searchStudent!=null)
			{
				System.out.println(searchStudent);
			}
			else
			{
				System.out.println("no details found...........");
			}
			break;
		case 4:
			studentTask(2,sc);
			System.out.println("enter roll No for which you want to update the details");
		int	rno1=sc.nextInt();
		Student updatedData=getStudentDetailsFromUser(sc);
		updatedData.setRollNo(rno1);
		
		int updatedStudentRollNo=student1.updateStudentDetail(updatedData);
		if(updatedStudentRollNo>0)
		{
		System.out.println("Updated Student's rollNo:" + updatedStudentRollNo);
		}
		else
		{
			
			System.out.println("No record found in update" );
		}
			break;
			
		case 5:
		studentTask(2,sc);
		System.out.println("enter roll No for which you want to delete the details");
		int	rno2=sc.nextInt();
		int deletedStudentRollNo=student1.deleteStudentDetails(rno2);
		if(deletedStudentRollNo>0)
		{
		System.out.println("Student data deleted with this roll no"+deletedStudentRollNo);
		}
		else
		{
			System.out.println("no student details found with given roll no"+rno2);
		}
			break;
			
		case 6:
		{
			System.out.println("You are navigating back to main menu");
		}
			break;
					
	}
}



private Student getStudentDetailsFromUser(Scanner sc) {
	// TODO Auto-generated method stub
	System.out.println("Please enter following Student details");
	System.out.print("Please enter name:");
	String name=sc.next();
	System.out.print("Please enter age:");
	int age=sc.nextInt();
	System.out.print("Please enter address:");
	String address=sc.next();
	System.out.print("Please enter your roll no:");
	int rollNo=sc.nextInt();
	System.out.print("Please enter standard :");
	int standard=sc.nextInt();
	System.out.print("Please enter your area of interest:");
	String areaOfInterest=sc.next();
	Student s=new Student(name,age,address,rollNo,standard,areaOfInterest);
	return s;
	
}

}
