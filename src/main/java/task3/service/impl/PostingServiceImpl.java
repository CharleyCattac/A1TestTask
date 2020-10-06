package task3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task3.entity.*;
import task3.repository.BUnRepository;
import task3.repository.CurrencyRepository;
import task3.repository.MaterialRepository;
import task3.repository.PostingRepository;
import task3.service.AccountService;
import task3.service.PostingService;
import task3.util.Period;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostingServiceImpl implements PostingService {

    @Autowired
    private PostingRepository postingRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private BUnRepository bUnRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public Optional<Posting> findById(Long id) {
        return postingRepository.findById(id);
    }

    @Override
    public Posting save(Posting entity) {
        if (entity != null) {
            List<Posting> postingsByIndex = postingRepository.findDistinctByPostingIndex(entity.getPostingIndex());
            if (postingsByIndex.isEmpty()) {
                entity = saveToDB(entity);
            } else {
                boolean postingUpdated = false;
                for (Posting posting : postingsByIndex) {
                    if (posting.getItemIndex() == entity.getItemIndex()
                            && posting.getMaterial().getDescription().equals(entity.getMaterial().getDescription())) {
                        posting.setDocTimestamp(entity.getDocTimestamp());
                        posting.setPostingTimestamp(entity.getPostingTimestamp());
                        posting.setQuantity(entity.getQuantity());
                        if (!posting.getBUn().getCodename().equals(entity.getBUn().getCodename())) {
                            posting.setBUn(entity.getBUn());
                        }
                        posting.setAmountLC(entity.getAmountLC());
                        if (!posting.getCurrency().getCodename().equals(entity.getCurrency().getCodename())) {
                            posting.setCurrency(entity.getCurrency());
                        }
                        if (!posting.getAccount().getAccountName().equals(entity.getAccount().getAccountName())) {
                            posting.setAccount(entity.getAccount());
                        }
                        entity = saveToDB(posting);
                        postingUpdated = true;
                    }
                }
                if (!postingUpdated) {
                    saveToDB(entity);
                }
            }
        }
        return entity;
    }

    private Posting saveToDB(Posting entity) {
        Optional<Material> materialFromDB = materialRepository.findById(entity.getMaterial().getDescription());
        if (materialFromDB.isEmpty()) {
            entity.setMaterial(materialRepository.save(entity.getMaterial()));
        }
        Optional<BUn> bUnFromDB = bUnRepository.findById(entity.getBUn().getCodename());
        if (bUnFromDB.isEmpty()) {
            entity.setBUn(bUnRepository.save(entity.getBUn()));
        }
        Optional<CurrencyLocal> currencyFromBD = currencyRepository.findById(entity.getCurrency().getCodename());
        if (currencyFromBD.isEmpty()) {
            entity.setCurrency(currencyRepository.save(entity.getCurrency()));
        }
        Account accountFromDB = accountService.findByAccountName(entity.getAccount().getAccountName());
        if (accountFromDB == null) {
            accountFromDB = accountService.save(entity.getAccount());
            entity.setAuthorised(false);
        } else {
            entity.setAuthorised(accountFromDB.isActive());
        }
        entity.setAccount(accountFromDB);
        return postingRepository.save(entity);
    }

    @Override
    public List<Posting> saveAll(List<Posting> entities) {
        List<Posting> newPostings = new ArrayList<>();
        Posting saveResult;
        for (Posting posting : entities) {
            saveResult = save(posting);
            if (saveResult != null) {
                newPostings.add(saveResult);
            }
        }
        return newPostings;
    }

    @Override
    public List<Posting> findAll() {
        return postingRepository.findAll();
    }

    @Override
    public void deleteAll() {
        postingRepository.deleteAll();
    }

    @Override
    public List<Posting> findAllByPeriod(Period period) {
        long currentMillis = System.currentTimeMillis();
        long preMillis = currentMillis - period.millisInPeriod;
        return postingRepository.findDistinctByPostingTimestampBetween(preMillis, currentMillis);
    }

    @Override
    public List<Posting> findAllByAuthorised(Boolean authorised) {
        return postingRepository.findDistinctByAuthorisedIs(authorised);
    }

    @Override
    public List<Posting> findAllByPeriodAndAuthorised(Period period, Boolean authorised) {
        long currentMillis = System.currentTimeMillis();
        long preMillis = currentMillis - period.millisInPeriod;
        return postingRepository.findDistinctByAuthorisedIsAndPostingTimestampBetween(authorised,
                preMillis, currentMillis);
    }
}
