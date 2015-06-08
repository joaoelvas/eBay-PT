// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Auction extends Comparable<Auction> {
	
	/**
	 * @return <code>true</code> se a AUCTION estiver aberta, <code>false</code> caso contrario.
	 */
	boolean isOpen();
	
	/**
	 * Retorna o produto que está a ser leiloado.
	 * @return Product
	 */
	Product getProduct(); 
	
	/**
	 * Retorna o valor base do leilão.
	 * @return startingValue
	 */
	int getStartingValue();
	
	/**
	 * Retorna o valor actual do leilão.
	 * @return currentValue
	 */
	int getCurrentValue();
	
	/**
	 * Actualiza o valor actual do leilão.
	 * @param value
	 */
	void addToCurrentValue(int value);
	
	/**
	 * Altera a variavel <code>isOpen</code> para false.
	 */
	void closeAuction();
}
