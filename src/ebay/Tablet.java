// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author Jo�o Elvas - MIEI - 41934 
 */

public interface Tablet {
	
	/**
	 * Retorna a marca do tablet/produto.
	 * @return brand
	 */
	String getBrand();
	
	/**
	 * Retorna a dimens�o do tablet/produto.
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
	 * Retorna a descri��o do tablet/produto.
	 * @return discription
	 */
	String getDiscription();
	
	/**
	 * Retorna o estado do tablet/produto.
	 * @return <code>SALE</code>, <code>AUCTION</code> ou <code>SOLD</code>
	 */
	String getStatus();
	
	/**
	 * Retorna o leil�o correspondente ao tablet/produto.
	 * @return auction caso j� tenha sido posto � venda ou NULL caso contrario.
	 */
	Auction getAuction();
	
	/**
	 * Retorna o USER que criou o produto.
	 * @return user
	 */
	User getUser();
}
