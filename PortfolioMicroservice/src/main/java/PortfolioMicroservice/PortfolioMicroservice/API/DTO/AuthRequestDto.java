package PortfolioMicroservice.PortfolioMicroservice.API.DTO;

import org.hibernate.validator.constraints.Length;

public class AuthRequestDto {
    @Length(min = 5, max = 50)
    private String username;

    @Length(min = 5, max = 64)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
