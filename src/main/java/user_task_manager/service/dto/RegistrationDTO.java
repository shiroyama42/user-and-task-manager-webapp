package user_task_manager.service.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class RegistrationDTO {

    private String name;
    private String email;
    private String password;
    private Date birthDate;
    private String phone;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String name, String email, String password, Date birthDate, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDTO that = (RegistrationDTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
