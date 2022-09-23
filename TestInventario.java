package Unidad1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestInventario {
    public static void main(String[] args) {
        HashMap<String, Integer>inventario= new HashMap<>();
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n"); //En caso de poner espacios no afecte
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Añadir producto");
            System.out.println("2. Aumentar un el stock producto");
            System.out.println("3. Eliminar un producto del sistema");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                String producto;
                int stock, stockactual;

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el nombre del producto");
                        producto=sn.next();
                        if (inventario.containsKey(producto)) {
                            System.out.println("Ya existe el producto");
                        } else {
                            inventario.put(producto, 0);
                            System.out.println("Se ha añadido el producto");
                        }
                        break;
                    case 2:
                        System.out.println("Introduce el nombre del producto");
                        producto=sn.next();

                        if (inventario.containsKey(producto)) {
                            System.out.println("Introduce una cantidad");
                            stock = sn.nextInt();

                            if (stock > 0) {
                                stockactual = inventario.get(producto);
                                inventario.put(producto, stockactual + stock);
                                System.out.println("Se ha añadido " + stock + " de stock al producto " + producto);
                            } else {
                                System.out.println("No se puede añadir un stock negativo");
                            }
                        }else {
                            System.out.println("No existe el producto");
                        }
                        break;
                    case 3:
                        System.out.println("Escribe el nombre del producto");
                        producto=sn.next();
                        if (inventario.containsKey(producto)){
                            System.out.println("Stock a eliminar");
                            stock=sn.nextInt();

                            if (stock > 0){
                                stockactual=inventario.get(producto);
                                if (stockactual > stock){
                                    inventario.put(producto, stockactual - stock);
                                }else {
                                    System.out.println("No hay sufuciente stock para eliminar");

                                }
                            }else {
                                System.out.println("No se puede eliminar un stock negativo");
                            }
                        }else {
                            System.out.println("No existe el producto");
                        }

                        break;
                    case 4:
                        //key set nos da todas la llaves que tenemos
                        for (String p: inventario.keySet()){
                            stock=inventario.get(p);
                            System.out.println("Clave: "+ p + ", Valor: "+ stock);

                        }
                        break;
                    case 5:
                        System.out.println("Introduce el producto a eliminar");
                        producto=sn.next();

                        if (inventario.containsKey(producto)){
                            inventario.remove(producto);
                            System.out.println("Producto eliminado");

                        }else {
                            System.out.println("No existe el producto");
                        }
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }


        }
}
