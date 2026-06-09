package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entity.Producto;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Le da acceso a la BD
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productocrudrepository;

    @Autowired
    private ProductoCrudRepository productoCrudRepository;


    @Autowired
    private ProductMapper productMapper;

    //SELECT * FROM productos
    public List<Producto> getAll(){
        //Se castea Iterable a la lista
        return(List<Producto>) productocrudrepository.findAll();
    }

    //Obtener productos por categoria
    public List<Producto> getByCategoria(int idCategoria){
        return productocrudrepository.findByCantidadOrderByNombreAsc(idCategoria);
    }

   //Obtener productos escasos
   public Optional<List<Producto>> getEscasos(int cantidad){
        return productocrudrepository.findByCantidadStockLessThanAndEstado(cantidad, true);
   }

   //Obtener producto dado el ID
    public Optional<Producto> getProductoById(int idProducto){
        return productocrudrepository.findById(idProducto);
    }

    //Guardar un producto
    public Producto addProducto(Producto producto){
        return productocrudrepository.save(producto);
    }

   // Eliminar un producto por ID
    public void deleteProductoById(int idProducto){
        productocrudrepository.deleteById(idProducto);
    }

    public ProductoCrudRepository getProductocrudrepository() {
        return productocrudrepository;
    }

    public void setProductocrudrepository(ProductoCrudRepository productocrudrepository) {
        this.productocrudrepository = productocrudrepository;
    }
}
