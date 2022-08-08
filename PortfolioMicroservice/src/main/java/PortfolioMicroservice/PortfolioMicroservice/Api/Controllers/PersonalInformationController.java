package PortfolioMicroservice.PortfolioMicroservice.Api.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IPersonalInformationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personalInformation")
public class PersonalInformationController {

    private IPersonalInformationRepository personalInformationRepository;

    public PersonalInformationController(IPersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    @GetMapping("/getOne")
    public IPersonalInformationGetOneResponseDto getOne() {
        return this.personalInformationRepository.getOne();
    }

}
