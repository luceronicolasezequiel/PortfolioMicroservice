package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IExperienceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private IExperienceRepository experienceRepository;

    public ExperienceController(IExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }

    @GetMapping("/getAll")
    public List<Experience> getAll(){
        return this.experienceRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Experience> create(@RequestBody @Valid Experience experience) {
        Experience savedExperience = this.experienceRepository.save(experience);
        URI experienceURI = URI.create("/api/experience/create/" + savedExperience.getId());

        return ResponseEntity.created(experienceURI).body(savedExperience);
    }

}
