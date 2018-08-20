package dto;

public class Touroku {
	private int id;
	private String name;
	private int kin;
	private int year;
	private int mon;
	private int day;

	public Touroku(){

	}

	public Touroku(int id , String name, int kin, int year, int mon, int day){
		this.id = id;
		this.name = name;
		this.kin = kin;
		this.year  = year;
		this.mon = mon;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKin(){
		return kin;
	}

	public void setKin(int kin){
		this.kin = kin;
	}

	public int getYear(){
		return year;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getMon(){
		return mon;
	}

	public void setMon(int mon){
		this.mon = mon;
	}

	public int getDay(){
		return day;
	}

	public void setDay(int day){
		this.day = day;
	}
}
