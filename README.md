# 🖥️ Desafío Selenium - Automatización de Pruebas  

Este proyecto implementa pruebas automatizadas con **Selenium WebDriver** en **Java**, utilizando **JUnit 5** para validar casos de prueba en la web **SauceDemo**.  

## 🚀 Tecnologías Utilizadas  
- **Java 11+**  
- **Selenium WebDriver**  
- **JUnit 5**  
- **Maven**  
- **Page Object Model (POM)**  

## 📌 Estructura del Proyecto  
📂 org.desafio  
 ├── 📂 pages  
 │   ├── Driver.java  
 │   ├── LoginPage.java  
 │   ├── InventoryPage.java  
 │   ├── CartPage.java  
 │   ├── CheckOutPage.java  
 │   ├── OverviewPage.java  
 │   ├── FinishPage.java  
 │  
 ├── 📂 tests  
 │   ├── ApplicationTest.java  
 │  
 ├── pom.xml  (Maven dependencies)  
 ├── README.md (Este archivo)  

## ⚙️ Instalación y Configuración  
1. Clona este repositorio:  
   `git clone https://github.com/tu-usuario/desafio-selenium.git`  
   `cd desafio-selenium`  

2. Asegúrate de tener **Java 11+** y **Maven** instalados.  

3. Instala las dependencias del proyecto:  
   `mvn clean install`  

## 🛠️ Cómo Ejecutar las Pruebas  
Ejecuta las pruebas con Maven:  
`mvn test`  

## 📖 Descripción de las Pruebas  
El proyecto contiene pruebas que validan el flujo de autenticación y compra en **SauceDemo**:  

🔹 **LoginPage**: Verifica credenciales vacías, incorrectas y válidas.  
🔹 **InventoryPage**: Agrega productos al carrito y prueba el logout.  
🔹 **CartPage**: Verifica eliminación de productos del carrito.  
🔹 **CheckOutPage**: Simula un proceso de compra exitoso.  
🔹 **OverviewPage y FinishPage**: Finaliza la compra y valida el flujo.  

## 🏆 Autor  
Desarrollado por https://github.com/MichaelPizarro/.  

🤖 **¡Happy Testing!**
