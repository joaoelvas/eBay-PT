// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface User extends Comparable<User> {

	/**
	 * Retorna o username do USER.
	 * @return username
	 */
	String getUsername();
	
	/**
	 * Retorna o nome do USER.
	 * @return name
	 */
	String getName();
	
	/**
	 * Retorna o email do USER.
	 * @return email
	 */
	String getEmail();
	
	/**
	 * Retorna o valor de vendas do USER.
	 * @return selingsTotal
	 */
	int getSellingsTotal();
	
	/**
	 * Retorna o numero total de vendas do USER.
	 * @return totalNumberOfSells
	 */
	int getTotalNumberOfSells();
	
	
	/**
	 * Adiciona uma venda ao utilizador a actualiza o valor total de vendas adicionando <code>value</code>.
	 * @param value
	 */
	void addSell(int value);
}
