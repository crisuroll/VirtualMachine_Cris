# Virtual Machine

## Autor(es)

- Cris - 1°DAM [@crisuroll](https://www.github.com/crisuroll)

## Descripción

Este proyecto simula una pequeña máquina virtual (VM) que contiene una serie de comandos utilizados para crear dentro de la propia VM un metaprograma.

## Características
Las instrucciones que va a tener la VM son:

- **HELP:** Muestra esta ayuda
- **QUIT:** Cierra la aplicación
- **RUN:** Ejecuta el programa
- **NEWINST BYTECODE:** Introduce una nueva instrucción al metaprograma
- **RESET:** Vacía el programa actual
- **REPLACE N:** Reemplaza la instrucción N por la solicitada al usuario

La palabra clave BYTECODE se refiere a unas instrucciones programadas para el metaprograma. La versión 1 ofrece:

- **PUSH n:** Agrega un objeto entero a la pila.
- **ADD, SUB, MUL, DIV:** Estas instrucciones cogen los dos objetos anteriores si los hubiere. Fallará si hay solo uno.
- **LOAD pos:** Carga en pila el número guardado en pos, siendo este la posición en la memoria.
- **STORE pos:** Carga en memoria el número en pos, siendo este la posición en la memoria. Elimina la cima (no entiendo esto).
- **OUT:** Muestra por pantalla la cima de la pila.
- **HALT:** Detiene el metaprograma. 
