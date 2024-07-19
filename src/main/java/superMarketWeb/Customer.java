package superMarketWeb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customers")  // Use customers table in database instead of 'customers'
public class Customer {
    @Id
    private  long id;
    @Column(nullable = false, length =50)
    private String fullName;
    private long phoneNumber;
    private String address;
    private String email;
}























