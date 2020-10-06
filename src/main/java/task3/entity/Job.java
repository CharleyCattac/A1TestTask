package task3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    private String title;

    @OneToMany(mappedBy = "job",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Account> accounts;
}
