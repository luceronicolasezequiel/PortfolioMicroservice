package PortfolioMicroservice.PortfolioMicroservice.Api.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IProyectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proyect")
public class ProyectController {
    private IProyectRepository proyectRepository;

    public ProyectController(IProyectRepository proyectRepository) {
        this.proyectRepository = proyectRepository;
    }

    @GetMapping("/getAll")
    public List<IProyectGetAllResponseDto> getAll() { return proyectRepository.getAll(); }
}
