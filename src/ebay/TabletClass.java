// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class TabletClass extends ProductAbstractClass implements Tablet {

	
	protected String brand;
	protected int dimension, weight;
	
	public TabletClass(User user, String code, String description, String brand, int dimension, int weight) {
		super(user, code, description);
		this.brand = brand;
		this.dimension = dimension;
		this.weight = weight;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public int getDimension() {
		return dimension;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		} else if(arg0 instanceof Tablet) {
			Tablet a = (Tablet) arg0;
			return this.getCode().equals(a.getCode());
		}
		return super.equals(arg0);
	}

	@Override
	public int compareTo(Product arg0) {
		return this.getCode().compareTo(arg0.getCode());
	}
}
