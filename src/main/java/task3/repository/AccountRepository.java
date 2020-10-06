package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountName(String accountName);

    Account findByAccountName(String accountName);
}
