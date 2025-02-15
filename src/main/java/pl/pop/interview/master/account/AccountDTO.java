package pl.pop.interview.master.account;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDTO {
    private String email;
    private String password;

    public AccountDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
