package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IEducationGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Education;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IEducationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class EducationService implements IEducationService {

    private IEducationRepository educationRepository;

    public EducationService(IEducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public List<IEducationGetAllResponseDto> getAll() {
        var response = educationRepository.getAll();

        return response;
    }

    @Override
    public Education create(CreateEducationRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Education Bad Request.");

        var response = new Education();
        response.setOrganization(request.getOrganization());
        response.setTitle(request.getTitle());
        response.setPeriodFrom(request.getPeriodFrom());
        response.setPeriodTo(request.getPeriodTo());
        response = save(response);

        return response;
    }

    @Override
    public Education update(UpdateEducationRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Education Bad Request.");

        var response = educationRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Education Not Found with Id " + request.getId() + ".");

        response.setOrganization(request.getOrganization());
        response.setTitle(request.getTitle());
        response.setPeriodFrom(request.getPeriodFrom());
        response.setPeriodTo(request.getPeriodTo());

        response = save(response);

        return response;
    }

    @Override
    public Education save(Education education) {
        var response = educationRepository.save(education);

        return response;
    }

    @Override
    public void delete(DeleteEducationRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Education Bad Request.");

        var response = educationRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Education Not Found with Id " + request.getId() + ".");

        educationRepository.deleteById(request.getId());
    }

}
