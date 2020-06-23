package online_shop.app.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private CategoryName categoryName;

    @Column(columnDefinition = "TEXT")
    private String description;


}
