package task3.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import task3.entity.Account;
import task3.entity.Posting;
import task3.exception.CsvFileNotFoundException;
import task3.service.AccountService;
import task3.service.PostingService;
import task3.util.impl.AccountParser;
import task3.util.impl.CsvFileReader;
import task3.util.impl.PostingParser;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private static final String FILENAME_LOGINS = "logins";
    private static final String FILENAME_POSTINGS = "postings";
    private static final String FILENAME_EXTENSION = ".csv";

    @Bean
    CommandLineRunner initDatabase(CsvFileReader fileReader,
                                   AccountParser accountParser, PostingParser postingParser,
                                   AccountService accountService, PostingService postingService)
            throws CsvFileNotFoundException {

        List<String> logins = fileReader.readStrings(FILENAME_LOGINS + FILENAME_EXTENSION);
        List<String> postingStrings = fileReader.readStrings(FILENAME_POSTINGS + FILENAME_EXTENSION);
        logins.remove(0);
        postingStrings.remove(0);
        postingStrings.remove(0);

        List<Account> accounts = accountParser.parseStrings(logins);
        List<Posting> postings = postingParser.parseStrings(postingStrings);

        return args -> {
            log.info("Uploading " + accountService.saveAll(accounts));
            log.info("Uploading " + postingService.saveAll(postings));
        };
    }
}
