package Views;

public class ViewEditCakeDecoration {

    private static ViewEditCakeDecoration viewEditCakeDecoration;
    public static ViewEditCakeDecoration getInstance(){
        if(viewEditCakeDecoration == null){
            viewEditCakeDecoration = new ViewEditCakeDecoration();
            return viewEditCakeDecoration;
        }
        return viewEditCakeDecoration;
    }

    public void menu(){
        System.out.println("1.Add decoration");
        System.out.println("2.Delete decoration");
        System.out.println("3.Edit decoration");
        System.out.println("4.Search decoration");
        System.out.println("5.Back to main menu");
    }
}
