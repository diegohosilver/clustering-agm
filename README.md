# clustering-agm
### Trabajo práctico para Programación III
Este repositorio contiene código fuente y consignas a realizar en Java
### Estructura del proyecto
```
└───src
    ├───main
    │   ├───negocio -----------> Clases con la lógica de negocio del proyecto
    │   │   └───grafo ---------> Clases con la lógica para generar grafos, aristas y vértices
    │   └───interfaz ----------> Clases con las interfaces visuales del proyecto
    │       ├───controles -----> Clases con la lógica para generar controles
    │       └───util ----------> Clases con funciones auxiliares
    └───test
        ├───controles ---------> Tests para verificar la funcionalidad de los diferentes generadores de controles visuales
        ├───grafo -------------> Test para verificar la funcionalidad de Grafo
        └───util --------------> Test para verificar la funcionalidad de las diferentes funciones auxiliares
```
### Documentación
#### `negocio.grafo`
##### `Arista`
Es una `Clase` que guarda los siguientes datos:
- Vértice inicial
- Vértice final
- Peso de la arista
##### `Grafo`
Es una `Clase` que implementa un grafo utilizando _Lista de Vecinos_. <br>
Cuenta con los siguientes métodos públicos:
1. `void agregarVertice(int)`: Agrega un vértice al grafo.
2. `void agregarArista(int, int)`: Agrega una arista al grafo.
  * Excepciones:
    * Tipo: `IllegalArgumentException`.
     * Mensaje: 
      * _Vértice no puede ser negativo_.
      * _No existen aristas entre un vértice y si mismo!_.
      * _El vértice no existe!_.
3. `boolean existeArista(Arista)`: Valida la existencia de una arista dentro del grafo.
4. `void eliminarArista(Arista)`: Elimina una arista del grafo.
5. `void eliminarAristasSobreMedia(double)`: A partir de un porcentaje de densidad, elimina las aristas cuyo peso supera la media del porcentaje de densidad.
6. `int buscarIndiceAristaPorPeso(double peso)`: Devuelve el índice de la arista correspondiente al peso.
##### `Vecino`
Es una `Clase` que guarda los siguientes datos:
- Vértice de destino
- Peso de la arista
##### `Vertice`
Es una `Clase` que implementa al vértice de un grafo <br>
Cuenta con los siguientes métodos públicos:
1. `list<Vecino> obtenerVecinos()`: Devuelve los vecinos del vértice.
2. `void agregarArista(int, double)`: Registra un nuevo vecino con su correspondiente peso de arista.
3. `void eliminarVecino(int)`: Elimina un vecino del vértice.
4. `int vecinoUnidoPorArista(int)`: A partir de un vertice determina el índice del vecino dentro de la lista de vecinos.
#### `negocio`
##### `Kruskal`
Es una `Clase` que implementa el algoritmo de Kruskal para la obtención de un _árbol generador mínimo_ a partir de un grafo. <br>
Cuenta con los siguientes métodos públicos:
1. `grafo ejecutarAlgoritmo(Grafo)`: Aplica el algoritmo y devuelve un grafo nuevo con el _agm_.
2. `int buscarVertice(int[], int)`: Devuelve el vértice padre del vértice dado dentro del grafo.
3. `void actualizarGrupoMaestro(int[], int, int)`: Coloca a ambos vértices dentro del mismo grupo maestro.
4. `void inicializarGrupoMaestro(int[])`: Inicializa un grupo maestro donde cada elemento apunta a si mismo.
#### `interfaz.controles`
`Clases` para generar controles visuales:
* `combo`: Paquete
  * `Combo`: Generar control del tipo Combo.
  * `ComboItem`: Items del control.
  * `ComboItemRender`: Lógica para leer `ComboItem` y cargarlos dentro del combo.
* `general`: Paquete
  * `Bordes`: Generar borde para un control.
  * `Dimensiones`: Generar dimensiones para un control.
* `Alerta`: Generar un cartel de alerta con un mensaje.
* `Boton`: Generar control del tipo botón.
* `Etiqueta`: Generar control del tipo label.
* `Mapa`: Generar control del tipo jmapviewer.
* `Panel`: Generar control del tipo panel.
* `SelectorArchivo`: Generar control del tipo fileupload.
* `Texto`: Generar control del tipo textbox.
#### `interfaz.util`
`Clases` con diversas utilidades:
* `Archivo`: Levantar y leer archivo.
* `Coordenada`: Generación y validación de coordenadas.
* `Instancia`: Datos de los diversos casos de instancia de coordenadas.
* `Instancias`: Inicializar datos de instancia.
* `Unidad`: `ENUM` con las unidades para calcular distancia entre coordenadas.
* `Varios`: Diversas validaciones.
#### `interfaz`
##### `Coleccion`
Es un `Singleton` que asocia las diferentes coordenadas a los vértices del grafo.
##### `Controlador`
Es una `Clase` que inicializa el programa.
##### `PantallaPrincipal`
Es una `Clase` que concentra los controles visuales y consume el código de negocio
