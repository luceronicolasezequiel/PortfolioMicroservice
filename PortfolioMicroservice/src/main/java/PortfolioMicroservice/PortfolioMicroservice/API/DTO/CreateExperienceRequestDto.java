package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

public class CreateExperienceRequestDto {
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 60)
    @Length(min = 3, max = 60)
    private String position;

    @Column(nullable = false, length = 50)
    @Length(min = 3, max = 50)
    private String organization;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_from", nullable = false)
    private Date periodFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "period_to", nullable = true)
    private Date periodTo;

    public Integer getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getOrganization() {
        return organization;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

}
