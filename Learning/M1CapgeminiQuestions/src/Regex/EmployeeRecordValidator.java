package Regex;

import java.time.LocalDate;

public class EmployeeRecordValidator {
	
	public static boolean validEMP(String str) {
		return str.matches("^EMP-(?!.*(\\d)\\1{2})[1-9]\\d{5}$");
	}
	public static boolean validEmail(String str) {
		return str.matches("^[a-z]+\\.[a-z]+@[a-z]+\\.[a-z]+$");
	}
	public static boolean validDept(String str) {
		return str.matches("(IT|HR|SALES|FINANCE|SUPPORT)");
	}
	public static boolean validStatus(String str) {
		return str.matches("(ACTIVE|INACTIVE|TERMINATED)");
	}
	public static boolean validSalary(String str) {
		int no = Integer.parseInt(str);
		if(no >= 30000 && no <= 200000) {
			return str.matches("([0]\\.\\d{2}|[1-9]\\d*\\.\\d{2})");
		}
		return false;
	}
	public static boolean validDate(String str) {
		String [] sepStr = str.split("-");
		int year = Integer.parseInt(sepStr[0]);
		int month = Integer.parseInt(sepStr[1]);
		int date = Integer.parseInt(sepStr[2]);
		if(!sepStr[0].matches("^(201[5-9]|202[0-5])$")) return false;
		try {
			LocalDate.of(year, month, date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {
		String str  = "EMP-482913|arush.kumar@company.com|2023-07-15|IT|75000.50|ACTIVE";
//		String [] sepStr = str.split("|");
	}

}
