package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateSummaryRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import org.springframework.web.client.HttpClientErrorException;

public interface IPersonalInformationService {

    public IPersonalInformationGetOneResponseDto getOne() throws HttpClientErrorException;

    public PersonalInformation updateFullnameAndTitle(UpdateFullnameAndTitleRequestDto request) throws HttpClientErrorException;

    public PersonalInformation updateSummary(UpdateSummaryRequestDto request) throws HttpClientErrorException;

    public void save(PersonalInformation personalInformation);

}
