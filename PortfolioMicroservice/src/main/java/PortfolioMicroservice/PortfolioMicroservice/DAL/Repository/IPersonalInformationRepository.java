package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonalInformationRepository extends JpaRepository<PersonalInformation, Integer> {

    @Query(
            value = "SELECT id, name, surname, title, summary " +
                    "FROM personal_information " +
                    "LIMIT 1",
            nativeQuery = true
    )
    IPersonalInformationGetOneResponseDto getOne();

}
