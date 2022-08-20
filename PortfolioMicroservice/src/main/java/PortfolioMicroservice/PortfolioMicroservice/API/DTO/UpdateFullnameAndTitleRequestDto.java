package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class UpdateFullnameAndTitleRequestDto {
    @Column(nullable = false)
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTitle() {
        return title;
    }
}
