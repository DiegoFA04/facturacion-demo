# facturacion-demo

Proyecto Java de ejemplo para la demo de **Qualiforge**. Calcula el total de una factura con descuentos e impuestos y la guarda.

El código tiene **defectos deliberados** (métodos largos y repetidos, una consulta SQL armada con texto, recursos sin cerrar, una contraseña de ejemplo escrita
en el código y un redondeo mal hecho) para que Qualiforge los detecte y proponga mejoras. No es código real: la contraseña es falsa.

```bash
mvn test        # Java 21 + Maven; JUnit 5
```
