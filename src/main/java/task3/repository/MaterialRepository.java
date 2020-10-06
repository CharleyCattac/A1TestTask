package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, String> {

    Material findDistinctByDescription(String description);
}
