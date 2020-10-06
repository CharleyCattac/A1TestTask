package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department findDistinctByName(String name);
}
