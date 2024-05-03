package main.batch.overdueJob;

import main.entity.Task;
import main.service.UserService;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class OverdueBatchWriter implements ItemWriter<Task> {

    @Autowired
    UserService userService;

    @Override
    public void write(Chunk<? extends Task> chunk) throws Exception {
        chunk.forEach(task -> userService.updateTask(task));
    }
}
