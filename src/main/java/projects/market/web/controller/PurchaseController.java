package projects.market.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.market.domain.Purchase;
import projects.market.domain.service.PurchaseService;

import java.util.List;

@Tag(name = "Purchase Controller", description = "Purchase management API")
@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Operation(summary = "Obtiene todos las compras", description = "Obtiene todos las compras")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtiene una compra por ID del Cliente", description = "Obtiene una compra por ID del Cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud correcta"),
            @ApiResponse(responseCode = "404", description = "Compra no encontrada")

    })
    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@Parameter(description = "ID del Cliente") @PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Guardar una nueva compra", description = "Guarda una nueva compra")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Se creo existosamente la compra")
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@Parameter(description = "Datos de la compra") @RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}

