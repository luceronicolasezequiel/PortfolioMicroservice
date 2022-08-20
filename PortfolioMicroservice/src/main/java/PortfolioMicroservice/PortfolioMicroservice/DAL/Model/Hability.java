package PortfolioMicroservice.PortfolioMicroservice.DAL.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

@Entity
@Table(name = "habilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Length(min = 2, max = 100)
    private String name;

    @Column(nullable = false)
    private Integer percentage;
}
