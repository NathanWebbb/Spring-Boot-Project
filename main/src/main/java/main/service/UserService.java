package main.service;

import main.entity.Task;
import main.entity.User;
import main.entity.Verification;
import main.repository.TaskRepository;
import main.repository.UserRepository;
import main.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    VerificationRepository verificationRepository;


    public User saveUser(User user) {
        if (user.getUserId() == null) {//create
            user.setCreatedDate(LocalDateTime.now());
            user.getTaskList().forEach(task -> task.setCreatedAt(LocalDateTime.now()));
        }
        user.setLastLoginDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.getTaskList().forEach(task -> task.setUpdatedAt(LocalDateTime.now()));
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Task> getUserAllTasks(Long userId) {
        return userRepository.findById(userId).get().getTaskList();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getAllDueTasks() {
        return taskRepository.getAllDueTasks();
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Verification saveVerification(String email, String code) {
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setEmail(email);
        Verification haveOne = verificationRepository.findByEmail(email);
        if (haveOne != null) {
            verification.setVerificationId(haveOne.getVerificationId());
        }
        return verificationRepository.save(verification);
    }
}
