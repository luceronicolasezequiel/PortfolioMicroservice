package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Hability;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface IHabilityService {

    public List<IHabilityGetAllResponseDto> getAll();

    public Hability create(CreateHabilityRequestDto request) throws HttpClientErrorException;

    public Hability update(UpdateHabilityRequestDto request) throws HttpClientErrorException;

    public Hability save(Hability hability);

    public void delete(DeleteHabilityRequestDto request) throws HttpClientErrorException;

}
