package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
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

        var personalInformation = personalInformationRepository.findById(request.getId()).orElse(null);

        if (personalInformation == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Personal Information Not Found with Id " + request.getId() + ".");

        personalInformation.setName(request.getName());
        personalInformation.setSurname(request.getSurname());
        personalInformation.setTitle(request.getTitle());
        save(personalInformation);

        personalInformation = personalInformationRepository.findById(personalInformation.getId()).orElse(null);

        return personalInformation;
    }

    @Override
    public void save(PersonalInformation personalInformation) {
        personalInformationRepository.save(personalInformation);
    }
}
