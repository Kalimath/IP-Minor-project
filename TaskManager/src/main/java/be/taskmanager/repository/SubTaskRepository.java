package be.taskmanager.repository;

import be.taskmanager.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask,Integer> {
}
