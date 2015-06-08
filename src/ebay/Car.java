// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Car {

	/**
	 * Retorna a marca do carro.
	 * @return brand
	 */
	String getBrand();
	
	/**
	 * Retorna o modelo do carro.
	 * @return model
	 */
	String getModel();
	
	/**
	 * Retorna o ano de matricula do carro.
	 * @return year
	 */
	int getYear();
	
	/**
	 * retorna o codigo identificador do carro/produto.
	 * @return code
	 */
	String getCode();
	
	/**
	 * Retorna a descrição do carro/produto.
	 * @return discription
	 */
	String getDiscription();
	
	/**
	 * Retorna o estado do carro/produto.
	 * @return <code>SALE</code>, <code>AUCTION</code> ou <code>SOLD</code>
	 */
	String getStatus();
	
	/**
	 * Retorna o leilão correspondente ao carro/produto.
	 * @return auction caso já tenha sido posto à venda ou NULL caso contrario.
	 */
	Auction getAuction();
	
	/**
	 * Retorna o USER que criou o produto.
	 * @return user
	 */
	User getUser();
}
