package projects.market.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"productos"})
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String descripcion;
    private Boolean estado;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Producto> productos;


}
