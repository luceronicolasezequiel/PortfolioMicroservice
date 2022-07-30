package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.IPersonalInformationGetOneResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonalInformationRepository extends JpaRepository<PersonalInformation, Integer> {

    @Query(
            value = "SELECT id, concat_ws(' ', name, surname) AS fullName, title, summary " +
                    "FROM personal_information " +
                    "LIMIT 1",
            nativeQuery = true
    )
    IPersonalInformationGetOneResponseDto getOne();

}
