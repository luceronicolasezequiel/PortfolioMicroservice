package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Hability;

import java.util.List;

public interface IHabilityService {

    public List<IHabilityGetAllResponseDto> getAll();

    public Hability save(Hability hability);

}
