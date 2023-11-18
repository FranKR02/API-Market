package projects.market.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"compras"})
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private Long celular;
    private String direccion;
    private String correo;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Compra> compras;
}
