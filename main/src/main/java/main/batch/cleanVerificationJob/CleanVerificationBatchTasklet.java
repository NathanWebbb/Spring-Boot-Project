package main.batch.cleanVerificationJob;

import main.service.UserService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class CleanVerificationBatchTasklet implements Tasklet {

    @Autowired
    UserService userService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        userService.deleteAllVerification();
        return RepeatStatus.FINISHED;
    }
}
