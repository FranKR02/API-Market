package projects.market.persistence.crud;


import org.springframework.data.repository.CrudRepository;
import projects.market.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
