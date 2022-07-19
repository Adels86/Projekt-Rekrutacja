package pl.sda.Projekt_Koncowy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String lastname;

    private String login;

    private String password;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String gender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @Column(name = "creating_account_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creatingAccountDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",

    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}