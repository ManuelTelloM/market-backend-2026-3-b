package mx.edu.tecdesoftware.market_backend_2026_3_b.persistence;

import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.crud.ProductoCrudRepository;
import mx.edu.tecdesoftware.market_backend_2026_3_b.persistence.entities.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productocrudrepository;

    //SELECT * FROM productos
    public List<Producto> getAll(){
        //Se castea Iterable a la lista
        return(List<Producto>) productocrudrepository.findAll();
    }
}
