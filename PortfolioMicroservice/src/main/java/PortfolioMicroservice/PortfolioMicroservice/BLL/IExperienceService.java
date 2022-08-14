package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface IExperienceService {

    public List<Experience> getAll();

    public Experience create(CreateExperienceRequestDto request) throws HttpClientErrorException;

    public Experience save(Experience experience);

}
