package Controllers;

import Models.Persona;

/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {
    public Persona [] seleccionEdad (Persona[] arreglo){
        for(int i=0; i<arreglo.length-1; i++){
            int indicemin = i;
            for(int j=i+1; j<arreglo.length; j++){
                if(arreglo[j].getEdad() > arreglo[indicemin].getEdad()){
                    indicemin = j;
                }
            } 
            Persona aux = arreglo[indicemin];
            arreglo[indicemin] = arreglo[i];
            arreglo[i] = aux;
        }
        return arreglo;
    }

    public Persona[] seleccionNombre (Persona[] arreglo){
        for(int i=0; i<arreglo.length-1; i++){
            int indicemin = i;
            for(int j=i+1; j<arreglo.length; j++){
                if(arreglo[j].getNombre().compareTo(arreglo[indicemin].getNombre()) < 0){	
                    indicemin = j;
                }
            } 
            Persona aux = arreglo[indicemin];
            arreglo[indicemin] = arreglo[i];
            arreglo[i] = aux;
        }
        return arreglo;
    }

    public int busquedaBinariaEdad(Persona[] arreglo, int valorbus){
        int inicio = 0;
        int fin = arreglo.length - 1;

        while(inicio<=fin){
            int medio = inicio+(fin-inicio);
            if(arreglo[medio].getEdad() == valorbus){
                System.out.println("Persona encontrada en la posción "+medio+" ("+arreglo[medio]+")");
                return medio;
            }

            if(arreglo[medio].getEdad()<valorbus){
                inicio = medio+1;
            }else{
                fin = medio-1;
            }
        }
        System.out.println("La persona que esta buscando no esta en el arreglo");
        return -1;
    }

    public int busquedaBinariaNombre(Persona[] arreglo, String valorbus){
        int inicio = 0;
        int fin = arreglo.length - 1;

        while(inicio<=fin){
            int medio = inicio+(fin-inicio);
            if(arreglo[medio].getNombre() == valorbus){
                System.out.println("Persona encontrada en la posción "+medio+" ("+arreglo[medio]+")");
                return medio;
            }

            if(arreglo[medio].getNombre().compareTo(valorbus)<0){
                inicio = medio+1;
            }else{
                fin = medio-1;
            }
        }
        System.out.println("La persona que esta buscando no esta en el arreglo");
        return -1;
    }
}
