import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.Duration;
import java.time.LocalTime;

public class Czas implements org.quartz.Job{

    private void miedzyCzym(LocalTime teraz, LocalTime poczatekZajec, LocalTime koniecZajec, LocalTime koniecPrzerwy) {
        if(teraz.isAfter(poczatekZajec) && teraz.isBefore(koniecZajec))
        {

            Duration czasMiedzy = Duration.between(teraz, koniecZajec);
            System.out.println (czasMiedzy.toMinutes()+1 + " minut do końca zajęć");
        }
        if(teraz.isAfter(koniecZajec) && teraz.isBefore(koniecPrzerwy))
        {
            Duration czasMiedzy = Duration.between(teraz, koniecPrzerwy);
            System.out.println (czasMiedzy.toMinutes()+1 + " minut do końca przerwy");
        }
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        LocalTime teraz = LocalTime.now();
        LocalTime[] zajecia = new LocalTime[14];
        zajecia[1] = LocalTime.of(8, 15);
        zajecia[2] = LocalTime.of(9, 45);
        zajecia[3] = LocalTime.of(10, 00);
        zajecia[4] = LocalTime.of(11, 30);
        zajecia[5] = LocalTime.of(11, 45);
        zajecia[6] = LocalTime.of(13, 15);
        zajecia[7] = LocalTime.of(13, 45);
        zajecia[8] = LocalTime.of(15, 15);
        zajecia[9] = LocalTime.of(15, 30);
        zajecia[10] = LocalTime.of(17, 00);
        zajecia[11] = LocalTime.of(17, 15);
        zajecia[12] = LocalTime.of(18, 45);
        zajecia[13] = LocalTime.of(19, 00);


        if(teraz.isAfter(zajecia[1]) && teraz.isBefore(zajecia[13])) {
            for(int i = 1 ; i < 13 ; i+=2)
                miedzyCzym(teraz, zajecia[i], zajecia[i+1], zajecia[i+2]);
        }

    }


}
