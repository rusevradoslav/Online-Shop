package online_shop.app.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemViewModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
}
