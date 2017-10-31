import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Sql {
    private String zapytanie;
    private int i;
    private static String[] x = new String[20];
    public Sql(String zapytanie, int i) {
        this.zapytanie = zapytanie;
        this.i = i;
    }

    public String getZapytanie() {
        return zapytanie;
    }

    public int getI() {
        return i;
    }

    public boolean parsowanie() {
        zapytanie = zapytanie.toLowerCase();
        int select = zapytanie.indexOf("select");
        int from = zapytanie.indexOf("from");
        int where = zapytanie.indexOf("where");
        int order = zapytanie.indexOf("order by");
        boolean zapytanieJestOk = false;
        if (select != -1) {
            if (from != -1 && select < from) {
                if (where != -1 && from < where || where == -1) {
                    if (order != -1 && where < order || order == -1)
                        zapytanieJestOk = true;
                }}} else return zapytanieJestOk;
        return zapytanieJestOk;
    }
    public void podzial()  {
        if (parsowanie()) {
            System.out.println("Prawidłowe zapytanie");
            x[i] = getI()+". "+getZapytanie();
        }
        else
            System.err.println("Błędne zapytanie");

    }
            /* |
               |    NIE DZIALA
               v
    */
    public static void zapis() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("odp.txt");
        for(int i=1 ; i<x.length; i++ ) {
            if(x[i]!= null)
                zapis.println(x[i]);

        }

    }
}

