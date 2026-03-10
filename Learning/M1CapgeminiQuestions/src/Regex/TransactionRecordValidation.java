package Regex;

import java.time.LocalDate;

public class TransactionRecordValidation {

	public static boolean validTXN(String str) {
//		String [] validTxnId = str.split("-");
//		String validTXNchar = validTxnId[0];
//		String validdigit = validTxnId[1];
//		if(!validTXNchar.matches("^TXN")) return false;
//		if(validdigit.matches("^0")) return false; 
//		if(validdigit.matches("^(\\d)\\1+$")) return false; 

//		return true;

		return str.matches("^TXN-(?!.*(\\D)\\1{3})[1-9]\\d{5}$");
	}

	public static boolean isDate(String str) {
		String[] dates = str.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int date = Integer.parseInt(dates[2]);
		if (!dates[0].matches("[2][0][0-9][0-9]"))
			return false;
		try {
			LocalDate.of(year, month, date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isCurrency(String str) {
		return str.matches("(USD|EUR|INR|GBP|AUD|CAD)");
	}

	public static boolean isAmount(String str) {
		return str.matches("^([0]|[1-9]\\d{0,5}\\.\\d{1,2})$");
	}

	public static boolean isStatus(String str) {
		return str.matches("^(SUCCESS|FAILED|PENDING)");
	}

	public static void main(String[] args) {
		String str = "TXN-023456/2024-03-10/USD/100.00/FAILED";
		String[] sepStr = str.split("/");
//		for(String s : sepStr) System.out.println(s);
		String txn = sepStr[0];
		String date = sepStr[1];
		String currency = sepStr[2];
		String amount = sepStr[3];
		String status = sepStr[4];

		if (validTXN(txn))
			System.out.println("valid");
		else
			System.out.println("invalid");
		if (isDate(date))
			System.out.println("valid");
		else
			System.out.println("invalid");
		if (isCurrency(currency))
			System.out.println("valid");
		else
			System.out.println("invalid");
		if (isStatus(status))
			System.out.println("valid");
		else
			System.out.println("invalid");
		if (isAmount(amount))
			System.out.println("valid");
		else
			System.out.println("invalid");

//		if(validTXN(txn) && isDate(date) && isCurrency(currency) && isStatus(status) && isAmount(amount)) System.out.println("VALID");
//		else System.out.println("INVALID");
	}

}
