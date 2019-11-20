import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pruebasBuscaminas {

    public static Integer[][] tabla;

    private static int numLargo;
    private static ArrayList<Integer> numUsados = new ArrayList<Integer>();

    public static void main(String args[])
    {

    }

    public static void pregunta()  //Aquí pregunta de cuanto x cuanto quiere el tablero
    {
        pruebasBuscaminas.numLargo = 5;
        tabla = new Integer[numLargo][numLargo];
    }

    public static void GeneradorRanMinas()
    {

        Random ran = new Random();
        int fila = ran.nextInt(4);
        int colm = ran.nextInt(4);

        int a = fila+colm;

        numUsados.add(a);

        for(int i = 0; i<numLargo-1; i++)
        {

        }

        /* int numUsados[];
         numUsados = new int[numMinas];*/

       /* Random ran = new Random();
        int fila = ran.nextInt(numLargo-1);
        int colm = ran.nextInt(numLargo-1);

        String f1 = String.valueOf(fila);
        String c1 = String.valueOf(colm);

        String juntos = f1 + c1;



       Integer p = Integer.valueOf(juntos);


           for(int i = 0; i < numMinas; i++)
           {
               if (i == 0) {
                   numUsados [0] = (p);
               }
               else
               {

                   for(int b = 0; b<numUsados.length; b++)
                   {

                       if (numUsados [b] == p && b < numUsados.length)
                       {

                           fila = ran.nextInt(numMinas);
                           colm = ran.nextInt(numMinas);

                           f1 = String.valueOf(fila);
                           c1 = String.valueOf(colm);

                           juntos = f1 + c1;
                           p = Integer.valueOf(juntos);

                       }
                       else if(numUsados [b] != p && b < numUsados.length)
                       {
                           numUsados [i] = p;
                           System.out.println(p);
                          break;
                       }

                   }



               }

               if (i == numUsados.length-1) {
                   break;
               }
       }*/


    }
}
