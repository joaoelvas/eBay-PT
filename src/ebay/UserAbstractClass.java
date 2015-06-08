// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public abstract class UserAbstractClass implements User, Comparable<User> {

	protected String username, name, email;
	protected int sellingsTotal, totalNumberOfSells;
	
	public UserAbstractClass(String username, String name, String email) {
		this.username = username;
		this.name = name;
		this.email = email;
		//
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getSellingsTotal() {
		return sellingsTotal;
	}
	
	public int getTotalNumberOfSells() {
		return totalNumberOfSells;
	}
	
	public void addSell(int value) {
		totalNumberOfSells++;
		sellingsTotal += value;
	}

}
