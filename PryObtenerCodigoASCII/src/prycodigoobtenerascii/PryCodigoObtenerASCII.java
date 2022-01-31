/*
Se tienen 2 arreglos y una cadena de caracteres, la cadena de caracteres tiene una frase alfanumerica de 20 caracteres
Elabore un programam en java que permita guardar en el primer arreglo los codigos ASCII de cada uno de los caracteres 
de la frase. 
En el segundo arreglo aplicar un proceso decifrado que a través de los codigos ASCII de los caracteres de la frase, 
agrupados en grupos de 4 caracteres, los mismos se roten ordenados de mayor a menor en grupos de 4 caracteres. 
Aplicar un menú con las siguientes opciones:
1.- Ingresar la frase
2.- Cifrar la frase
3.- Mostrar la frase original
4.- Salir

.codePointAt() 
 */
package prycodigoobtenerascii;

import java.util.*;

/**
 *
 * @author JR ZAMBRANO
 */
public class PryCodigoObtenerASCII {

    static Scanner leer;
    static String Cadena = "";
    static int ar2[], ar1[];

    public static void main(String[] args) {
        for (;;) {
            switch (menú()) {
                case 1:
                    Ingresar();
                    break;
                case 2:
                    Cifrar();
                    break;
                case 3:
                    Mostrar();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("----::Error al procesar información::----");
            }
        }
    }

    private static int menú() {
        leer = new Scanner(System.in);
        System.out.println("---::MENÚ DE OPCIONES::---");
        System.out.println("1.- Ingresar Frase");
        System.out.println("2.- Cifrar Frase");
        System.out.println("3.- Mostrar Frase Original");
        System.out.println("4.- Salir");
        System.out.print("Ingrese Opción: ");
        return leer.nextInt();
    }

    private static void Ingresar() {
        leer = new Scanner(System.in);
        System.out.println("---::INGRESO DE DATOS::---");
        do {
            System.out.print("Ingrese frase (20 caracteres): ");
            Cadena = leer.nextLine();
        } while (Cadena.length() != 20);
        System.out.println("Ingreso de datos exitoso !!!");
    }

    private static void Cifrar() {
        System.out.println("---::PROCESO DE CIFRADO::---");
        if (Cadena.length() > 0) {
            int aux;
            ar2 = ASCII();
            for (int a = 0; a < 20; a = a + 4) {
                for (int b = a; b < a + 3; b++) {
                    for (int c = b + 1; c < a + 4; c++) {
                        if (ar2[b] < ar2[c]) {
                            aux = ar2[b];
                            ar2[b] = ar2[c];
                            ar2[c] = aux;
                        }
                    }
                }
            }
            System.out.println("La frase cifrada es: " + FraseCifrada());
        } else {
            System.out.println("Error al Cifrar Datos !!!");
        }

    }

    private static void Mostrar() {
        System.out.println("---::FRASE ORIGINAL::---");
        if (Cadena.length() > 0) {
            System.out.println("La frase original es: " + Cadena);
        } else {
            System.out.println("No se ha registrado frase !!!");
        }
    }

    private static int[] ASCII() {
        ar1 = new int[20];
        if (Cadena.length() > 0) {
            for (int i = 0; i < 20; i++) {
                ar1[i] = Cadena.codePointAt(i);
            }
            System.out.println("Cifrado Exitoso !!!");
        } else {
            System.out.println("No se ha registrado frase !!!");
        }
        return ar1;
    }

    private static String FraseCifrada() {
        char Frase[] = new char[20];
        String Dat = "";
        for (int i = 0; i < 20; i++) {
            Frase[i] = (char) ar2[i];
            Dat = Dat + Frase[i];
        }
        return Dat;
    }
}
