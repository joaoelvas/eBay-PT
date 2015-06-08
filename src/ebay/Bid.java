// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author Jo�o Elvas - MIEI - 41934 
 */

public interface Bid {

	/**
	 * Retorna o USER que efetua a licita��o.
	 * @return user
	 */
	User getBidder();
	
	/**
	 * Retorna o valor da licita��o.
	 * @return value
	 */
	int getBidValue();

}
