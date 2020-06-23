package online_shop.app.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop.app.models.entity.Category;
import online_shop.app.models.entity.GenderType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemServiceModel extends  BaseServiceModel{

    @Length(min = 2,message = "Item length must be more than two character!")
    private String name;
    @Length(min = 2,message = "Description length must be more than three character!")
    private String description;
    @DecimalMin(value = "0.00", message = "Price must be positive number")
    private BigDecimal price;
    private CategoryServiceModel category;
    private GenderType gender;
}
