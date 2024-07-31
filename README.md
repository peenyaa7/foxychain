# Foxychain

Este repositorio nace con la intención de aprender como funcionan internamente un sistema de blockchain y que operaciones se pueden realizar sobre ella.

El otro objetivo que tiene este repositorio es que otras personas puedan comprender de una forma sencilla como funciona todo el tema del blockchain.

## ¿Qué es una blockchain?

Una blockchain es una base de datos distribuida que se utiliza para almacenar información de forma segura y descentralizada. La información se almacena en bloques, que son enlaces de datos que se conectan entre sí. Cada bloque contiene información que se almacena en un registro público y que se puede consultar en cualquier momento.

En este repositorio no se utilizará ninguna base de datos para almacenar la información, simplemente se utilizará un array de objetos para simular la blockchain.

De forma sencilla, un blockchain es una lista o cadena de bloques, sin más.

## ¿Qué es un bloque?

Un bloque es una pieza que contiene información dentro de la lista de bloques (blockchain). En este repositorio, cada bloque contendrá la siguiente información:

- **data**: información que se almacena en el bloque. Por sencillez será un simple string.
- **timestamp**: epoch en segundos en la que se crea el bloque.
- **previousHash**: hash del bloque anterior.
- **hash**: hash del bloque actual.

### ¿Por que se guarda el hash del bloque anterior?

El hash del bloque anterior se guarda en el bloque actual para poder verificar que el bloque anterior no ha sido modificado. Si el hash del bloque anterior ha sido modificado, el hash del bloque actual no será el mismo y por tanto el bloque actual no será válido.

De esta manera se puede validar si alguno de los bloques de la blockchain ha sido modificado.

## ¿Qué es un hash?

Un hash es una cadena de caracteres que se genera a partir de un string. Este string puede ser cualquier cosa, por ejemplo, el contenido de un archivo, un texto, etc.

Estos hashes se utilizan para validar la integridad de los datos. Si el hash de un archivo es el mismo que el que se tiene guardado, significa que el archivo no ha sido modificado.

