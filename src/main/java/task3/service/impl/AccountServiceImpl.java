package task3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task3.entity.Account;
import task3.entity.Application;
import task3.entity.Department;
import task3.entity.Job;
import task3.repository.AccountRepository;
import task3.repository.ApplicationRepository;
import task3.repository.DepartmentRepository;
import task3.repository.JobRepository;
import task3.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account findByAccountName(String accountName) {
        return accountRepository.findByAccountName(accountName);
    }

    @Override
    public Account save(Account entity) {
        if (entity != null) {
            if (accountRepository.existsByAccountName(entity.getAccountName())) {
               Account accountFromDB = accountRepository.findByAccountName(entity.getAccountName());
               accountFromDB.setApplication(entity.getApplication());
               accountFromDB.setActive(entity.isActive());
               accountFromDB.setJob(entity.getJob());
               accountFromDB.setDepartment(entity.getDepartment());
               entity = accountFromDB;
            } else {
                if (entity.getApplication() != null) {
                    Optional<Application> appFromDB = applicationRepository.findById(entity.getApplication().getCodename());
                    if (appFromDB.isEmpty()) {
                        entity.setApplication(applicationRepository.save(entity.getApplication()));
                        //applicationRepository.save(entity.getApplication());
                    }
                }
                if (entity.getJob() != null) {
                    Optional<Job> jobFromDB = jobRepository.findById(entity.getJob().getTitle());
                    if (jobFromDB.isEmpty()) {
                        entity.setJob(jobRepository.save(entity.getJob()));
                        //jobRepository.save(entity.getJob());
                    }
                }
                if (entity.getDepartment() != null) {
                    Optional<Department> depFromDB = departmentRepository.findById(entity.getDepartment().getName());
                    if (depFromDB.isEmpty()) {
                        entity.setDepartment(departmentRepository.save(entity.getDepartment()));
                        //departmentRepository.save(entity.getDepartment());
                    }
                }
                entity = accountRepository.save(entity);
            }
        }
        return entity;
    }

    @Override
    public List<Account> saveAll(List<Account> entities) {
        List<Account> newAccounts = new ArrayList<>();
        Account saveResult;
        for (Account account : entities) {
            saveResult = save(account);
            if (saveResult != null) {
                newAccounts.add(saveResult);
            }
        }
        return newAccounts;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
