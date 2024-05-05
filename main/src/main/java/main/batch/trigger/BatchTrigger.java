package main.batch.trigger;

import main.batch.cleanVerificationJob.CleanVerificationBatchConfig;
import main.batch.overdueJob.OverdueBatchConfig;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchTrigger {

    @Autowired
    OverdueBatchConfig overdueBatchConfig;

    @Autowired
    CleanVerificationBatchConfig cleanVerificationBatchConfig;

    @Autowired
    JobLauncher jobLauncher;

    @GetMapping("/triggerOverdueJob")
    public void triggerOverdueJob() throws Exception{
        jobLauncher.run(overdueBatchConfig.overdueJob(), new JobParameters());
    }

    @GetMapping("/triggerCleanVerificationJob")
    public void triggerCleanVerificationJob() throws Exception{
        jobLauncher.run(cleanVerificationBatchConfig.cleanVerificationJob(), new JobParameters());
    }
}
