package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

public class UpdateProfileRequestDto {

    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private MultipartFile profile;

    public UpdateProfileRequestDto(Integer id, MultipartFile profile) {
        this.id = id;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public MultipartFile getProfile() {
        return profile;
    }

}
