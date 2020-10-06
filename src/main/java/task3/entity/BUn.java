package task3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bun")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BUn {

    @Id
    private String codename;

    @OneToMany(mappedBy = "bUn",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Posting> postings;
}
