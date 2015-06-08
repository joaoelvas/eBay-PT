// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Bid {

	/**
	 * Retorna o USER que efetua a licitação.
	 * @return user
	 */
	User getBidder();
	
	/**
	 * Retorna o valor da licitação.
	 * @return value
	 */
	int getBidValue();

}
