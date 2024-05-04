package main.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VERIFICATION")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    private String email;

    private String code;

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getVerificationId() {
        return verificationId;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }
}
