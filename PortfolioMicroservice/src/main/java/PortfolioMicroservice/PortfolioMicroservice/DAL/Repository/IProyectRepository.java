package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProyectRepository extends JpaRepository<Proyect, Integer> {

    @Query(
            value = "SELECT id, name, date_realization AS dateRealization, description, urls " +
                    "FROM proyects AS p " +
                    "ORDER BY date_realization DESC",
            nativeQuery = true
    )
    List<IProyectGetAllResponseDto> getAll();

}
