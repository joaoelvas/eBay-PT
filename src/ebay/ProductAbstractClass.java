// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public abstract class ProductAbstractClass implements Product {

	
	private static final String SALE = "SALE";
	private static final String AUCTION = "AUCTION";
	private static final String SOLD = "SOLD";
	protected String code, discription, status;
	protected User user;
	protected Auction auction;
	
	
	public ProductAbstractClass(User user, String code, String discription) {
		this.code = code;
		this.discription = discription;
		this.status = SALE;
		this.auction = null;
		this.user = user;
	}
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getDiscription() {
		return discription;
	}
	
	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public Auction getAuction() {
		return auction;
	}
	
	public User getUser() {
		return user;
	}
	
	public void addAuction(Auction auction) {
		this.auction = auction;
		this.status = AUCTION;
	}
	
	public void setAsSold() {
		status = SOLD;
	}
	
	public void setAsSale() {
		status = SALE;
	}
	
	public void removeAuction() {
		auction = null;
	}
}
