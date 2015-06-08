// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author Jo�o Elvas - MIEI - 41934 
 */

public class UserAdminClass extends UserAbstractClass {

	public UserAdminClass(String username, String name, String email) {
		super(username, name, email);
	}
	
	public int compareTo(User o) {
		return this.getUsername().compareTo(o.getUsername());
	}
	
	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		} else if(arg0 instanceof UserAdminClass) {
			User a = (User) arg0;
			return this.getUsername().equals(a.getUsername());
		}
		return super.equals(arg0);
	}

}
