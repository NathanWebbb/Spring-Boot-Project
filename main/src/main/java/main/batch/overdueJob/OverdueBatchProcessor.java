package main.batch.overdueJob;

import main.entity.Task;
import org.springframework.batch.item.ItemProcessor;

public class OverdueBatchProcessor implements ItemProcessor<Task, Task> {
    @Override
    public Task process(Task task){
        task.setStatus("Overdue");
        return task;
    }
}
