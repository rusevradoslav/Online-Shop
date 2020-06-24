package online_shop.app.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop.app.models.entity.CategoryName;
import online_shop.app.models.entity.GenderType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemAddBindingModel {

    @Length(min = 2,message = "Item length must be more than two character!")
    private String name;
    @Length(min = 3,message = "Description length must be more than three character!")
    private String description;
    @NotNull(message = "Enter valid category name!")
    private CategoryName category ;
    @NotNull(message = "Enter valid gender name!")
    private GenderType gender;
    @DecimalMin(value = "0",message = "Enter valid price!")
    private BigDecimal price;

}
