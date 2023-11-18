package projects.market.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "compras_productos")
public class CompraProducto {
    @EmbeddedId
    private CompraProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
