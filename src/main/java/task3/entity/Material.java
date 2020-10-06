package task3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "material")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id
    private String description;

    @OneToMany(mappedBy = "material",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Posting> postings;
}
