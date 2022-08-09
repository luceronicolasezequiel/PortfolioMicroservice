package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Hability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHabilityRepository extends JpaRepository<Hability, Integer> {

    @Query(
            value = "SELECT id, name, percentage " +
                    "FROM habilities AS h",
            nativeQuery = true
    )
    List<IHabilityGetAllResponseDto> getAll();

}
