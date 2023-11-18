package projects.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class CompraProductoPK implements Serializable {
    @Column(name = "id_compra")
    private Long idCompra;
    @Column(name = "id_producto")
    private Long idProducto;

}
