package main.batch.scheduler;

import main.batch.overdueJob.OverdueBatchConfig;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler{

    @Autowired
    OverdueBatchConfig overdueBatchConfig;

    @Autowired
    JobLauncher jobLauncher;

//    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleOverdueJob() throws Exception {
        jobLauncher.run(overdueBatchConfig.overdueJob(), new JobParameters());
    }



}
