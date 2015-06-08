// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class AuctionStandard extends AuctionAbstractClass {
	
	
	public AuctionStandard(Product product, int startingValue) {
		super(product, startingValue);
	}

	@Override
	public int hashCode() {
		return this.product.getCode().hashCode();
	}
}
