package projects.market.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString(exclude = {"compraProductos"})
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;
    @Column(name = "medio_pago")
    private String medioPago;
    private String comentario;
    private Boolean estado;
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> compraProductos;
}
