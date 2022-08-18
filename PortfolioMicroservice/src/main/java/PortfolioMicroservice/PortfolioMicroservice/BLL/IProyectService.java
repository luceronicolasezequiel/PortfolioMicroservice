package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.*;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Proyect;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface IProyectService {

    public List<IProyectGetAllResponseDto> getAll();

    public Proyect create(CreateProyectRequestDto request) throws HttpClientErrorException;

    public Proyect update(UpdateProyectRequestDto request) throws HttpClientErrorException;

    public Proyect save(Proyect proyect);

    public void delete(DeleteProyectRequestDto request) throws HttpClientErrorException;

}
