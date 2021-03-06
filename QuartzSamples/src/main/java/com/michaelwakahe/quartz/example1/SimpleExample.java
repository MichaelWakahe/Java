package com.michaelwakahe.quartz.example1;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.DateBuilder.*;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * This Example will demonstrate how to start and shutdown the Quartz 
 * scheduler and how to schedule a job to run in Quartz.
 * <p>
 * 
 * @author <a href="mailto:michael@michaelwakahe.com">Michael Wakahe</a>
 */
public class SimpleExample {

	public void run() throws Exception {
		Logger log = LogManager.getLogger(SimpleExample.class.getName());
        

        log.info("------- Initializing ----------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        log.info("------- Initialization Complete -----------");

        // computer a time that is on the next round minute
        Date runTime = evenMinuteDate(new Date());

        log.info("------- Scheduling Job  -------------------");

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
            .withIdentity("job1", "group1")
            .build();
        
        // Trigger the job to run on the next round minute
        Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .startAt(runTime)
            .build();
        
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        log.info(job.getKey() + " will run at: " + runTime);  

        // Start up the scheduler (nothing can actually run until the 
        // scheduler has been started)
        sched.start();

        log.info("------- Started Scheduler -----------------");

        // wait long enough so that the scheduler as an opportunity to 
        // run the job!
        log.info("------- Waiting 65 seconds... -------------");
        try {
            // wait 65 seconds to show job
            Thread.sleep(65L * 1000L); 
            // executing...
        } catch (Exception e) {
        }

        // shut down the scheduler
        log.info("------- Shutting Down ---------------------");
        sched.shutdown(true);
        log.info("------- Shutdown Complete -----------------");
    }

	
	
    /**
     * @param args
     */
    public static void main(String[] args) {

        SimpleExample example = new SimpleExample();
        
        try {
			example.run();
		} catch (Exception e) {
			System.err.println("Exception in main method.");
			e.printStackTrace();
		}
    }
}

