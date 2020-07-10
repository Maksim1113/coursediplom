package ru.khaustov.coursediplom.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.khaustov.coursediplom.entity.Work;

public interface WorkRepository extends CrudRepository<Work, Long>, JpaSpecificationExecutor<Work> {
}
