package pl.sda.Projekt_Koncowy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Subscription {

    @Id
    private Integer id;

    @Column(name = "subscription_type")
    private String SubscriptionType;

    private Integer price;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "subscription",
//
//            joinColumns = @JoinColumn(name = "subscription_id"),
//            inverseJoinColumns = @JoinColumn(name = "");
//    )

}
