package tienda.repositorio;

import tienda.modelo.ProductoVirtual;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductoVirtualRepository {
    private final ArrayList<ProductoVirtual> ProductoVirtuals = new ArrayList<ProductoVirtual>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarProductoVirtual(ProductoVirtual ProductoVirtual) {
        ProductoVirtual.setId(this.autoId.getAndIncrement());
        this.ProductoVirtuals.add(ProductoVirtual);
    }

    public ProductoVirtual eliminarProductoVirtual(int id) {
        ProductoVirtual ProductoVirtual = null;
        for (int i = 0; i < this.ProductoVirtuals.size(); i++) {
            if (this.ProductoVirtuals.get(i).getId() == id) {
                ProductoVirtual = this.ProductoVirtuals.remove(i);
                break;
            }
        }
        return ProductoVirtual;
    }

    public ProductoVirtual actualizarProductoVirtual(int id, ProductoVirtual ProductoVirtualActualizado) {
        ProductoVirtual ProductoVirtual = null;
        for (int i = 0; i < this.ProductoVirtuals.size(); i++) {
            if (this.ProductoVirtuals.get(i).getId() == id) {
                this.ProductoVirtuals.set(i, ProductoVirtualActualizado);
                ProductoVirtual = ProductoVirtualActualizado;
                break;
            }
        }
        return ProductoVirtual;
    }

    public ProductoVirtual obtenerProductoVirtual(int id) {
        for (ProductoVirtual ProductoVirtual : this.ProductoVirtuals) {
            if (ProductoVirtual.getId() == id) {
                return ProductoVirtual;
            }
        }
        return null;
    }

    public ArrayList<ProductoVirtual> obtenerProductoVirtuals() {
        return this.ProductoVirtuals;
    }
}

