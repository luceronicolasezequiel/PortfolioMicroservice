package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateSummaryRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IPersonalInformationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PersonalInformationService implements IPersonalInformationService {

    private IPersonalInformationRepository personalInformationRepository;

    public PersonalInformationService(IPersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    @Override
    public IPersonalInformationGetOneResponseDto getOne() throws HttpClientErrorException {
        var personalInformation = personalInformationRepository.getOne();

        if (personalInformation == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Personal Information Not Found.");

        return personalInformation;
    }

    @Override
    public PersonalInformation updateFullnameAndTitle(UpdateFullnameAndTitleRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Personal Information Bad Request.");

        var response = personalInformationRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Personal Information Not Found with Id " + request.getId() + ".");

        response.setName(request.getName());
        response.setSurname(request.getSurname());
        response.setTitle(request.getTitle());

        response = save(response);

        return response;
    }

    @Override
    public PersonalInformation updateSummary(UpdateSummaryRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Personal Information Bad Request.");

        var response = personalInformationRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Personal Information Not Found with Id " + request.getId() + ".");

        response.setSummary(request.getSummary());
        response = save(response);

        return response;
    }

    @Override
    public PersonalInformation save(PersonalInformation request) {
        var response = personalInformationRepository.save(request);

        return response;
    }
}
