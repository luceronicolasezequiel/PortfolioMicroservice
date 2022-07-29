package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer> { }
