package atm;
import java.util.ArrayList;


public class Bank {
	 private ArrayList<Account> accounts;

	    public Bank() {
	        accounts = new ArrayList<>();

	        // Demo account
	        accounts.add(new Account("user123", "1234", 10000));
	    }

	    public Account authenticate(String userId, String pin) {

	        for (Account account : accounts) {
	            if (account.getUserId().equals(userId)
	                    && account.getPin().equals(pin)) {
	                return account;
	            }
	        }

	        return null;
	    }

}
