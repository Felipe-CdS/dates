import java.util.Scanner;
import java.util.HashMap;

class Dates {

	private static HashMap<Integer, Integer> monthDays = new HashMap<Integer, Integer>();

	private int day, month, year, totalDays;
	private String writtenMonth;

	public Dates(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
		this.writtenMonth = convertMonth(month);
	}

	private void populateHashMap(){
		monthDays.put(1, 31);
		if(checkLeapYear(this.year)){ monthDays.put(2, 29); }
		else{ monthDays.put(2, 28); }
		monthDays.put(3, 31);
		monthDays.put(4, 30);
		monthDays.put(5, 31);
		monthDays.put(6, 30);
		monthDays.put(7, 31);
		monthDays.put(8, 30);
		monthDays.put(9, 31);
		monthDays.put(10, 30);
		monthDays.put(11, 31);
		monthDays.put(12, 30);
	}

	private static String convertMonth(int month){
		switch(month){
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				return "Error";
		}
	}

	private static int convertMonth(String writtenMonth){
		switch(writtenMonth){
			case "january":
				return 1;
			case "february":
				return 2;
			case "march":
				return 3;
			case "april":
				return 4;
			case "may":
				return 5;
			case "june":
				return 6;
			case "july":
				return 7;
			case "august":
				return 8;
			case "september":
				return 9;
			case "october":
				return 10;
			case "november":
				return 11;
			case "december":
				return 12;
			default:
				return 0;
		}
	}

	private static boolean checkLeapYear(int year){
		if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
			return true;
		}
		else{
			return false;
		}
	}

	//This includes the last day;
	public void totalDaysUntilNow(){
		int total = 0;
		for(int i = 1; i < this.month; i++){
			total += monthDays.get(i);
		}
		total += this.day;
		this.totalDays = total;
	}

	public static void main(String[] args){
		int dayHolder = 0, monthHolder = 0, yearHolder = 0;
		String writtenMonthHolder = "a";
		Scanner sc = new Scanner(System.in);

		System.out.println("What is you entry type:");
		System.out.println("1) DD / MM / YYYY");
		System.out.println("2) MM / DD / YYYY");
		System.out.println("3) (written) MM / DD / YYYY");

		int entryChoice = sc.nextInt();

		switch(entryChoice){
			case 1:
				System.out.println("Enter the day:");
				dayHolder = sc.nextInt();
				System.out.println("Enter the month:");
				monthHolder = sc.nextInt();
				System.out.println("Enter the year:");
				yearHolder  = sc.nextInt();
				break;

			case 2:
				System.out.println("Enter the month:");
				monthHolder = sc.nextInt();
				System.out.println("Enter the day:");
				dayHolder = sc.nextInt();
				System.out.println("Enter the year:");
				yearHolder  = sc.nextInt();
				break;

			case 3:
				System.out.println("Enter the month(written):");
				sc.nextLine();
				writtenMonthHolder = sc.nextLine();
				System.out.println("Enter the day:");
				dayHolder = sc.nextInt();
				System.out.println("Enter the year:");
				yearHolder  = sc.nextInt();
				break;

			default:
				System.out.println("Not a valid option...");
				System.exit(1);
		}

		if(monthHolder == 0){
			monthHolder = convertMonth(writtenMonthHolder);	
		}

		Dates date = new Dates(dayHolder, monthHolder, yearHolder);

		date.populateHashMap();
		date.totalDaysUntilNow();

		System.out.println("\nThe day is:");
		System.out.println(date.day + "/" + date.month + "/" + date.year);
		System.out.println(convertMonth(date.month) + "/" + date.day + "/" + date.year);
		System.out.println(date.totalDays + "/" + date.year);
	}

}