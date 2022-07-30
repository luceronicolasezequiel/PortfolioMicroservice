package PortfolioMicroservice.PortfolioMicroservice.DAL.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "personal_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @Length(min = 3, max = 50)
    private String name;

    @Column(nullable = false, length = 50)
    @Length(min = 3,max = 50)
    private String surname;

    @Column(nullable = false, length = 80)
    @Length(min = 3, max = 80)
    private String title;

    @Column(nullable = false, length = 1000)
    @Length(min = 3, max = 1000)
    private String summary;
}
