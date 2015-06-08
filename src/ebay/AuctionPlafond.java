// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class AuctionPlafond extends AuctionAbstractClass {

	protected int wantedValue;
	
	public AuctionPlafond(Product product, int startingValue, int wantedValue) {
		super(product, startingValue);
		this.wantedValue = wantedValue;
	}
	
	public int getWantedValue() {
		return wantedValue;
	}

	@Override
	public int hashCode() {
		return this.product.getCode().hashCode();
	}
}
