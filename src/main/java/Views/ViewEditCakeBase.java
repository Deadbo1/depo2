package Views;

public class ViewEditCakeBase {

    private static ViewEditCakeBase viewEditCakeBase;
    public static ViewEditCakeBase getInstance(){
        if(viewEditCakeBase == null){
            viewEditCakeBase = new ViewEditCakeBase();
            return viewEditCakeBase;
        }
        return viewEditCakeBase;
    }

    public void menu(){
        System.out.println("1. Add cake base");
        System.out.println("2. Delete cake base");
        System.out.println("3. Edit cake base");
        System.out.println("4. Search cake base");
        System.out.println("5. Back to main menu");
    }

}
