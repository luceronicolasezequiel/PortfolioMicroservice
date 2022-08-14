package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IEducationGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IEducationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private IEducationRepository educationRepository;

    public EducationController(IEducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping("/getAll")
    public List<IEducationGetAllResponseDto> getAll() {
        return educationRepository.getAll();
    }
}
