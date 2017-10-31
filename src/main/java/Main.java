import org.quartz.JobExecutionContext;

import java.util.Scanner;

public class Main implements org.quartz.Job {

    public void execute(JobExecutionContext context) {
        int i;
        String zapytanie;
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Nr zadania: ");
            i = scan.nextInt();
            System.out.println("Zapytanie sql: ");
            scan.nextLine();
            zapytanie = scan.nextLine();
            Sql sql = new Sql(zapytanie, i);
            sql.parsowanie();
            sql.podzial();
            }
    }
}
