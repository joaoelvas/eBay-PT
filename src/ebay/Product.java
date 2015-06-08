// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Product extends Comparable<Product>{
	
	/**
	 * Retorna o codigo de identificação do PRODUCT.
	 * @return code
	 */
	String getCode();
	
	/**
	 * Retorna a descrição <code>discription</code> do produto.
	 * @return discription
	 */
	String getDiscription();
	
	/**
	 * Retorna o estado do produto.
	 * @return <code>SALE</code>, <code>AUCTION</code> ou <code>SOLD</code>
	 */
	String getStatus();
	
	/**
	 * Retorna o leilão correspondente ao produto.
	 * @return auction caso já tenha sido posto à venda ou NULL caso contrario. 
	 */
	Auction getAuction();
	
	/**
	 * Retorna o USER que criou o produto.
	 * @return user
	 */
	User getUser();
	
	/**
	 * Adiciona a AUCTION ao produto quando este é posto à venda.
	 * @param auction
	 */
	void addAuction(Auction auction);
	
	/**
	 * Altera o estado do produto quando este é vendido.
	 */
	void setAsSold();
	
	/**
	 * Altera o estado do produto quando este não é vendido e deixa de estar em leilão.
	 */
	void setAsSale();
	
	/**
	 * Remove a auction quando o produto não é vendido e deixa de estar em leilão.
	 */
	void removeAuction();
}
