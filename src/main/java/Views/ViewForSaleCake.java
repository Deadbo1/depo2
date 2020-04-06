package Views;

public class ViewForSaleCake {
    private static ViewForSaleCake viewForSaleCake;

    public static ViewForSaleCake getInstance() {
        if(viewForSaleCake == null) {
            viewForSaleCake = new ViewForSaleCake();
            return viewForSaleCake;
        }
        return viewForSaleCake;
    }

    public void menu() {
        System.out.println("1.Choose a cake from the menu");
        System.out.println("2.Create cake");
        System.out.println("3.Back to main menu");
    }
}
