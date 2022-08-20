package PortfolioMicroservice.PortfolioMicroservice.DAL.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 60)
    @Length(min = 2, max = 60)
    private String organization;

    @Column(nullable = false, length = 100)
    @Length(min = 5, max = 100)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_from", nullable = false)
    private Date periodFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_to", nullable = true)
    private Date periodTo;

}
