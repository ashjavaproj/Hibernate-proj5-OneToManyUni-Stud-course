package com.web.test;

import java.util.Scanner;
import org.hibernate.Session;
import com.web.model.Course;
import com.web.model.Student;
import com.web.utility.HibernateUtil;

public class Main {
static Scanner sc=new Scanner(System.in);
	public static void saveStudInfo()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		   Course java=new Course();
		   java.setCourseId(103);
		   java.setCName("Java");
		   java.setCFees(95000.0f);
		   
		   Course python=new Course();
		   python.setCourseId(104);
		   python.setCName("Python");
		   python.setCFees(90000.0f);
		   
		   Student student=new Student();
		   student.setStudId(2);
		   student.setStudName("Sagar");
		   student.setsAddress("pune");
		   student.getCourses().add(java);
		   student.getCourses().add(python);
		   
		   session.save(student);
		   session.beginTransaction().commit();

		
	}
	public static void addCourses()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter 1st Course Details");
		Course java=new Course();
		System.out.print("Course Id = ");
		java.setCourseId(sc.nextInt());
		System.out.print("Course Name = ");
		java.setCName(sc.next());
		System.out.print("Course Fees = ");
		java.setCFees(sc.nextFloat());
		
		System.out.println("Enter 2nd Course Details");
		Course python=new Course();
		System.out.print("Course Id = ");
		python.setCourseId(sc.nextInt());
		System.out.print("Course Name = ");
		python.setCName(sc.next());
		System.out.print("Course Fees = ");
		python.setCFees(sc.nextFloat());
		
		System.out.println("Enter 3rd Course Details");
		Course c=new Course();
		System.out.print("Course Id = ");
		c.setCourseId(sc.nextInt());
		System.out.print("Course Name = ");
		c.setCName(sc.next());
		System.out.print("Course Fees = ");
		c.setCFees(sc.nextFloat());
		
		System.out.println("Enter 4th Course Details");
		Course cpp=new Course();
		System.out.print("Course Id = ");
		cpp.setCourseId(sc.nextInt());
		System.out.print("Course Name = ");
		cpp.setCName(sc.next());
		System.out.print("Course Fees = ");
		cpp.setCFees(sc.nextFloat());
		
		session.save(java);
		session.save(python);
		session.save(c);
		session.save(cpp);
		session.beginTransaction().commit();
	}
	public static void addStudent()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		Student stu=new Student();
		System.out.print("Enter Student Name = ");
		stu.setStudName(sc.next());
		System.out.print("Enter Student Contact No = ");
		stu.setsContactNo(sc.nextLong());
		System.out.print("Enter Student Address = ");
		stu.setsAddress(sc.next());
		System.out.println("Enter how Many Courses u want to do?");
		int cno=sc.nextInt();
		for(int i=1;i<=cno;i++)
		{
			System.out.println("Enter 101 for java");
			System.out.println("Enter 102 for python");
			System.out.println("Enter 103 for C");
			System.out.println("Enter 104 for C++");
			
			Course course=session.get(Course.class,sc.nextInt());
			stu.getCourses().add(course);
		}
		session.save(stu);
		session.beginTransaction().commit();
		
	}
	public static void getStudDetails()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println("Enter Student ID u Want to Display Records");
		
		Student stud=session.get(Student.class,sc.nextInt());
		System.out.println("Student Id = "+stud.getStudId());
		System.out.println("Student Name = "+stud.getStudName());
		System.out.println("Student Contact No = "+stud.getsContactNo());
		System.out.println("Student Address = "+stud.getsAddress());
		stud.getCourses().forEach(c->{
			System.out.println("Course Id = "+c.getCourseId());
			System.out.println("Course Name = "+c.getCName());
			System.out.println("Course Fees = "+c.getCFees());
			System.out.println();
				
		});
	}
	public static void removeCourse()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println("1=Remove Course ");
		System.out.println("2=update Course ");
		System.out.print("Enter Choice What u want ");
		switch(sc.nextInt())
		{
		case 1:
			System.out.println("Enter Student ID u Want to  remove Course");
			Student stud=session.get(Student.class,sc.nextInt());
			
			stud.getCourses().forEach(c->{
				
			System.out.println("Course Id = "+c.getCourseId());
			System.out.println("Course Name = "+c.getCName());
			System.out.println("Course Fees = "+c.getCFees());
			System.out.println();
			});
			
			System.out.println("Enter Course Id you Want To Remove ");
			Course course=session.get(Course.class, sc.nextInt());
			stud.getCourses().remove(course);
			session.update(stud);
			session.beginTransaction().commit();
			System.out.println("You R Removed From"+course.getCName()+"Course...!");
		break;
		
		case 2:
			System.out.println("Enter Student ID u Want to  remove Course");
			Student stud1=session.get(Student.class,sc.nextInt());
		
			stud1.getCourses().forEach(c->{
			
				System.out.println("Course Id = "+c.getCourseId());
				System.out.println("Course Name = "+c.getCName());
				System.out.println("Course Fees = "+c.getCFees());
		
			});
		
			System.out.println("Enter Course Id you Want To Update ");
			Course course1=session.get(Course.class, sc.nextInt());
			stud1.getCourses().remove(course1);
		
			System.out.println("Enter 101 for java");
			System.out.println("Enter 102 for python");
			System.out.println("Enter 103 for C");
			System.out.println("Enter 104 for C++");
			System.out.println("Enter New Course Name U want to Update");
			Course cours=session.get(Course.class,sc.nextInt());
			stud1.getCourses().add(cours);
		
			
			session.update(stud1);
			session.beginTransaction().commit();
			System.out.println("You R Removed From"+course1.getCName()+"Course...!");
	
		break;
				}
				}
	public static void removestudent()
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.print("Enter Student ID u Want to Remove student ");
		Student stud=session.get(Student.class,sc.nextInt());
	stud.setCourses(null);
	session.delete(stud);
	session.beginTransaction().commit();
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println();
			System.out.println("*********STUDENT DETAILS *******");
				System.out.println("1=Save Student Records ");
				System.out.println("2=Add Courses");
				System.out.println("3=Add Students");
				System.out.println("4=Display Student Records ");
				System.out.println("5=Remove Course");
				System.out.println("6=Remove Student ");
				System.out.println("7=Exit ");
				System.out.print("Enter Choice : ");
				
				switch(sc.nextInt())
				{
				case 1:	Main.saveStudInfo();
				break;
				
				case 2: Main.addCourses();
				break;
				
				case 3: Main.addStudent();
				break;
				
				case 4: Main.getStudDetails();
				break;
				
				case 5: Main.removeCourse();
			
				break;
				
				case 6: Main.removestudent();
				break;
				
				case 7: System.exit(0);
				break;
				}
			}
			}
		}
