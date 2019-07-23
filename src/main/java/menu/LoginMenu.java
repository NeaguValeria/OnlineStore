package menu;

import model.Store;
import model.User;
import service.BuyService;
import service.LoginService;

import java.util.Scanner;
import java.util.logging.Logger;

public class LoginMenu extends AbstractMenu {

    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    private BuyService buyService;
    private Store store;

    public LoginMenu(Store store) {
        logger.info("bun venit in magazinul " + store.getName());
        this.store = store;
        this.buyService = new BuyService(store.getProducts());
    }

    @Override
    protected void displayOption() {
        System.out.println("LOGIN MENUE ");
        System.out.println(" 1 - Login");
        System.out.println(" 2 - Display Available Products");
        System.out.println(" 3 - Display Shopping Cart");
        System.out.println(" 4 - Buy Product");
        System.out.println(" 0 - Exit");
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println(" Enter your user ");
                String userId = scanner.nextLine();
                System.out.println(" Enter your password ");
                String password = scanner.nextLine();
                System.out.println(userId + " " + password);
                LoginService loginService = new LoginService();
                User user = loginService.login(userId, password);
                if (user != null) {
                    logger.info("Welcome " + " " + userId);
                    BuyMenu buyMenu = new BuyMenu(user, buyService);
                    buyMenu.displayMenu();
                } else {
                    logger.warning("Invalid username/password! ");
                }
                break;
            case 2:
                buyService.diplayAvailableProducts();
                break;
            case 3:
                buyService.displayShoppingCart(null);
                break;
            case 4:
                buyService.buyProduct(null);
                break;
            case 0:
                logger.info(" Exiting ");
                break;
            default:
                logger.info("Invalid option ! ");
                break;
        }
    }
}
