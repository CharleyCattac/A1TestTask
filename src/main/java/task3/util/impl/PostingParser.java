package task3.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import task3.entity.*;
import task3.util.CsvParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class PostingParser implements CsvParser<Posting> {

    private static final Logger log = LoggerFactory.getLogger(PostingParser.class);

    public static final String DELIMITER = ";";
    public static final int ITEM_COUNT = 10;

    private static final String DATE_PATTERN = "dd.MM.yyyy";

    @Override
    public Posting parseString(String data) {
        Posting posting = null;
        if (data != null) {
            String[] values = data.split(DELIMITER);
            if (values.length == ITEM_COUNT) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
                try {
                    posting = Posting.builder()
                            .postingIndex(Long.parseLong(values[0].trim()))
                            .itemIndex(Integer.parseInt(values[1].trim()))
                            .docTimestamp(dateFormat.parse(values[2].trim()).getTime())
                            .postingTimestamp(dateFormat.parse(values[3].trim()).getTime())
                            .material(Material.builder().description(values[4].trim()).build())
                            .quantity(Integer.parseInt(values[5].trim()))
                            .bUn(BUn.builder().codename(values[6].trim()).build())
                            .amountLC(Float.parseFloat(values[7].trim().replaceAll(",", ".")))
                            .currency(CurrencyLocal.builder().codename(values[8].trim()).build())
                            .account(Account.builder().accountName(values[9].trim()).build())
                            .build();
                } catch (ParseException | NumberFormatException e) {
                    log.error("Cannot parse string \"" + data + "\"");
                    return null;
                }
            }
        }
        return posting;
    }
}
