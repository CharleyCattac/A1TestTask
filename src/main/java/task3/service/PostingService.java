package task3.service;

import task3.entity.Posting;
import task3.util.Period;

import java.util.List;

public interface PostingService extends MainEntityService<Posting, Long> {

    List<Posting> findAllByPeriod(Period period);

    List<Posting> findAllByAuthorised(Boolean authorised);

    List<Posting> findAllByPeriodAndAuthorised(Period period, Boolean authorised);
}
