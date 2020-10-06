package task3.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostingDTO {

    private boolean isAuthorised;

    private Long matDoc; // Mat.Doc.

    private int item;

    private String docDate;

    private String  postingDate;

    private String materialDescription;

    private int quantity;

    private String bUn;

    private float amountLC;

    private String currency;

    private String userName;
}
