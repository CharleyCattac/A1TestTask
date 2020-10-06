package task3.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "posting")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posting extends MainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean authorised;

    private Long postingIndex; // Mat.Doc.

    private int itemIndex;

    private Long docTimestamp;

    private Long postingTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Material material;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private BUn bUn;

    private float amountLC;

    @ManyToOne(fetch = FetchType.LAZY)
    private CurrencyLocal currency;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
}
