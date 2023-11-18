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
import projects.market.domain.Product;
import projects.market.domain.service.ProductService;

import java.util.List;
@Tag(name = "Product Controller", description = "Product management API")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Operation(summary = "Obtiene todos los productos", description = "Obtiene todos los productos")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtiene un producto por ID", description = "Obtiene un producto por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud correcta"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")

    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@Parameter(description = "ID del producto", required = true, example = "7")
                                                  @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Obtiene todos los productos por ID de categoria", description = "Obtiene todos los productos por ID de categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitud Correcta"),
            @ApiResponse(responseCode = "404", description = "Categoria no encontrada")

    })
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@Parameter(description = "ID de la categoia", required = true, example = "7")
                                                           @PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Guardar un nuevo producto", description = "Guarda un nuevo producto")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Se creo existosamente el producto")
    @PostMapping("/save")
    public ResponseEntity<Product> save(@Parameter(description = "Datos del producto") @RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    @Operation(description = "Borra un producto", summary = "Borra un producto")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Se borro exitosamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró el producto")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@Parameter(description = "ID del producto", example = "7", required = true)
                                     @PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
