// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class BidClass implements Bid {
	
	private User bidder;
	private int bidValue;

	public BidClass(User bidder, int bidValue) {
		this.bidder = bidder;
		this.bidValue = bidValue;
	}

	@Override
	public User getBidder() {
		return bidder;
	}

	@Override
	public int getBidValue() {
		return bidValue;
	}
}
