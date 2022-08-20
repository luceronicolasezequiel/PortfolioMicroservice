package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IEducationGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Education;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface IEducationService {

    public List<IEducationGetAllResponseDto> getAll();

    public Education create(CreateEducationRequestDto request) throws HttpClientErrorException;

    public Education update(UpdateEducationRequestDto request) throws HttpClientErrorException;

    public Education save(Education education);

    public void delete(DeleteEducationRequestDto request) throws HttpClientErrorException;

}
