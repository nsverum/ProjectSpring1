package org.domain.repository;

import org.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task, Long> {
}
