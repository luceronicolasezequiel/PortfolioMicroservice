package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateProfileRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateSummaryRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public interface IPersonalInformationService {

    public IPersonalInformationGetOneResponseDto getOne() throws HttpClientErrorException;

    public PersonalInformation updateFullnameAndTitle(UpdateFullnameAndTitleRequestDto request) throws HttpClientErrorException;

    public PersonalInformation updateProfile(UpdateProfileRequestDto request) throws HttpClientErrorException, IOException;

    public PersonalInformation updateSummary(UpdateSummaryRequestDto request) throws HttpClientErrorException;

    public PersonalInformation save(PersonalInformation request);

}
