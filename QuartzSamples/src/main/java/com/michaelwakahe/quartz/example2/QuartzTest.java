package com.michaelwakahe.quartz.example2;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.JobDetail;
import org.quartz.Trigger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.*;


/**
 * Driver class
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class QuartzTest {

    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

            // Trigger the job to run now, and then every 5 seconds
            Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(5)
                    .repeatForever())
                .build();
            
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            
            // and start it off
            scheduler.start();
            
            Thread.sleep(30000);  // amount is in milliseconds (seconds x 1000)
            scheduler.shutdown();
            
        } catch (SchedulerException se) {
            se.printStackTrace();
            
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}

