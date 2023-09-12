package ZTI.project.SecureApplication.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productName;
    private String productDescription;
    private Double productPrice;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private ProductCategory category;
}
