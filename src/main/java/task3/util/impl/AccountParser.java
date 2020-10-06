package task3.util.impl;

import org.springframework.stereotype.Component;
import task3.entity.Account;
import task3.entity.Application;
import task3.entity.Department;
import task3.entity.Job;
import task3.util.CsvParser;

@Component
public class AccountParser implements CsvParser<Account> {

    public static final String DELIMITER = ",";
    public static final int ITEM_COUNT = 5;

    @Override
    public Account parseString(String data) {
        Account account = null;
        if (data != null) {
            String[] values = data.split(DELIMITER);
            if (values.length == ITEM_COUNT) {
                account = Account.builder()
                        .application(Application.builder().codename(values[0].trim()).build())
                        .accountName(values[1].trim())
                        .isActive(Boolean.parseBoolean(values[2].trim()))
                        .job(Job.builder().title(values[3].trim()).build())
                        .department(Department.builder().name(values[4].trim()).build())
                        .build();
            }
        }
        return account;
    }
}
