package az.orient.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Data
@DynamicInsert
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Lob
    private byte[] img;
    @Column(name = "brand")
    private String brand;
    @Column(name="price")
    private Long price;
    @CreationTimestamp
    private Date date;
    @ColumnDefault(value = "1")
    private Integer active;

}
