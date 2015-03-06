package edu.sc.cse.coursestats;

public class WeekTime {

	private String day;
	private String time;
	private String ampm;
	private Course course;
	
	public WeekTime(String d, String t, String am){
		day = d;
		time = t;
		ampm = am;
	}
	
	public WeekTime(String d, String t, String am, Course c){
		day = d;
		time = t;
		ampm = am;
		course = c;
	}
	
	//END OF GETTERS AND SETTERS

	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getAmpm() {
		return ampm;
	}


	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}


	public String toString(){
		String str;
		str = day + time + ampm;
		return str;
	}
	
	
	
	public int compareTime(WeekTime w2){
		int val;
		String w1Time = this.getTime() + this.getAmpm();
		String w2Time = w2.getTime() + w2.getAmpm();
		
		val = w1Time.compareTo(w2Time);
		
		if(val > 0) val = 1;
		if(val < 0) val = -1;
		
		return val;
	}
	
}
