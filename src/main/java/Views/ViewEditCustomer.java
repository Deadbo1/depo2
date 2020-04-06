package Views;

public class ViewEditCustomer {
    private static ViewEditCustomer viewEditCustomer;

    public static ViewEditCustomer getInstance() {
        if(viewEditCustomer == null) {
            viewEditCustomer = new ViewEditCustomer();
            return viewEditCustomer;
        }
        return viewEditCustomer;
    }
    public void menu() {
        System.out.println("1.Edit first name");
        System.out.println("2.Edit last name");
        System.out.println("3.Edit full name");
        System.out.println("4.Back to main menu");
    }
}
