package online_shop.app.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    @Length(min = 2,message = "Username length must be more than two character!")
    @NotNull
    private String username;

    @Length(min = 2,message = "Password length must be more than two character!")
    private String password;

    private String confirmPassword;

    @Email(message = "Email must contain '@'")
    @NotNull
    private String email;

    @DecimalMin(value = "0.00",message = "Budget must be a positive number!")
    @NotNull
    private BigDecimal budget;
}
