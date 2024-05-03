package main.batch.overdueJob;

import main.entity.Task;
import main.service.UserService;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class OverdueBatchReader implements ItemReader<Task> {

    @Autowired
    UserService userService;

    Iterator<Task> iterator;

    @Override
    public Task read() {
        if(iterator == null){
            initItr();
        }
        if(iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

    public void initItr(){
        iterator = userService.getAllDueTasks().iterator();
    }

}
