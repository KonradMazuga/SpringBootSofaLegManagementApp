package ZTI.project.SecureApplication.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is Order table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "order")
//    Set<OrderItem> orderItems = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date orderDate;

//    @ManyToMany
//    @JoinTable(name = "order_products",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Set<Product> products = new HashSet<>();
}