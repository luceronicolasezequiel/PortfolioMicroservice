package PortfolioMicroservice.PortfolioMicroservice.DAL.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Length(min = 3, max = 100)
    private String position;

    @Column(nullable = false, length = 100)
    @Length(min = 3, max = 100)
    private String organization;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_from", nullable = false)
    private Date periodFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_to", nullable = true)
    private Date periodTo;

    @OneToMany(mappedBy = "experience", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks;
}
