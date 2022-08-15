package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IExperienceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService {

    private IExperienceRepository experienceRepository;

    public ExperienceService(IExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> getAll() {
        var response = experienceRepository.findAll();

        return response;
    }

    @Override
    public Experience create(CreateExperienceRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Experience Bad Request.");

        var response = new Experience();
        response.setPosition(request.getPosition());
        response.setOrganization(request.getOrganization());
        response.setPeriodFrom(request.getPeriodFrom());
        response.setPeriodTo(request.getPeriodTo());

        response = save(response);

        return response;
    }

    @Override
    public Experience update(UpdateExperienceRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Experience Bad Request.");

        var response = experienceRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Experience Not Found with Id " + request.getId() + ".");

        response.setPosition(request.getPosition());
        response.setOrganization(request.getOrganization());
        response.setPeriodFrom(request.getPeriodFrom());
        response.setPeriodTo(request.getPeriodTo());

        response = save(response);

        return response;
    }

    @Override
    public Experience save(Experience experience) {
        var response = experienceRepository.save(experience);

        return response;
    }

}
