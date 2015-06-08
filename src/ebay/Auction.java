// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author Jo�o Elvas - MIEI - 41934 
 */

public interface Auction extends Comparable<Auction> {
	
	/**
	 * @return <code>true</code> se a AUCTION estiver aberta, <code>false</code> caso contrario.
	 */
	boolean isOpen();
	
	/**
	 * Retorna o produto que est� a ser leiloado.
	 * @return Product
	 */
	Product getProduct(); 
	
	/**
	 * Retorna o valor base do leil�o.
	 * @return startingValue
	 */
	int getStartingValue();
	
	/**
	 * Retorna o valor actual do leil�o.
	 * @return currentValue
	 */
	int getCurrentValue();
	
	/**
	 * Actualiza o valor actual do leil�o.
	 * @param value
	 */
	void addToCurrentValue(int value);
	
	/**
	 * Altera a variavel <code>isOpen</code> para false.
	 */
	void closeAuction();
}
