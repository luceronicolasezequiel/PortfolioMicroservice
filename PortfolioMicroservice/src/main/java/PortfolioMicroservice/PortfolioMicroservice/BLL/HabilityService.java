package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Hability;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IHabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
    public Hability create(CreateHabilityRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Hability Bad Request.");

        var response = new Hability();
        response.setName(request.getName());
        response.setPercentage(request.getPercentage());

        response = save(response);

        return response;
    }

    @Override
    public Hability save(Hability hability) {
        var response = habilityRepository.save(hability);

        return response;
    }

}
