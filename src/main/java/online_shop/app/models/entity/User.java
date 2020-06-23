package online_shop.app.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User  extends BaseEntity{

    @Column(unique = true,nullable = false)
    @Length(min = 2,message = "Username length must be more than two character!")
    private String username;
    @Column(nullable = false)
    @Length(min = 2,message = "Password length must be more than two character!")
    private String password;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    @DecimalMin(value = "0.00",message = "Budget must be a positive number!")
    private BigDecimal budget;
}


