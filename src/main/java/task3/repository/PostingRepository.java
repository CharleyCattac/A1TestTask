package task3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task3.entity.Posting;

import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findDistinctByPostingIndex(Long postingIndex);

    List<Posting> findDistinctByPostingTimestampBetween(Long fromDate, Long toDate);

    List<Posting> findDistinctByAuthorisedIs(boolean isAuthorised);

    List<Posting> findDistinctByAuthorisedIsAndPostingTimestampBetween(boolean isAuthorised, Long fromDate, Long toDate);
}
