package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

public interface IPersonalInformationGetOneResponseDto {
    Integer getId();
    String getName();
    String getSurname();
    String getTitle();
    String getSummary();
    byte[] getProfile();
}
