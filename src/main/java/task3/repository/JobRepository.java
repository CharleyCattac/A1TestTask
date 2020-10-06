package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    Job findDistinctByTitle(String title);
}
