package main.batch.overdueJob;

import main.entity.Task;
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
public class OverdueBatchConfig{

    @Autowired
    JobRepository jobRepository;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public Job overdueJob() {
        return new JobBuilder("overdueJob", jobRepository)
                .start(overdueStep())
                .build();
    }

    @Bean
    public Step overdueStep() {
        return new StepBuilder("overdueStep", jobRepository)
                .<Task, Task>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public OverdueBatchReader itemReader() {
        return new OverdueBatchReader();
    }

    @Bean
    public OverdueBatchProcessor itemProcessor() {
        return new OverdueBatchProcessor();
    }

    @Bean
    public OverdueBatchWriter itemWriter() {
        return new OverdueBatchWriter();
    }

}