package online_shop.app.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel{


    @Length(min = 2,message = "Username length must be more than two character!")
    private String username;

    @Length(min = 2,message = "Password length must be more than two character!")

    private String password;

    @Email(message = "Email must contain '@'")
    private String email;

    @DecimalMin(value = "0.00",message = "Budget must be a positive number!")
    private BigDecimal budget;
}
