package Views;

public class View {

    private static View view;
    public static View getInstance(){
        if(view == null){
            view = new View();
            return view;
        }
        return view;
    }

    public void menu(){
        System.out.println("1.Menu for cakes bases");
        System.out.println("2.Menu for decorations");
        System.out.println("3.Edit customers data ");
        System.out.println("4.Buy cake");
        System.out.println("5.Change customer");
        System.out.println("0.Exit from program");
    }
}
