// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

/**
 * @author João Elvas - MIEI - 41934 
 */

public class CarClass extends ProductAbstractClass implements Car {
	
	protected String brand, model;
	protected int year;
	
	public CarClass(User user, String code, String description, String brand, String model, int year) {
		super(user, code, description);
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public int getYear() {
		return year;
	}
	
	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		} else if(arg0 instanceof CarClass) {
			Car a = (Car) arg0;
			return this.getCode().equals(a.getCode());
		}
		return super.equals(arg0);
	}

	@Override
	public int compareTo(Product arg0) {
		return this.getCode().compareTo(arg0.getCode());
	}
	

}
