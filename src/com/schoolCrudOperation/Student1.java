package com.schoolCrudOperation;

import java.util.ArrayList;
import java.util.Iterator;

import com.management.Student;

public class Student1 {
ArrayList<Student>studentList=new ArrayList<>();



public int createStudent(Student s)
{
	studentList.add(s);
	return  s.getRollNo();
}

public Student getStudentDetailByRollNo(int i)
{
	Iterator<Student> itr=studentList.iterator();
	while(itr.hasNext())
	{
		Student s=itr.next();
		if(s.getRollNo()==i)
		{
			return s;
		}
	}
	return null;
}
public ArrayList<Student>getAllStudentDetails()
{
	return studentList;
}
public int updateStudentDetail(Student student)
{
	Iterator<Student> itr=studentList.iterator();
	int count=0;
	while(itr.hasNext()) 
	{
		Student s=itr.next();
		if(s.getRollNo()==student.getRollNo())
		{
			studentList.set(count,student);
			return student.getRollNo();
		}
	}
	return 0;
	}
public int deleteStudentDetails(int rollNo)
{
	Iterator<Student> itr=studentList.iterator();

	while(itr.hasNext()) 
	{
	Student s=itr.next();
	if(s.getRollNo()==rollNo)
	{
		studentList.remove(s);
		return s.getRollNo();
	}
	}
	return 0;

}
}