// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author Jo�o Elvas - MIEI - 41934 
 */

public interface Product extends Comparable<Product>{
	
	/**
	 * Retorna o codigo de identifica��o do PRODUCT.
	 * @return code
	 */
	String getCode();
	
	/**
	 * Retorna a descri��o <code>discription</code> do produto.
	 * @return discription
	 */
	String getDiscription();
	
	/**
	 * Retorna o estado do produto.
	 * @return <code>SALE</code>, <code>AUCTION</code> ou <code>SOLD</code>
	 */
	String getStatus();
	
	/**
	 * Retorna o leil�o correspondente ao produto.
	 * @return auction caso j� tenha sido posto � venda ou NULL caso contrario. 
	 */
	Auction getAuction();
	
	/**
	 * Retorna o USER que criou o produto.
	 * @return user
	 */
	User getUser();
	
	/**
	 * Adiciona a AUCTION ao produto quando este � posto � venda.
	 * @param auction
	 */
	void addAuction(Auction auction);
	
	/**
	 * Altera o estado do produto quando este � vendido.
	 */
	void setAsSold();
	
	/**
	 * Altera o estado do produto quando este n�o � vendido e deixa de estar em leil�o.
	 */
	void setAsSale();
	
	/**
	 * Remove a auction quando o produto n�o � vendido e deixa de estar em leil�o.
	 */
	void removeAuction();
}
