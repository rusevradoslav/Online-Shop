package online_shop.app.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(unique = true,nullable = false)
    @Length(min = 2,message = "Item length must be more than two character!")
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Length(min = 2,message = "Description length must be more than three character!")
    private String description;

    @Column(nullable = false)
    @DecimalMin(value = "0.00", message = "Price must be positive number")
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private GenderType gender;

}
