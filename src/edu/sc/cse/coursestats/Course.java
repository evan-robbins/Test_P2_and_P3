package edu.sc.cse.coursestats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Course {
	 private String dept;
	 private int number;
	 private String instructor;
	 private String start;
	 private String finish;
	 
	 public Course(String d, int num, String instr){
		 dept = d;
		 number = num;
		 instructor = instr;
		 start = "";
		 finish = "";
	 }
	 
	 public Course(String d, int num, String instr, String s, String f)
	 {
		 dept = d;
		 number = num;
		 instructor = instr;
		 start = s;
		 finish = f;
	 }
	 
	 public Course(String name)
	 {
		 Course temp = new Course("Error", 0, "Error", "Error", "Error");
		 temp = scheduleDB(name);
		 dept = temp.getDept();
		 number = temp.getNumber();
		 instructor = temp.getInstructor();
		 start = temp.getStart();
		 finish = temp.getFinish();
		 
	 }
	 
	 public Course scheduleDB(String s)
	 {
	   	  Course c1 = new Course("",0,"","","");

			String filename = "data/sched.csv";
			File infile = null;
			try{
				infile = new File(filename);
				Scanner scanner = new Scanner(infile);	
				String header = scanner.nextLine();
				String line;
				int linecounter = 0;
				String dept="";
				String num="";
				String sect="";
				String instructor="";
				String room="";
				String days="";
				String timeOfDay="";
				String cap="";
				String enrolled="";
				
				while (scanner.hasNext()) {
					line = scanner.nextLine();
					linecounter++;
					String[] field = line.split("	");
					if (field.length == 18){
						if (field[2].length() > 2){
							dept = field[2];
							num = field[3];	
							sect = field[4];
							cap= field[11];
							enrolled=field[12];
						}
						days = field[9];
						timeOfDay = field[10];
						instructor= field[14];
						//15 = dates
						room= field[16];
						//enrolled=field[12];
						
						String temp = dept + num;
	   					int tempNum = Integer.parseInt(num.trim());

	   					 
	   					//System.out.println(temp + " " + temp2);
	   					if (temp.indexOf(s) >= 0 )
	   					{
	   					 c1.setInstructor(instructor);
	   					 c1.setStart(timeOfDay.substring(0, timeOfDay.indexOf('-')));
	   					 c1.setFinish(timeOfDay.substring(timeOfDay.indexOf('-')+1));
	   					 c1.setDept(dept);
	   					 c1.setNumber(tempNum);
	   					 scanner.close();
	   					 
	   					 return c1; 
	   					 }

						
						

					}else{

					}
			}
				
			} catch (FileNotFoundException e){
				System.out.println("Error opening file='" + filename+"'");
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
	   		 
	   	return c1;
	 }

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	
	 public String toString(){
		 String  str;
		 //str = "CSCE" + "109" + "Matthews";
		 str = dept + " " + Integer.toString(number) + " " +instructor+ " " + start + " " + finish;
		 return str;
	 }
	 
	 public int compareTime(Course c2){
		 int val;
		 
		String w1Time = this.getStart() + this.getFinish();
		String w2Time = c2.getStart() + c2.getFinish();
		
		val = w1Time.compareTo(w2Time);
			
		if(val > 0) val = 1;
		if(val < 0) val = -1;
		 
		 return val;
	 }
}
