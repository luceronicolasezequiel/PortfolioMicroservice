package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Proyect;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IProyectRepository;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
    public Proyect create(CreateProyectRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Proyect Bad Request.");

        var response = new Proyect();
        response.setName(request.getName());
        response.setDateRealization(request.getDateRealization());
        response.setDescription(request.getDescription());
        response.setUrls(request.getUrls());

        response = save(response);

        return response;
    }

    @Override
    public Proyect update(UpdateProyectRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Proyect Bad Request.");

        var response = proyectRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Proyect Not Found with Id " + request.getId() + ".");

        response.setName(request.getName());
        response.setDateRealization(request.getDateRealization());
        response.setDescription(request.getDescription());
        response.setUrls(request.getUrls());

        response = save(response);

        return response;
    }

    @Override
    public Proyect save(Proyect proyect) {
        var response = proyectRepository.save(proyect);

        return response;
    }

    @Override
    public void delete(DeleteProyectRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Proyect Bad Request.");

        var response = proyectRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Proyect Not Found with Id " + request.getId() + ".");

        proyectRepository.deleteById(request.getId());
    }

}
