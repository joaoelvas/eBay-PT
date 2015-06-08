// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

import java.util.Iterator;

/**
 * @author João Elvas - MIEI - 41934 
 */

public interface Ebay {
	
	/**
	 * @return <code>true</code> se estiver um USER com login efetuado, <code>false</code> caso contrario.
	 */
	boolean userLoggedIn();
	
	/**
	 * @return <code>true</code> se estiver um ADMIN com login efetuado, <code>false</code> caso contrario.
	 */
	boolean adminLoggedIn();

	/**
	 * @return <code>true</code> se existirem CARS listados, <code>false</code> caso contrario.
	 */
	boolean hasCars();
	
	/**
	 * @return <code>true</code> se existirem TABLETS listados, <code>false</code> caso contrario.
	 */
	boolean hasTablets();
	
	/**
	 * @param dim
	 * @return <code>true</code> se existirem TABLETS listados com dimensão <= a <code>dim</code>, <code>false</code> caso contrario.
	 */
	boolean hasTabletsForDimension(int dim);
	
	/**
	 * @param admin
	 * @return <code>true</code> se o <code>admin</code> for do tipo ADMIN, <code>false</code> caso contrario.
	 */
	boolean isAdmin(String admin);
	
	/**
	 * @param user
	 * @return <code>true</code> se o <code>user</code> for do tipo USER, <code>false</code> caso contrario.
	 */
	boolean isUser(String user);
	
	/**
	 * @param user
	 * @return <code>true</code> se o USER já tiver sido criado, <code>false</code> caso contrario.
	 */
	boolean hasUser(String user);
	
	/**
	 * @param admin
	 * @return <code>true</code> se o ADMIN já tiver sido criado, <code>false</code> caso contrario.
	 */
	boolean hasAdmin(String admin);
	
	/**
	 * @param user
	 * @param code
	 * @return <code>true</code> se o produto correspondente ao codigo existir, <code>false</code> caso contrario.
	 */
	boolean hasProductCode(String user, String code);
	
	/**
	 * @param code
	 * @return <code>true</code> se o produto correspondente ao codigo <code>code</code> estiver em <code>auctionMap</code>, <code>false</code> caso contrario.
	 */
	boolean hasAuction(String code);
	
	/**
	 * @param code
	 * @param user
	 * @return <code>true</code> se o produto correspondente ao codigo <code>code</code> estiver na lista de auction do USER <code>user</code>, <code>false</code> caso contrario.
	 */
	boolean hasAuction(String code, String user);
	
	/**
	 * @param user
	 * @param code
	 * @return <code>true</code> caso a AUCTION tenha sido criada pelo USER <code>user</code>, <code>false</code> caso contrario.
	 */
	boolean isHisOwnAuction(String user, String code);
	
	/**
	 * @param code
	 * @param value
	 * @return <code>true</code> se o valor <code>value</code> for menor que o valor base da AUCTION, <code>false</code> caso contrario.
	 */
	boolean valueIsLowerThanBasePrice(String code, int value);
	
	/**
	 * @param code
	 * @param value
	 * @return <code>true</code> , caso o valor do BID seja igual ou superior ao valor do plafond da AUCTION <code>false</code> caso contrario ou se a AUCTION não for do tipo PLAFOND.
	 */
	boolean wonPlafondAuction(String code, int value);
	
	/**
	 * @param code
	 * @return <code>true</code> se a AUCTION já tiver sido licitada, <code>false</code> caso contrario.
	 */
	boolean auctionHasBids(String code);
	
	/**
	 * @param username
	 * @return <code>true</code> se o USER <code>username</code> tiver criado algum produto, <code>false</code> caso contrario.
	 */
	boolean hasProducts(String username); 
	
	/**
	 * @param code
	 * @return <code>true</code> se PRODUCT <code>code</code> tiver BIDS, <code>false</code> caso contrario.
	 */
	boolean hasBids(String code);
	
	/**
	 * @param code
	 * @return <code>true</code> se a AUCTION <code>code</code> estiver aberta, <code>false</code> caso contrario.
	 */
	boolean isOpen(String code);
	
	/**
	 * Retorna o estado do produto.
	 * @param code
	 * @return estado do produto.
	 */
	String getProductState(String code);
	
	/**
	 * Retorna o leilão de um certo produto.
	 * @param code
	 * @return AUCTION correspondente ao produto <code>code</code>.
	 */
	Auction getAuction(String code);
	
	/**
	 * Retorna a ultima licitação no produto correspondente ao <code>code</code>.
	 * @param code
	 * @return ultimo BID da Auction <code>code</code>.
	 */
	Bid getHigherBid(String code);
	
	/**
	 * Retorna um iterador de AUCTION com todos os carros listados em leilão.
	 * @return iterator de CAR.
	 */
	Iterator<Auction> carsAll();
	
	/**
	 * Retorna um iterador de AUCTION com todos os tablets listados em leilão.
	 * @return iterador de Auction.
	 */
	Iterator<Auction> tabletsAll();
	
	/**
	 * Retorna um iterado com todos os USER já registados
	 * @return iterador de USER.
	 */
	Iterator<User> listAllUsers();
	
	/**
	 * Retorna um iterador de uma lista de todos os produtos de um USER.
	 * @param user
	 * @return Iterador de PRODUCT.
	 */
	Iterator<Product> listUserProducts(String user);
	
	/**
	 * Retorna um iterador de uma lista com todos os bids de um certo producto.
	 * @param sellerUsername
	 * @param productCode
	 * @return Iterador de BID.
	 */
	Iterator<Bid> listUserBids(String sellerUsername, String productCode);
	
	/**
	 * Retorna um iterador de uma lista de tablets com dimensão menor ou igual a <code>dimension</code>
	 * @param dimension
	 * @return Iterador de TABLET.
	 */
	Iterator<Tablet> listByDimension(int dimension);
	
	/**
	 * Retorna um iterador de uma lista users ordenado por numero de vendas.
	 * @return Iterador de USER.
	 */
	Iterator<User> listAllUsersSales();
	
	/**
	 * Cria um novo <code>user</code> no sistema.
	 * @param username
	 * @param name
	 * @param email
	 */
	void registerUser(String username, String name, String email);
	
	/**
	 * Cria um novo <code>admin</code> no sistema.
	 * @param username
	 * @param name
	 * @param email
	 */
	void registerAdmin(String username, String name, String email);
	
	/**
	 * Efetua login no sistema.
	 * @param username
	 */
	void login(String username);
	
	/**
	 * Efectua logout no sistema.
	 * @param username
	 */
	void logout(String username);
	
	/**
	 * Adiciona um carro à lista de produtos do user.
	 * @param user
	 * @param code
	 * @param discription
	 * @param brand
	 * @param model
	 * @param year
	 */
	void addCar(String user, String code, String discription, String brand, String model, int year);
	
	/**
	 * Adiciona um tablet à lista de produtos do user.
	 * @param user
	 * @param code
	 * @param discription
	 * @param brand
	 * @param dimension
	 * @param weight
	 */
	void addTablet(String user, String code, String discription, String brand, int dimension, int weight);
	
	/**
	 * Cria um leilão do tipo STANDARD para o produto identificado por <code>productCode</code>.
	 * @param productCode
	 * @param baseValue
	 */
	void openStandardAuction(String user, String productCode, int baseValue);
	
	/**
	 * Cria um leilão do tipo PLAFOND para o produto identificado por <code>productCode</code>.
	 * @param productCode
	 * @param baseValue
	 * @param plafondValue
	 */
	void openPlafondAuction(String user, String productCode, int baseValue, int plafondValue);
	
	/**
	 * Efectua uma licitação no leilão identificado por <code>productCode</code>.
	 * @param sellerUsername
	 * @param productCode
	 * @param bidValue
	 */
	void makeABid(String buyerUsername, String sellerUsername, String productCode, int bidValue);
	
	/**
	 * Fecha o leilão correspondente ao produto identificado por <code>productCode</code>.
	 * @param user
	 * @param productCode
	 */
	void closeAuction(String user, String productCode);
	
	/**
	 * Retorna o User correspondente ao <code>username</code>
	 * @param username
	 * @return user
	 */
	User getUser(String username);

	/**
	 * Retorna o produto que corresponde a code.
	 * @param code
	 * @return product
	 */
	Product getProduct(String code);
}
