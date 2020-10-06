package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Application;
import task3.entity.BUn;

@Repository
public interface BUnRepository  extends JpaRepository<BUn, String> {

    BUn findDistinctByCodename(String codename);
}
