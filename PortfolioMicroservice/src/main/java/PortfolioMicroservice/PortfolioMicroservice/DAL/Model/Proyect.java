package PortfolioMicroservice.PortfolioMicroservice.DAL.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "proyects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @Length(min = 2, max = 150)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_realization", nullable = false)
    private Date dateRealization;

    @Column(nullable = false, length = 1000)
    @Length(min = 5, max = 1000)
    private String description;

    @Column(nullable = true, length = 400)
    @Length(min = 5, max = 400)
    private String urls;
}
