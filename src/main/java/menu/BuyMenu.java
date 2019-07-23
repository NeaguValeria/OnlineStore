package menu;

import model.User;
import service.BuyService;

import java.util.logging.Logger;

public class BuyMenu extends AbstractMenu {

    private static final Logger logger = Logger.getLogger(Logger.class.getName());
    User user;
    BuyService buyService;

    public BuyMenu(User user, BuyService buyService) {
        this.user = user;
        this.buyService = buyService;
    }

    protected void displayOption() {
        System.out.println(" BUY MENU: ");
        System.out.println(" 1 - Display Available Products");
        System.out.println(" 2 - Display Shopping Cart");
        System.out.println(" 3 - Buy Product");
        System.out.println(" 0 - Logout");
    }

    protected void executeOption(Integer option) {
        switch (option) {
            case 1:
                buyService.diplayAvailableProducts();
                break;
            case 2:
                buyService.displayShoppingCart(user);
                break;
            case 3:
                buyService.buyProduct(user);
                break;
            case 0:
                logger.info("Exiting ...");
                break;
            default:
                logger.warning("Invalid option! ");
                break;
        }
    }
}
