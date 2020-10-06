package task3.service;

import task3.entity.Account;

public interface AccountService extends MainEntityService<Account, Long> {

    Account findByAccountName(String accountName);
}
