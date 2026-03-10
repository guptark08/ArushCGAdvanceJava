package Regex;

public class SecureBankingTransactionRecordValidator {
	
	public static boolean TxnId(String str) {
		return str.matches("^[A-Z](?=(.*[A-Z]{2}))(?=(.*[0-9]{2}))(?!.*(\\w)\\1{2})[A-Z].{4}$");
	}
	
	public static boolean UserCheck(String str) {
		return str.matches("^[a-z](.*(_)?)(?!.*((_)\\1{1}))(?=.*([0-9]{1}))[a-z]{5,13}$");
	}
	
	
	public static void main(String[] args) {
		String str = "TRX#A9F4K2|arush_99|SB-9081726354|HDFC0123456|125000.75|INR|2024-02-29T23:59:59|UPI|SUCCESS|REF-AF29XZ"; 
				
	}

}
