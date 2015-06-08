// This is an Academic Project, and was published after finishing the lecture.
// @author Joao Elvas @ FCT/UNL


import java.util.Iterator;
import java.util.Scanner;

import ebay.*;


/**
 * @author João Elvas - MIEI - 41934 
 */

public class Main {
	
	private static final String THERE_IS_A_USER_LOGGED_IN = "There is a user logged in.\n";
	private static final String CANNOT_VIEW_BIDS = "Cannot view bids.\n";
	private static final String ALL_PRODUCTS = "All products:";
	private static final String ANOTHER_USER_IS_LOGGED_IN = "Another user is logged in.\n";
	private static final String USER_ALREADY_LOGGED_IN = "User is already logged in.\n";
	private static final String EXIT = "Exiting...\n";
	private static final String ALL_USERS = "All users:";
	private static final String USER_DOES_NOT_EXIST = "User does not exist.\n";
	private static final String NEW_ADMIN_REGISTERED = "New admin registered.\n";
	private static final String NEW_USER_REGISTERED = "New user registered.\n";
	private static final String USER_ALREADY_EXISTS = "User already exists.\n";
	private static final String SALES_BY_USERS = "Sales by users:";
	private static final String USER = " USER";
	private static final String ADMIN = " ADMIN";
	private static final String ALL_BIDS = "All bids:";
	private static final String NO_USER_IS_LOGGED_IN = "No user is logged in.\n";
	private static final String NO_ADMIN_IS_LOGGED_IN = "No admin is logged in.\n";
	private static final String PRODUCT_NOT_SOLD = "Product not sold.";
	private static final String NEW_AUCTION_ADDED = "New auction added.\n";
	private static final String PRODUCT_NOT_AVAILABLE = "Product not available.\n";
	private static final String PRODUCT_DOES_NOT_EXIST = "Product does not exist.\n";
	private static final String WINNIG_BID = "Winning bid: ";
	private static final String BID_ACCEPTED = "Bid accepted.\n";
	private static final String BID_NOT_ACCEPTED = "Bid not accepted.\n";
	private static final String CANNOT_BID_IN_AUCTION = "Cannot bid in auction.\n";
	private static final String AUCTION_DOES_NOT_EXIST = "Auction does not exist.\n";
	private static final String NEW_PRODUCT_ADDED = "New product added.\n";
	private static final String PRODUCT_CODE_ALREADY_EXISTS = "Product code already exists.\n";
	private static final String TABLETS_BY_DIMENSION = "Tablets by dimension:";
	private static final String ALL_TABLETS = "All tablets:";
	private static final String ALL_CARS = "All cars:";
	private static final String NOTHING_TO_LIST = "Nothing to list.";

	private enum Command {
		CARS, ALL, TABLETS, DIMENSION, REGISTER, USER, ADMIN, LOGIN, LOGOUT, LIST, SALES, ADD, CAR, TABLET, AUCTION, STANDARD, PLAFOND, BID, 
		CLOSE, PRODUCTS, BIDDINGS, EXIT, UNKNOWN
	}
	
	private static Command getCommand(Scanner in) { 
		 try { 
		 String comm = in.next().toUpperCase(); 
		 return Command.valueOf(comm); 
		 } catch (IllegalArgumentException e) { 
		 return Command.UNKNOWN; 
		 } 
	}

	private static void carsAll(Scanner in, Ebay e) {
		
		if(!e.hasCars()) {
			System.out.println(NOTHING_TO_LIST);
		} else {
			System.out.println(ALL_CARS);
			Iterator<Auction> a = e.carsAll();
			while(a.hasNext()) {
				Auction b = a.next();
				Car c = (Car) b.getProduct();
				System.out.println(c.getUser().getUsername() + " " + c.getCode() + " " + c.getBrand() + " " 
				+ c.getModel() + " " + c.getYear() + " " + b.getStartingValue() + " " 
				+ b.getCurrentValue());
			}
		}
		System.out.println();
		
	}
	
	private static void tabletsAll(Scanner in, Ebay e) {
		
		if(!e.hasTablets()) {
			System.out.println(NOTHING_TO_LIST);
		} else {
			System.out.println(ALL_TABLETS);
			Iterator<Auction> a = e.tabletsAll();
			while(a.hasNext()) {
				Auction b = a.next();
				Tablet c = (Tablet) b.getProduct();
				System.out.println(c.getUser().getUsername() + " " + c.getCode() + " " + c.getBrand() + " " 
				+ c.getDimension() + " " + c.getWeight() + " " + b.getStartingValue() + " " 
				+ b.getCurrentValue());
			}
		}
		System.out.println();
	}
	
	private static void tabletsDimension(Scanner in, Ebay e) {
		int dimension = in.nextInt();
		in.nextLine();
		
		if(!e.hasTabletsForDimension(dimension)) {
			System.out.println(NOTHING_TO_LIST);
			System.out.println();
		} else {
			System.out.println(TABLETS_BY_DIMENSION);
			System.out.println(dimension);
			Iterator<Tablet> a = e.listByDimension(dimension);
			while(a.hasNext()) {
				Tablet b = a.next();
				System.out.println(b.getUser().getUsername() + " " + b.getCode() + " " 
				+ b.getBrand()+ " " + b.getDimension() + " " + b.getWeight() + " "
				+ b.getAuction().getStartingValue() + " " + b.getAuction().getCurrentValue());
			}
			System.out.println();
		}
		
		
	}
	
	private static void addUser(Scanner in, Ebay e) {
		String username = in.next();
		in.nextLine();
		String name = in.nextLine();
		String email = in.next();
		in.nextLine();
		
		if(e.hasUser(username) || e.hasAdmin(username)) {
			System.out.println(USER_ALREADY_EXISTS);
		} else {
			e.registerUser(username, name, email);
			System.out.println(NEW_USER_REGISTERED);
		}
	}
	
	private static void addAdmin(Scanner in, Ebay e) {
		String username = in.next();
		in.nextLine();
		String name = in.nextLine();
		String email = in.next();
		in.nextLine();
		
		if(e.hasUser(username) || e.hasAdmin(username)) {
			System.out.println(USER_ALREADY_EXISTS);
		} else {
			e.registerAdmin(username, name, email);
			System.out.println(NEW_ADMIN_REGISTERED);
		}
	}
	
	private static void addCar(Scanner in, Ebay e, String user) {
		String code = in.next();
		in.nextLine();
		String discription = in.nextLine();
		String brand = in.next();
		String model = in.next();
		int year = in.nextInt();
		in.nextLine();
		
		if(e.hasProductCode(user, code)) {
			System.out.println(PRODUCT_CODE_ALREADY_EXISTS);
		} else {
			System.out.println(NEW_PRODUCT_ADDED);
			e.addCar(user, code, discription, brand, model, year);
		}
	}
	
	private static void addTablet(Scanner in, Ebay e, String user) {
		String code = in.next();
		in.nextLine();
		String discription = in.nextLine();
		String brand = in.next();
		int dimension = in.nextInt();
		int weight = in.nextInt();
		in.nextLine();
		
		if(e.hasProductCode(user, code)) {
			System.out.println(PRODUCT_CODE_ALREADY_EXISTS);
		} else {
			System.out.println(NEW_PRODUCT_ADDED);
			e.addTablet(user, code, discription, brand, dimension, weight);
		}
	}
	
	private static void addBid(Scanner in, Ebay e, String user) {
		String sellerUsername = in.next();
		String code = in.next();
		int value = in.nextInt();
		in.nextLine();
		
		if(!e.hasAuction(code) || !e.isOpen(code)) {
			System.out.println(AUCTION_DOES_NOT_EXIST);
		} else if(e.isHisOwnAuction(user, code)) {
			System.out.println(CANNOT_BID_IN_AUCTION);
		} else if(e.valueIsLowerThanBasePrice(code, value)) {
			System.out.println(BID_NOT_ACCEPTED);
		} else if(e.wonPlafondAuction(code, value)){
			e.makeABid(user, sellerUsername, code, value);
			e.closeAuction(sellerUsername, code);
			System.out.println(WINNIG_BID + e.getHigherBid(code).getBidder().getUsername() + " " + e.getHigherBid(code).getBidValue());
			System.out.println();
		} else {			
			e.makeABid(user, sellerUsername, code, value);
			System.out.println(BID_ACCEPTED);
		}
	}
	
	private static void auctionStandard(Scanner in, Ebay e, String user) {
		String code = in.next();
		int baseValue = in.nextInt();
		in.nextLine();
		
		if(!e.hasProductCode(user, code)) {
			System.out.println(PRODUCT_DOES_NOT_EXIST);
		} else if(e.hasAuction(code)) {
			System.out.println(PRODUCT_NOT_AVAILABLE);
		} else {
			System.out.println(NEW_AUCTION_ADDED);
			e.openStandardAuction(user, code, baseValue);
		}
	}
	
	private static void auctionPlafond(Scanner in, Ebay e, String user) {
		String code = in.next();
		int baseValue = in.nextInt();
		int plafondValue = in.nextInt();
		in.nextLine();
		
		if(!e.hasProductCode(user, code)) {
			System.out.println(PRODUCT_DOES_NOT_EXIST);
		} else if(e.hasAuction(code)) {
			System.out.println(PRODUCT_NOT_AVAILABLE);
		} else {
			System.out.println(NEW_AUCTION_ADDED);
			e.openPlafondAuction(user, code, baseValue, plafondValue);
		}
	}
	
	private static void closeAuction(Scanner in, Ebay e, String user) {
		String code = in.next();
		in.nextLine();
		
		if(!e.hasAuction(code, user)) {
			System.out.println(AUCTION_DOES_NOT_EXIST);
		} else if(!e.auctionHasBids(code)) {
			System.out.println(PRODUCT_NOT_SOLD);
			e.closeAuction(user, code);
			System.out.println();
		} else {
			e.closeAuction(user, code);
			System.out.println(WINNIG_BID + e.getHigherBid(code).getBidder().getUsername() + " " + e.getHigherBid(code).getBidValue());
			System.out.println();
		}
		
	}
	
	private static void listUserProducts(Scanner in, Ebay e, String user) {
		
		if(!e.hasProducts(user)) {
			System.out.println(NOTHING_TO_LIST);
		} else {
			Iterator<Product> a = e.listUserProducts(user);
			System.out.println(ALL_PRODUCTS);
			while(a.hasNext()) {
				Product b = (Product) a.next();
				System.out.println(b.getCode() + " " + b.getDiscription() + " " + e.getProductState(b.getCode()));
				
			}
		}
		System.out.println();
		
	}
	
	private static void listUserBids(Scanner in, Ebay e, String user) {
		String sellerUsername = in.next();
		String productCode = in.next();
		in.nextLine();
		
		if(!e.hasAuction(productCode)) {
			System.out.println(AUCTION_DOES_NOT_EXIST);
		} else if(e.getAuction(productCode).isOpen() && !e.getProduct(productCode).getUser().getUsername().equals(user)) {
			System.out.println(CANNOT_VIEW_BIDS);
		} else if(!e.hasBids(productCode)) { 
			System.out.println(NOTHING_TO_LIST);
			System.out.println();
		} else {
			System.out.println(ALL_BIDS);
			System.out.println(e.getProduct(productCode).getUser().getUsername() + " " + e.getProduct(productCode).getCode());			
			Iterator<Bid> a = e.listUserBids(sellerUsername, productCode);
			while(a.hasNext()) {
				Bid b = a.next();
				System.out.println(b.getBidder().getUsername() + " " + b.getBidValue());
			}
			System.out.println();
			}
		
	}
	
	private static void listAllUsers(Scanner in, Ebay e) {
		Iterator<User> a = e.listAllUsers();
		System.out.println(ALL_USERS);
		while(a.hasNext()) {
			User b = a.next();
			if(b instanceof UserAdminClass) {
			System.out.println(b.getUsername() + " " + b.getName() + " " + b.getEmail() + ADMIN);
			}
		}
		Iterator<User> c = e.listAllUsers();
		while(c.hasNext()) {
			User b = c.next();
			if(b instanceof UserRegularClass) {
				System.out.println(b.getUsername() + " " + b.getName() + " " + b.getEmail() + USER);
			}
		}
		System.out.println();
	}
	
	private static void sales(Scanner in, Ebay e) {
		Iterator<User> a = e.listAllUsersSales();
		System.out.println(SALES_BY_USERS);
		while(a.hasNext()) {
			User b = a.next();
			System.out.println(b.getUsername() + " " + b.getName() + " " + b.getEmail() + " " + 
			b.getTotalNumberOfSells() + " " + b.getSellingsTotal());
		}
		System.out.println();
	}
	
	private static void login(Scanner in, Ebay e) {
		String user = in.next();
		in.nextLine();
		if(e.isAdmin(user)) {
			adminMenu(in, e, user);
		} else if(e.isUser(user)) {
			userMenu(in, e, user);
		} else System.out.println(USER_DOES_NOT_EXIST);
		

	}
	
	@SuppressWarnings("incomplete-switch")
	private static void adminMenu(Scanner in, Ebay e, String admin) {
		System.out.println("Welcome " + admin + ".\n");
		Command c = getCommand(in);

			while(!c.equals(Command.LOGOUT)) {
				switch(c) {
				case EXIT 		: System.exit(0);
					break;
				case CARS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : carsAll(in,e);
					default: 
						break;
					}
					break; 
				case TABLETS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : tabletsAll(in,e);
						break;
					case DIMENSION : tabletsDimension(in,e);
						break;
					default: 
						break;
					}
					break; 
				case REGISTER 		: 
					c = getCommand(in);
					switch(c) {
					case USER : addUser(in, e);
						break;
					case ADMIN : addAdmin(in, e);
						break;
					default: 
						break;
					}
					break;
				case LIST : 
					c = getCommand(in);
					switch(c) {
					case ALL : listAllUsers(in, e);
					default: 
						break;
					}
					break; 
				case SALES : sales(in, e);
					break;
				case LOGIN : {
					String admin1 = in.next();
					if(admin.equals(admin1)) {
						System.out.println(USER_ALREADY_LOGGED_IN);
					} else System.out.println(ANOTHER_USER_IS_LOGGED_IN);
				}
					break;
				case ADD :
					c = getCommand(in);
					switch(c) {
					case CAR :
					case TABLET :
					case BID :
					}
				case AUCTION : 
					c = getCommand(in);
					switch(c) {
					case STANDARD : 
					case PLAFOND :
					}
				case CLOSE :
				case PRODUCTS :
				case BIDDINGS : System.out.println(NO_USER_IS_LOGGED_IN);
				default:
					break;
				}
				c = getCommand(in);
			}
		System.out.println("Goodbye " + admin + ".\n");

	}	

	@SuppressWarnings("incomplete-switch")
	private static void userMenu(Scanner in, Ebay e, String user) {
		System.out.println("Welcome " + user + ".\n");
		Command c = getCommand(in);
			while(!c.equals(Command.LOGOUT)) {
				switch(c) {
				case CARS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : carsAll(in,e);
					default: 
						break;
					}
					break;
				case EXIT 		: System.exit(0);
					break;
				case TABLETS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : tabletsAll(in,e);
						break;
					case DIMENSION : tabletsDimension(in,e);
						break;
					default: 
						break;
					}
					break; 
				case REGISTER 		: 
					c = getCommand(in);
					switch(c) {
					case USER : addUser(in, e);
						break;
					case ADMIN : System.out.println(THERE_IS_A_USER_LOGGED_IN);
						break;
					default: 
						break;
					}
					break;
				case LOGIN : {
					String user1 = in.next();
					if(user.equals(user1)) {
						System.out.println(USER_ALREADY_LOGGED_IN);
					} else System.out.println(ANOTHER_USER_IS_LOGGED_IN);
				}
					break;
				case ADD :
					c = getCommand(in);
					switch(c) {
					case CAR : addCar(in, e, user);
						break;
					case TABLET : addTablet(in, e, user);
						break;
					case BID : addBid(in, e, user);
					default: 
						break;
					}
					break;
				case AUCTION : 
					c = getCommand(in);
					switch(c) {
					case STANDARD : auctionStandard(in, e, user);
						break;
					case PLAFOND : auctionPlafond(in, e, user);
						break;
					default: 
						break;
					}
					break;
				case CLOSE : closeAuction(in, e, user);
					break;
				case PRODUCTS : listUserProducts(in, e, user);
					break;
				case BIDDINGS : listUserBids(in, e, user);
					break;
				case LIST : 
					c = getCommand(in);
					switch(c) {
					case ALL :
					}
				case SALES : System.out.println(NO_ADMIN_IS_LOGGED_IN);
					break;
				default:
					break;
					
				}
				c = getCommand(in);
			}
		
		System.out.println("Goodbye " + user + ".\n");

	}
	
	@SuppressWarnings("incomplete-switch")
	public static void main(String[] args) {

		Ebay e = new EbayClass();
		Scanner in = new Scanner(System.in);
		Command c = getCommand(in); 
		while (!c.equals(Command.EXIT)) { 
			switch (c) {  
				case CARS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : carsAll(in,e);
					default: 
						break;
					}
					break; 
				case TABLETS 		: 
					c = getCommand(in);
					switch(c) {
					case ALL : tabletsAll(in,e);
						break;
					case DIMENSION : tabletsDimension(in,e);
						break;
					default: 
						break;
					}
					break; 
				case REGISTER 		: 
					c = getCommand(in);
					switch(c) {
					case USER : addUser(in, e);
						break;
					case ADMIN : addAdmin(in, e);
						break;
					default: 
						break;
					}
					break;
				case LOGIN : login(in, e);
					break;
				case ADD :
					c = getCommand(in);
					switch(c) {
					case CAR :
					case TABLET :
					case BID :
					}
				case AUCTION : 
					c = getCommand(in);
					switch(c) {
					case STANDARD : 
					case PLAFOND :
					}
				case CLOSE :
				case PRODUCTS :
				case LOGOUT :
				case BIDDINGS : System.out.println(NO_USER_IS_LOGGED_IN);
					break;
				case LIST : 
					c = getCommand(in);
					switch(c) {
					case ALL :
					}
				case SALES : System.out.println(NO_ADMIN_IS_LOGGED_IN);
					break;
				}
			c = getCommand(in);
			} 
			
			
			System.out.println(EXIT);
		 }
}
