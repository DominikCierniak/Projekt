import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


import static org.quartz.JobBuilder.newJob;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobScheduler {

    public static void main(String[] args) throws InterruptedException {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail mainJob = newJob(Main.class)
                    .withIdentity("zapytania","group0")
                    .build();


            Trigger mainTrigger = newTrigger()
                    .withIdentity("trigger","group0")
                    .startNow()
                    .build();

            JobDetail job = newJob(Zapis.class)
                    .withIdentity("myJob", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule("0,30 * * ? * * *"))
                    .build();

           JobDetail czas = newJob(Czas.class)
                   .withIdentity("czas","group2")
                   .build();

           Trigger czasowyTrigger =  newTrigger()
                   .withIdentity("czasowy","group2")
                   .startNow()
                   .withSchedule(cronSchedule("0 * * ? * MON,TUE,WED,THU,FRI *"))
                   .build();



            scheduler.scheduleJob(mainJob, mainTrigger);
            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(czas,czasowyTrigger);
            scheduler.start();
            Thread.sleep(999999999);
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
