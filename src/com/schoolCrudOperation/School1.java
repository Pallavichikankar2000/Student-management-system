package com.schoolCrudOperation;

import java.util.ArrayList;
import java.util.Iterator;

import com.management.School;

public class School1 {

	public ArrayList<School>schoolList=new ArrayList<>();
	
	public int createSchoolDetails(School s)
	{
		schoolList.add(s);
		return s.getSchoolID();
	}
	public ArrayList<School> getAllSchoolDetails()
	{
		return schoolList;
	}
	public School getSchoolDetail(int schoolId)
	{
		Iterator<School>itr=schoolList.iterator();
		while(itr.hasNext())
		{
			School s=itr.next();
			if(s.getSchoolID()==schoolId)
			{
				return s;
			}
		}
		return null;
	}
	public int updateSchoolDetails(School s)
	{
		Iterator<School>itr=schoolList.iterator();
		int count=0;
		while(itr.hasNext())
		{
			School s1=itr.next();
			if(s1.getSchoolID()==s.getSchoolID())
			{
				schoolList.set(count, s1);
				return s.getSchoolID();
			}
		}
	return 0;
	}
	public int deleteSchoolDetails(int id)
	{
		Iterator<School> itr=schoolList.iterator();
		
		while(itr.hasNext())
		{
			School s=itr.next();
		 if(s.getSchoolID()==id)
		 {
			 schoolList.remove(s);
			 return s.getSchoolID();
		 }
		
	}
		return 0;
	}
	
}
