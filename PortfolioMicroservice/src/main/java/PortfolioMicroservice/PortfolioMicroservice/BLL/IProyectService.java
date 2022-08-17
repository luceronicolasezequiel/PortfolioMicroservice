package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Proyect;

import java.util.List;

public interface IProyectService {

    public List<IProyectGetAllResponseDto> getAll();

    public Proyect save(Proyect proyect);

}
