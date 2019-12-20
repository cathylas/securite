package co.simplon.dao;

import co.simplon.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
