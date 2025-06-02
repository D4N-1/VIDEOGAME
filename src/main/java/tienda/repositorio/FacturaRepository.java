package tienda.repositorio;

import tienda.modelo.Factura;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FacturaRepository {
    private final ArrayList<Factura> Facturas = new ArrayList<Factura>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarFactura(Factura Factura) {
        Factura.setId(this.autoId.getAndIncrement());
        this.Facturas.add(Factura);
    }

    public Factura eliminarFactura(int id) {
        Factura Factura = null;
        for (int i = 0; i < this.Facturas.size(); i++) {
            if (this.Facturas.get(i).getId() == id) {
                Factura = this.Facturas.remove(i);
                break;
            }
        }
        return Factura;
    }

    public Factura actualizarFactura(int id, Factura FacturaActualizado) {
        Factura Factura = null;
        for (int i = 0; i < this.Facturas.size(); i++) {
            if (this.Facturas.get(i).getId() == id) {
                this.Facturas.set(i, FacturaActualizado);
                Factura = FacturaActualizado;
                break;
            }
        }
        return Factura;
    }

    public Factura obtenerFactura(int id) {
        for (Factura Factura : this.Facturas) {
            if (Factura.getId() == id) {
                return Factura;
            }
        }
        return null;
    }

    public ArrayList<Factura> obtenerFacturas() {
        return this.Facturas;
    }
}
