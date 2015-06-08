// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Tablet {
	
	/**
	 * Retorna a marca do tablet/produto.
	 * @return brand
	 */
	String getBrand();
	
	/**
	 * Retorna a dimensão do tablet/produto.
	 * @return
	 */
	int getDimension();
	
	/**
	 * Retorna o peso do tablet/produto.
	 * @return weight
	 */
	int getWeight();
	
	/**
	 * Retorna o codigo identificador do tablet/produto.
	 * @return code
	 */
	String getCode();
	
	/**
	 * Retorna a descrição do tablet/produto.
	 * @return discription
	 */
	String getDiscription();
	
	/**
	 * Retorna o estado do tablet/produto.
	 * @return <code>SALE</code>, <code>AUCTION</code> ou <code>SOLD</code>
	 */
	String getStatus();
	
	/**
	 * Retorna o leilão correspondente ao tablet/produto.
	 * @return auction caso já tenha sido posto à venda ou NULL caso contrario.
	 */
	Auction getAuction();
	
	/**
	 * Retorna o USER que criou o produto.
	 * @return user
	 */
	User getUser();
}
