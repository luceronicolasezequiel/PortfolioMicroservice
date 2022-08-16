package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Hability;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IHabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilityService implements IHabilityService {

    private IHabilityRepository habilityRepository;

    public HabilityService(IHabilityRepository habilityRepository){
        this.habilityRepository = habilityRepository;
    }


    @Override
    public List<IHabilityGetAllResponseDto> getAll() {
        var response = habilityRepository.getAll();

        return response;
    }

    @Override
    public Hability save(Hability hability) {
        var response = habilityRepository.save(hability);

        return response;
    }

}
