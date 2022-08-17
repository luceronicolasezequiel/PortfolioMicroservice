package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Proyect;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IProyectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectService implements IProyectService {

    private IProyectRepository proyectRepository;

    public ProyectService(IProyectRepository proyectRepository) {
        this.proyectRepository = proyectRepository;
    }

    @Override
    public List<IProyectGetAllResponseDto> getAll() {
        var response = proyectRepository.getAll();

        return response;
    }

    @Override
    public Proyect save(Proyect proyect) {
        var response = proyectRepository.save(proyect);

        return response;
    }

}
