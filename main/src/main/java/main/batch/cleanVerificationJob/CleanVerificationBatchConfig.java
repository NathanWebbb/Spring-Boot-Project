package main.batch.cleanVerificationJob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CleanVerificationBatchConfig {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public Job cleanVerificationJob() {
        return new JobBuilder("cleanVerificationJob", jobRepository)
                .start(cleanVerificationStep())
                .build();
    }

    @Bean
    public Step cleanVerificationStep() {
        return new StepBuilder("cleanVerificationStep", jobRepository)
                .tasklet(cleanVerificationBatchTasklet(), transactionManager)
                .build();
    }

    @Bean
    public CleanVerificationBatchTasklet cleanVerificationBatchTasklet() {
        return new CleanVerificationBatchTasklet();
    }
}
