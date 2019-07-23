import menu.LoginMenu;
import model.Store;

public class Main {

    public static void main(String[] args) {
        Store store = new Store("Altex", "str. Palat 12");
        store.buildProductList();
        LoginMenu loginMenu = new LoginMenu(store);
        loginMenu.displayMenu();
    }
}
