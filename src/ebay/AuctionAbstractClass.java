// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class AuctionAbstractClass implements Auction, Comparable<Auction> {

	protected Product product;
	protected int value, startingValue;
	protected boolean isOpen;
	protected Bid higherBid;
	
	public AuctionAbstractClass(Product product, int startingValue) {
		this.product = product;
		this.isOpen = true;
		this.startingValue = startingValue;
		this.value = 0;
		higherBid = null;
	}

	public boolean isOpen() {
		return isOpen;
	}
	
	@Override
	public Product getProduct() {
		return product;
	}

	@Override
	public int getStartingValue() {
		return startingValue;
	}

	@Override
	public int getCurrentValue() {
		return value;
	}

	@Override
	public void closeAuction() {
		this.isOpen = false;
		product.getUser().addSell(value);
	}
	
	@Override
	public void addToCurrentValue(int value) {
		if(this.value < value) {
			this.value = value;
		}
		
	}

	@Override
	public int compareTo(Auction o) {
		return this.getStartingValue() - o.getStartingValue();
	}


}
