// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL

package ebay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * @author João Elvas - MIEI - 41934 
 */

public class EbayClass implements Ebay {

	private boolean userLogin, adminLogin;
	private Map<String, User> usersMap;
	private Map<User, List<Product>> productsMap;
	private Map<Auction, List<Bid>> auctionMap;
	

		
	public EbayClass() {
		userLogin = adminLogin = false;
		productsMap = new TreeMap<User, List<Product>>();
		auctionMap = new TreeMap<Auction, List<Bid>>();
		usersMap = new TreeMap<String, User>();
	}

	@Override
	public boolean userLoggedIn() {
		return userLogin;
	}

	@Override
	public boolean adminLoggedIn() {
		return adminLogin;
	}

	@Override
	public boolean hasCars() {
		for(User user : productsMap.keySet()) {
			List<Product> list = productsMap.get(user);
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i) instanceof CarClass) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasTablets() {
		Set<Auction> setOfAuctions = auctionMap.keySet();
		ArrayList<Auction> listOfAuctions = new ArrayList<Auction>(setOfAuctions);
		int counter = 0;
		for(int i = 0; i < listOfAuctions.size(); i++) {
			if(listOfAuctions.get(i).getProduct() instanceof TabletClass) {
				counter++;
			}
		}
		return counter > 0;
	}
	
	public boolean hasTabletsForDimension(int dim) {
		Set<Auction> setOfAuctions = auctionMap.keySet();
		ArrayList<Auction> listOfAuctions = new ArrayList<Auction>(setOfAuctions);
		int counter = 0;
		for(int i = 0; i < listOfAuctions.size(); i++) {
			if(listOfAuctions.get(i).getProduct() instanceof TabletClass) {
				Tablet tablet = (Tablet) listOfAuctions.get(i).getProduct();
				if(tablet.getDimension() <= dim) {
					counter++;
				}
			}
		}
		return counter > 0;
	}

	@Override
	public boolean isAdmin(String admin) {
		if(usersMap.get(admin) instanceof UserAdminClass) 
			return true;
		else return false;
	}

	@Override
	public boolean isUser(String user) {
		if(usersMap.get(user) instanceof UserRegularClass) 
			return true;
		else return false;
	}

	@Override
	public boolean hasUser(String user) {
		if(usersMap.get(user) instanceof UserRegularClass) 
			return true;
		else return false;
	}

	@Override
	public boolean hasAdmin(String admin) {
		if(usersMap.get(admin) instanceof UserAdminClass) 
			return true;
		else return false;
	}

	@Override
	public boolean hasProductCode(String user, String code) {
		List<Product> list = productsMap.get(new UserRegularClass(user, null, null));
		if(list.contains(new CarClass(null, code, null, null, null, 0))) {
			return true;
		} else if(list.contains(new TabletClass(null, code, null, null, 0, 0))) {
			return true;
		} else return false;
	}

	@Override
	public boolean hasAuction(String code) {
		if(getProduct(code) == null) {
			return false;
		}
		if(getProduct(code).getAuction() == null) {
			return false;
		} else {
			return auctionMap.containsKey(getProduct(code).getAuction());
		}
	}
	
	@Override
	public boolean hasAuction(String code, String user) {
		if(getProduct(code) == null) {
			return false;
		}
		if(getProduct(code).getAuction() == null) {
			return false;
		} else {
			return auctionMap.containsKey(getProduct(code).getAuction()) && getProduct(code).getUser().getUsername().equals(user)
					;//&& (getProduct(code).getUser().getName().compareTo(user) == 0);
		}
	}

	@Override
	public boolean isHisOwnAuction(String user, String code) {
		List<Product> list = productsMap.get(usersMap.get(user));
		
		if(list.contains(new TabletClass(null, code, null, null, 0, 0)) || list.contains(new CarClass(null, code, null, null, null, 0)))
			return true;
		else return false;
	}

	@Override
	public boolean valueIsLowerThanBasePrice(String code, int value) {
		Product product = getProduct(code);
		return product.getAuction().getStartingValue() > value;
	}

	@Override
	public boolean wonPlafondAuction(String code, int value) {
		if(getAuction(code) instanceof AuctionStandard) {
			return false;
		} 
		AuctionPlafond auction = (AuctionPlafond) getAuction(code);
		if(auction.getWantedValue() <= value) {
			return true;
		} else return false;
	}

	@Override
	public boolean auctionHasBids(String code) {
		return !(auctionMap.get(getAuction(code)).isEmpty());
	}

	@Override
	public boolean hasProducts(String username) {
		return !(productsMap.get(new UserRegularClass(username, null, null)).isEmpty());
	}
	
	@Override
	public boolean hasBids(String code) {
		return auctionMap.get(getProduct(code).getAuction()).size() > 0;
	}

	@Override
	public boolean isOpen(String code) {
		return getProduct(code).getAuction().isOpen();
	}

	@Override
	public String getProductState(String code) {
		return getProduct(code).getStatus();
	}

	@Override
	public Auction getAuction(String code) {
		return getProduct(code).getAuction();
	}

	@Override
	public Bid getHigherBid(String code) {
		List<Bid> list = auctionMap.get(getAuction(code));
		Bid bid = null;
		for(int i = 0; i < list.size(); i++) {
			if(bid == null) {
				bid = list.get(i);
			} else if(bid.getBidValue() < list.get(i).getBidValue()) {
				bid = list.get(i);
			}
			
		}
		return bid;
	}

	@Override
	public Iterator<Auction> carsAll() {
		List<Auction> list = new ArrayList<Auction>();
		
		for(List<Product> products : productsMap.values()) {
			for(Product p : products) {
				if(p instanceof Car) {
					Car car = (Car) p;
					if(car.getAuction() != null)
						list.add(car.getAuction());
				}
			}
		}
		Collections.sort(list, new Comparator<Auction>() {
			@Override
			public int compare(Auction o1, Auction o2) {
				return o1.getStartingValue() - o2.getStartingValue();
			}
		});
		return list.iterator();
	}

	@Override
	public Iterator<Auction> tabletsAll() {
		List<Auction> list = new ArrayList<Auction>();
		
		for(List<Product> products : productsMap.values()) {
			for(Product p : products) {
				if(p instanceof Tablet) {
					Tablet tablet = (Tablet) p;
					if(tablet.getAuction() != null)
						list.add(tablet.getAuction());
				}
			}
		}
		
		Collections.sort(list, new Comparator<Auction>() {
			@Override
			public int compare(Auction o1, Auction o2) {
				return o1.getStartingValue() - o2.getStartingValue();
			}
		});
		return list.iterator();
	}

	
	@Override
	public Iterator<User> listAllUsers() {
		Set<User> users =  productsMap.keySet();
		List<User> list = new ArrayList<User>(users);
		Collections.sort(list);
		return list.iterator();
	}

	@Override
	public Iterator<Product> listUserProducts(String user) {
		User a = usersMap.get(user);
		List<Product> list = productsMap.get(a);
		
		
		Collections.sort(list, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getCode().compareTo(o2.getCode());
			}
		});
		
		return list.iterator();
	}

	@Override
	public Iterator<Bid> listUserBids(String sellerUsername, String productCode) {
		List<Product> list = productsMap.get(getUser(sellerUsername));
		int i = 0;
		if(list.contains(new TabletClass(null, productCode, null, null, 0, 0))) {
			i = list.indexOf(new TabletClass(null, productCode, null, null, 0, 0));
		} else if(list.contains(new CarClass(null, productCode, null, null, null, 0))) {
			i = list.indexOf(new CarClass(null, productCode, null, null, null, 0));
		}
		Auction auction = list.get(i).getAuction();
		List<Bid> list1 = auctionMap.get(auction);
		Collections.sort(list1, new Comparator<Bid>() {
			@Override
			public int compare(Bid o1, Bid o2) {
				return o2.getBidValue() - o1.getBidValue();
			}
		});
		
		return list1.iterator();
	}

	//amgs
	@Override
	public Iterator<Tablet> listByDimension(int dimension) {
		// Cria lista com resultados válidos
		List<Tablet> list = new ArrayList<Tablet>();
		
		// Percorre todas as listas do mapa
		for(List<Product> products : productsMap.values()){
			for(Product p : products){
				if(p instanceof Tablet){
					Tablet tablet = (Tablet)p;
					if(tablet.getDimension() <= dimension){
						list.add(tablet);
						if(tablet.getAuction() == null) {
							list.remove(tablet);
						} else if(!tablet.getAuction().isOpen()) {
							list.remove(tablet);
						}
					}
				}
			}
		}
		
		Collections.sort(list, new Comparator<Tablet>() {
			@Override
			public int compare(Tablet o1, Tablet o2) {
				return o1.getDimension() - o2.getDimension();
			}
		});
		
		return list.iterator();
	}

	@Override
	public Iterator<User> listAllUsersSales() {
		Set<User> users =  productsMap.keySet();
		List<User> list = new ArrayList<User>(users);
		for(int i = 0; i < list.size();i++) {
			if(list.get(i) instanceof UserAdminClass) {
				list.remove(i);
			}
		}
		
		Collections.sort(list);
		
		Collections.sort(list, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o2.getSellingsTotal() - o1.getSellingsTotal();
			}
		});
		return list.iterator();
	}

	@Override
	public void registerUser(String username, String name, String email) {
		User a = new UserRegularClass(username, name, email);
		productsMap.put(a, new ArrayList<Product>());
		usersMap.put(a.getUsername(), a);
	}

	@Override
	public void registerAdmin(String username, String name, String email) {
		User a = new UserAdminClass(username, name, email);
		productsMap.put(a, new ArrayList<Product>());
		usersMap.put(a.getUsername(), a);
	}

	@Override
	public void login(String username) {
		if(usersMap.get(username) instanceof UserAdminClass) {
			adminLogin = true;
		} else if(usersMap.get(username) instanceof UserRegularClass) {
			userLogin = true;
		}
	}

	@Override
	public void logout(String username) {
		if(adminLogin) {
			adminLogin = false;
		} else if(userLogin) {
			userLogin = false;
		}
		
	}

	@Override
	public void addCar(String user, String code, String discription,
			String brand, String model, int year) {
		User a = usersMap.get(user);
		Car b = new CarClass(a, code, discription, brand, model, year);
		productsMap.get(a).add((Product) b);
		
	}

	@Override
	public void addTablet(String user, String code, String discription,
			String brand, int dimension, int weight) {
		User a = usersMap.get(user);
		Tablet b = new TabletClass(a, code, discription, brand, dimension, weight);
		productsMap.get(a).add((Product) b);
		
	}

	@Override
	public void openStandardAuction(String user, String productCode, int baseValue) {
		Product c = getProduct(productCode);
		Auction d = new AuctionStandard(c, baseValue);
		auctionMap.put(d, new ArrayList<Bid>());
		c.addAuction(d);
	}

	@Override
	public void openPlafondAuction(String user, String productCode, int baseValue,
			int plafondValue) {
		Product c = getProduct(productCode);
		Auction d = new AuctionPlafond(c, baseValue, plafondValue);
		auctionMap.put(d, new ArrayList<Bid>());
		c.addAuction(d);
	}

	@Override
	public void makeABid(String buyerUsername, String sellerUsername, String productCode, int bidValue) {
		Bid a = new BidClass(usersMap.get(buyerUsername), bidValue); 
		Auction auction = getProduct(productCode).getAuction();
		if(!auctionMap.containsKey(auction)) {
			auctionMap.put(auction, new ArrayList<Bid>());
		}
		auctionMap.get(auction).add(a);
		auction.addToCurrentValue(bidValue);
	}

	@Override
	public void closeAuction(String user, String productCode) {
		User a = usersMap.get(user);
		Product b = getProduct(productCode);
		if(b.getUser().equals(a)) 
			b.getAuction().closeAuction();
		if(b.getAuction().getCurrentValue() > b.getAuction().getStartingValue()) {
			b.getAuction().getProduct().setAsSold();
		} else {
			b.getAuction().getProduct().setAsSale();
			b.getAuction().getProduct().removeAuction();
		}
	}

	@Override
	public User getUser(String username) {
		return usersMap.get(username);
	}

	@Override
	public Product getProduct(String code) {
		for(List<Product> products : productsMap.values()){
			for(Product p : products){
				if(p.getCode().equals(code)) {
					return p;
				}
			}
		}
		return null;
	}
}