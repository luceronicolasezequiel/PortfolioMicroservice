package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class UpdateEducationRequestDto {

    @Column(nullable = false)
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

    public Integer getId() {
        return id;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTitle() {
        return title;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

}
