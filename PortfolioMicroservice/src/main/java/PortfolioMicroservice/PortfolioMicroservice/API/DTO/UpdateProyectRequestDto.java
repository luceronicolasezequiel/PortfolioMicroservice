package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class UpdateProyectRequestDto {

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    @Length(min = 2, max = 100)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateRealization;

    @Column(nullable = false)
    @Length(min = 5, max = 400)
    private String description;

    @Column(nullable = true)
    @Length(min = 5, max = 400)
    private String urls;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateRealization() {
        return dateRealization;
    }

    public String getDescription() {
        return description;
    }

    public String getUrls() {
        return urls;
    }

}
