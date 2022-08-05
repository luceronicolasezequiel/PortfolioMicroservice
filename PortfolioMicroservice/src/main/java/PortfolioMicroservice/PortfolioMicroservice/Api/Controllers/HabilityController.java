package PortfolioMicroservice.PortfolioMicroservice.Api.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IHabilityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hability")
public class HabilityController {
    private IHabilityRepository habilityRepository;

    public HabilityController(IHabilityRepository habilityRepository) {
        this.habilityRepository = habilityRepository;
    }

    @GetMapping("/getAll")
    public List<IHabilityGetAllResponseDto> getAll() { return habilityRepository.getAll(); }
}
