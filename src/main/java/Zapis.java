import org.quartz.*;

import java.io.FileNotFoundException;

public class Zapis implements org.quartz.Job{
    // NIE ZDAŻYLEM, NASTEPNYM RAZEM POSTARAM SIE BARDZIEJ
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Sql.zapis();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
