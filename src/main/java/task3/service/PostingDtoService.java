package task3.service;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task3.dto.PostingDTO;
import task3.entity.Posting;
import task3.util.Period;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostingDtoService {

    private static final String DATE_PATTERN = "dd.MM.yyyy";

    @Autowired
    private PostingService postingService;

    public List<PostingDTO> findAll(String period, String authorised) {
        List<Posting> postings;
        List<PostingDTO> postingDTOS = new ArrayList<>();

        if (!period.isBlank() && EnumUtils.isValidEnum(Period.class, period.toUpperCase())
                && !authorised.isBlank()) {
            postings = postingService.findAllByPeriodAndAuthorised(Period.valueOf(period.toUpperCase()),
                    Boolean.parseBoolean(authorised));
        } else if (authorised.isBlank() && EnumUtils.isValidEnum(Period.class, period.toUpperCase())) {
            postings = postingService.findAllByPeriod(Period.valueOf(period.toUpperCase()));
        } else if (period.isBlank() && !authorised.isBlank()) {
            postings = postingService.findAllByAuthorised(Boolean.parseBoolean(authorised));
        } else {
            postings = postingService.findAll();
        }

        for (Posting posting : postings) {
            postingDTOS.add(convertToDTO(posting));
        }
        return postingDTOS;
    }

    private PostingDTO convertToDTO(Posting posting) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        return PostingDTO.builder()
                .isAuthorised(posting.isAuthorised())
                .matDoc(posting.getPostingIndex())
                .item(posting.getItemIndex())
                .docDate(dateFormat.format(new Date(posting.getDocTimestamp())))
                .postingDate(dateFormat.format(new Date(posting.getPostingTimestamp())))
                .materialDescription(posting.getMaterial().getDescription())
                .quantity(posting.getQuantity())
                .bUn(posting.getBUn().getCodename())
                .amountLC(posting.getAmountLC())
                .currency(posting.getCurrency().getCodename())
                .userName(posting.getAccount().getAccountName())
                .build();
    }
}
