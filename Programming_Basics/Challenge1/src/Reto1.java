/**
 *
 * @author niltonrodriguez
 */
import java.util.Scanner;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1{
    /**
     * Main function.
     * @param args 
     */
    public static void main(String[] args) {
        // TODO code application logic here.
        Reto1 solucion = new Reto1();
        solucion.run();
    }
    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        /*
        solución propuesta
        */
        // Declarar las variables iniciales.
        double height; 
        double weight; 
        double patientBmi;
        int age;
        String input;
        String patientRisk;
        // Solicitar el input con los datos del paciente.
        input = read();
        // Declarar un array para separar los valores ingresados.
        String spareInput[] = input.trim().split("\\s+");
        // Asignar cada valor a la variable correspondiende.
        weight = Double.parseDouble(spareInput[0]);
        height = Double.parseDouble(spareInput[1]);
        age = Integer.parseInt(spareInput[2]);
        // Asignar el calculo del IMC a una variable.
        patientBmi = bmiCalc(weight, height);
        // Asignar el calculo del riesgo a una variable.
        patientRisk = risk(patientBmi, age);
        // Mostrar los resultados.
        showResults(weight, height, age, patientBmi, patientRisk);
    }
    /**
     * Método para calcular el índice de masa corporal.
     * @param weight double peso obtenido por teclado.
     * @param height double estatura obtenido por teclado
     * @return bmi double correpodiente al índice de masa corporal obtenido.
     */
    public double bmiCalc(double weight, double height){
        double bmi;
        // Calcular el imc (peso * altura^2)
        bmi = weight / (Math.pow(height, 2));
        return bmi;
    }
    /**
     * Método para calcular el riesgo de tener problemas de corazón.
     * @param bmi double Índice de masa corporal.
     * @param age int edad obtenida por teclado.
     * @return risk String correspondiente al riesgo segun los valores base.
     */
    public String risk(double bmi, int age){
        String risk;
        if(age < 45){
            if(bmi < 22){
                risk = "LEVE";
            }
            else{
                risk = "MODERADO";
            }
        }
        else{
            if(bmi < 22){
                risk = "MODERADO";
            }
            else{
                risk = "ALTO";
            } 
        }
        return risk;
    }
    /**
     * Método para mostrar los resultados.
     * @param weight double peso obtenido por teclado.
     * @param height double estatura obtenido por teclado.
     * @param age int edad obtenida por teclado.
     * @param patientBmi double Índice de masa corporal del paciente.
     * @param patientRisk String Riesgo del paciente.
     */
    public void showResults(double weight, double height, int age,
            double patientBmi, String patientRisk){
        // Verificar que los valores ingresados se encuentren dentro del límite.
        if(0 < weight && weight <= 150 && 0.1 < height && height <= 2.5 &&
                0 < age && age < 110){
            // Mostrar el resultado del ICM y el Riesgo.
            System.out.println(String.format("%.2f %s", patientBmi, 
                    patientRisk));
        }
        // Si los valores no se encuentran en los límites.
        else{
            // Mostrar mensaje de error.
            System.out.println("ERROR");
        }
        
    }
}