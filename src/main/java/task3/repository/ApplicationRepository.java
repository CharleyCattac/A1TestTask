package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {

    Application findDistinctByCodename(String codename);
}
