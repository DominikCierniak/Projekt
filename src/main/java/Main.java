import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Sql{
    private int i;
    public Main() throws FileNotFoundException {
        init();
    }
    public void init() throws FileNotFoundException {
       // Scanner s = new Scanner();
        Sql cos = new Sql();
        cos.setZapytanie(zapytanie);
        cos.podzial();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Main test = new Main();
    }
}