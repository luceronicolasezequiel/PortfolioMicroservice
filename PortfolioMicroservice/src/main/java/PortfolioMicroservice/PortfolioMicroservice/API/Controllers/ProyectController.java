package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IProyectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proyect")
public class ProyectController {
    private IProyectService proyectService;

    public ProyectController(IProyectService proyectService) {
        this.proyectService = proyectService;
    }

    @GetMapping("/getAll")
    public List<IProyectGetAllResponseDto> getAll() {
        var response = proyectService.getAll();

        return response;
    }

}
