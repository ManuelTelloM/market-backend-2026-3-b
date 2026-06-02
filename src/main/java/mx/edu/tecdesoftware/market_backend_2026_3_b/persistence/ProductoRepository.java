package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productocrudrepository;

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
}
