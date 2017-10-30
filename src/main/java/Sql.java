import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sql {
    protected String zapytanie;
    public Sql() {}
    public String getZapytanie() {
        return zapytanie;
    }
    public void setZapytanie(String zapytanie) {
        Scanner scan = new Scanner(System.in);
        this.zapytanie = scan.nextLine();
        scan.close();
    }
    public void podzial() throws FileNotFoundException {
        zapytanie = zapytanie.toLowerCase();
        if (zapytanie.matches("select.+from.+order by+") ||
                zapytanie.matches("select.+from.+") ||
                zapytanie.matches("select.+from.+where.+") ||
                zapytanie.matches("select.+from.+where.+order by.+")) {
            System.out.println("Prawidłowe zapytanie");
            PrintWriter zapis = new PrintWriter("odp.txt");
            zapis.println(zapytanie);
            zapis.close();        }

        else if (zapytanie.matches("select.*where.+") ||
                zapytanie.matches("select.*order by.+"))
            System.out.println("Błędne zapytanie");

    }
}

