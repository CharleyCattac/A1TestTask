package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.CurrencyLocal;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyLocal, String> {

    CurrencyLocal findDistinctByCodename(String codename);
}
