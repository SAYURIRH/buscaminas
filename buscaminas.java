import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


public class buscaminas {
        private static Integer[][] tabla;
    private static String[][] tablaShow;

    private static int numLargo;  //que de cuanto por cuanto va a ser la tabla, numLargo X numLargo
    private static int numMinas;  //Cuantas minas va a haber en el tablero
    private static int contMinas;  //Cuantas minas lleva descubiertas
    private static int fila;        //El numero de fila
    private static int colm;        //El numero de columna
    private static int seguirJuego = 0;   //input para diferencias cual menu se va a mostrar
    private static int seguirjuegoSoN;  //Variable para seguir jeugo, sí o no
    private static String numUsados = "";  //Numero usados para no repetir donde se pone 0
    private static int jugar;              //Si quiere descubrir una casilla o descubrir una mina
    private static int jugarRenglon;       //Cual renglon selecciona el jugador
    private static int jugarColumna;       //Cual columna selecciona el jugador
    private static int numOportunidades;   //Cuntas oportunidades lleva de descubrir una mina
    private static int casillaSeleccionada;   //Casilla que el jugador decicio descubrir
    private static int numCasDescu;         //numero de casillas descubiertas
    private static int inputNivelOPerso;     //Input de si elig un nivel o hacer tabla personalizada
    private static int inputNivel;          //Input de cual nivel quiere el jugador
    private static int terminar;            //Input de s se quire termianr partida o no
    private static int puntos;             // Cuantos puntos lleva


    public static void main(String args[])
    {
        principal();
    }

    public static void principal()
    {
       while (true)
       {

           //reiniciar todas las variables cuando se quiera jugar otra vez sin acabar el juego
           numLargo = 0;
           numMinas = 0;
           contMinas = 0;
           fila = 0;
           colm = 0;
           seguirJuego = 0;
           numUsados = "";
           jugar = 0;
           jugarRenglon = 0;
           jugarColumna = 0;
           numOportunidades = 0;
           casillaSeleccionada = 0;
           numCasDescu = 0;
           inputNivelOPerso = 0;
           inputNivel = 0;
           terminar = 0;
           puntos = 0;

           valiSeguirJugando();
           buscaminas.seguirJuego++;
           if ( buscaminas.seguirjuegoSoN == 1)
           {
               valiElegirNivelOPersonalizacion();

               if(buscaminas.inputNivelOPerso == 1)
               {
                   pregunta();

                   tabla = new Integer[buscaminas.numLargo ][buscaminas.numLargo ];
                   tablaShow = new String [buscaminas.numLargo ][buscaminas.numLargo ];

                   random();
                   ponerNumeros();


                   seguirJuego++;
               }
               else if (buscaminas.inputNivelOPerso == 2)
               {
                   valiElegirNivel();
                   if(inputNivel == 1)
                   {
                       numLargo = 8;
                       numMinas = 10;

                       tabla = new Integer[buscaminas.numLargo ][buscaminas.numLargo ];
                       tablaShow = new String [buscaminas.numLargo ][buscaminas.numLargo ];

                       random();

                       ponerNumeros();


                       seguirJuego++;
                   }

                   else if(inputNivel == 2)
                   {
                       numLargo = 16;
                       numMinas = 40;

                       tabla = new Integer[buscaminas.numLargo ][buscaminas.numLargo ];
                       tablaShow = new String [buscaminas.numLargo ][buscaminas.numLargo ];

                       random();

                       ponerNumeros();


                       seguirJuego++;
                   }

                   else if(inputNivel == 3)
                   {
                       numLargo = 22;
                       numMinas = 100;

                       tabla = new Integer[buscaminas.numLargo ][buscaminas.numLargo ];
                       tablaShow = new String [buscaminas.numLargo ][buscaminas.numLargo ];

                       random();
                       ponerNumeros();


                       seguirJuego++;
                   }
               }

           }
           else if (buscaminas.seguirjuegoSoN == 2)
           {
               System.out.println("Gracias por jugar, adiós (>‿◠)✌ ");
               break;
           }
       }
    }

    public static void instrucciones ()
    {
        System.out.println("");
        System.out.println("Instrucciones:");
        System.out.println("1. Trata de descubrir todas las casillas sin mina");
        System.out.println("   o encuentra todas las minas");
        System.out.println("2. Las S en las casillas significa que estas no han sido descubiertas");
        System.out.println("");
        System.out.println("Buena Suerte");
        System.out.println("");
    }

    public static void valiSeguirJugando()
    {
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        if( buscaminas.seguirJuego == 0)
        {
            System.out.println("¿Desea jugar?    1 = Sí     2 = No");
        }
        else
        {
            System.out.println("Desea seguir jugando?     1 = Sí     2 = No");
        }

        String input = scan.nextLine();
        while (validInput == false)
        {

            try
            {
                buscaminas.seguirjuegoSoN = Integer.valueOf(input);
                if (buscaminas.seguirjuegoSoN == 1 || buscaminas.seguirjuegoSoN == 2)
                {
                    validInput = true;

                }
                else
                {
                    System.out.println("Es 1 o 2, escribe de nuevo");
                    input = scan.nextLine();
                }
            }

            catch (Exception e)
            {
                System.out.println("Lo que introdujo no es una opción válida");
                System.out.println("Introduce una respuesta válida");
                input = scan.nextLine();
            }
        }
    }

    public static void valiElegirNivelOPersonalizacion()
    {
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Elige una opción: ");
        System.out.println("1 = Juego Personalizado");
        System.out.println("2 = Elegir Nivel");

        String input = scan.nextLine();
        while (validInput == false)
        {

            try
            {
                buscaminas.inputNivelOPerso = Integer.valueOf(input);
                if (buscaminas.inputNivelOPerso == 1 || buscaminas.inputNivelOPerso == 2)
                {
                    validInput = true;

                }
                else
                {
                    System.out.println("Es 1 o 2, escribe de nuevo");
                    input = scan.nextLine();
                }
            }

            catch (Exception e)
            {
                System.out.println("Lo que introdujo no es una opción válida");
                System.out.println("Introduce una respuesta válida");
                input = scan.nextLine();
            }
        }
    }

    public static void valiElegirNivel()
    {
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Elige un nivel: ");
        System.out.println("1 = Principiante");
        System.out.println("2 = Intermedio");
        System.out.println("3 = Experto");

        String input = scan.nextLine();
        while (validInput == false)
        {

            try
            {
                buscaminas.inputNivel = Integer.valueOf(input);
                if (buscaminas.inputNivel == 1 || buscaminas.inputNivel == 2 || buscaminas.inputNivel == 3)
                {
                    validInput = true;

                }
                else
                {
                    System.out.println("Es 1, 2 o 3, escribe de nuevo");
                    input = scan.nextLine();
                }
            }

            catch (Exception e)
            {
                System.out.println("Lo que introdujo no es una opción válida");
                System.out.println("Introduce una respuesta válida");
                input = scan.nextLine();
            }
        }
    }

    public static void pregunta()  //Aquí pregunta de cuanto x cuanto quiere el tablero y cuántas minas quiere
    {
        validadorTamanoTablero();

        validadorNumMinas();



    }

    public static void random()  //Aquí pone ceros en lugares random
    {
        for( int i = 1; i<= numMinas; i++)
        {
            Random ran = new Random();
            StringTokenizer st = new StringTokenizer(numUsados, " ");
            boolean whileGrande = false;
            boolean variable = false;
            String juntos = "";

            while ( whileGrande == false)
            {

                fila = ran.nextInt(numLargo);
                colm = ran.nextInt(numLargo);

                String f1 = String.valueOf(fila);
                String c1 = String.valueOf(colm);

                juntos = f1 + c1;

                st = new StringTokenizer(numUsados, " ");

                variable = false;  //para cuando se rompa el while chico y encuentre que se repite

                while( st.hasMoreTokens())   //Mientras st tenga mas tokens
                {
                    String a = st.nextToken();  //Asigno el token que sigue a una string a

                    if(a.equals(juntos))  //ve si es el mismo numero cada vez que nuevo token
                    {
                        variable = true;   //Si si es igual la variable = true para que no entre en el if de abajo y no se rompa rl whileGrande
                        break;
                    }
                }

                if(variable == whileGrande )
                {
                    whileGrande = true; //para que ya no entre al whilegrande cuando no encuentre que el num se repite

                }
            }
            numUsados = numUsados + juntos + " ";
            tabla [fila][colm] = 0;
            //Para que se agrege el nuevo num random a los num que ya use

        }
    }

    public static void ponerNumeros()  //Este método pone los numeros al rededor de los ceros
    {
        for (int i = 0; i < numLargo; i++)
        {
            for (int j = 0; j < numLargo; j++)
            {
                if (tabla[i][j] != null)
                {
                    if (tabla[i][j] == 0)
                    {
                        if (j == 0 && i == 0)   //si hay un cero en el [0][0]
                        {

                            if (tabla[0 + 1][0] == null)
                            {
                                tabla[0 + 1][0] = 1;
                            }
                            else
                            {
                                if(tabla [0 + 1][0] != 0)
                                {
                                    tabla [0 + 1][0] = tabla[0 + 1][0] + 1;
                                }
                            }

                            if (tabla [0 + 1][0 + 1] == null)
                            {
                                tabla[0 + 1][0 + 1] = 1;
                            }
                            else
                            {
                                if(tabla [0 + 1][0 + 1]!= 0)
                                {
                                    tabla [0 + 1][0 + 1] = tabla [0 + 1][0 + 1] + 1;
                                }
                            }

                            if (tabla [0][0 + 1] == null)
                            {
                                tabla[0][0 + 1] = 1;
                            }
                            else
                            {
                                if(tabla [0][0 + 1] != 0)
                                {
                                    tabla [0][0 + 1] = tabla [0][0 + 1] + 1;
                                }
                            }
                        }

                        else if (i == numLargo - 1 && j == 0)   //Sí hay un nuemro en [numlargo-1][0]
                        {

                            if (tabla [numLargo -2][0] == null)
                            {
                                tabla [numLargo -2][0] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -2][0]  != 0)
                                {
                                    tabla [numLargo -2][0] = tabla [numLargo -2][0] + 1;
                                }
                            }

                            if (tabla [numLargo -2][0+1] == null)
                            {
                                tabla [numLargo -2][0+1] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -2][0+1] != 0)
                                {
                                    tabla [numLargo -2][0+1] = tabla [numLargo -2][0+1] + 1;
                                }
                            }

                            if (tabla [numLargo -1][0+1] == null)
                            {
                                tabla [numLargo -1][0+1] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -1][0+1] != 0)
                                {
                                    tabla [numLargo -1][0+1] = tabla [numLargo -1][0+1] + 1;
                                }
                            }

                        }
                        else if (i == numLargo - 1 && j == numLargo - 1)  //si hay un número en [numlargo-1][numlargo-1]
                        {
                            if (tabla  [numLargo -2][numLargo -1] == null)
                            {
                                tabla  [numLargo -2][numLargo -1] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -2][numLargo -1]!= 0)
                                {
                                    tabla [numLargo -2][numLargo -1] = tabla [numLargo -2][numLargo -1] + 1;
                                }
                            }

                            if (tabla  [numLargo -2][numLargo -2] == null)
                            {
                                tabla  [numLargo -2][numLargo -2] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -2][numLargo -2] != 0)
                                {
                                    tabla  [numLargo -2][numLargo -2] = tabla  [numLargo -2][numLargo -2] + 1;
                                }
                            }

                            if (tabla  [numLargo -1][numLargo -2] == null)
                            {
                                tabla  [numLargo -1][numLargo -2] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo -1][numLargo -2] != 0)
                                {
                                    tabla [numLargo -1][numLargo -2]  = tabla [numLargo -1][numLargo -2]  + 1;
                                }
                            }
                        }

                        else if (i == 0 && j == numLargo - 1)  //Si hay un cero en [0][numlargo-1]
                        {
                            if (tabla [0][numLargo-2] == null)
                            {
                                tabla [0][numLargo-2] = 1;
                            }
                            else
                            {
                                if(tabla [0][numLargo-2] != 0)
                                {
                                    tabla [0][numLargo-2]  = tabla [0][numLargo-2] + 1;
                                }
                            }

                            if (tabla [0+1][numLargo-2]  == null)
                            {
                                tabla [0+1][numLargo-2]  = 1;
                            }
                            else
                            {
                                if(tabla [0+1][numLargo-2]  != 0)
                                {
                                    tabla [0+1][numLargo-2]  = tabla [0+1][numLargo-2] + 1;
                                }
                            }

                            if (tabla  [0+1][numLargo-1]  == null)
                            {
                                tabla  [0+1][numLargo-1]  = 1;
                            }
                            else
                            {
                                if(tabla [0+1][numLargo-1] != 0)
                                {
                                    tabla [0+1][numLargo-1]  = tabla [0+1][numLargo-1] + 1;
                                }
                            }
                        }

                        else if (j == 0 && i != 0 && i != numLargo-1) //Si hay un 0 en la primera columna
                        {
                            if (tabla  [i-1][0]   == null)
                            {
                                tabla  [i-1][0]   = 1;
                            }
                            else
                            {
                                if(tabla [i-1][0]  != 0)
                                {
                                    tabla [i-1][0]   = tabla [i-1][0]  + 1;
                                }
                            }

                            if (tabla  [i-1][0+1]  == null)
                            {
                                tabla  [i-1][0+1]  = 1;
                            }
                            else
                            {
                                if(tabla [i-1][0+1] != 0)
                                {
                                    tabla [i-1][0+1]   = tabla [i-1][0+1] + 1;
                                }
                            }

                            if (tabla  [i][0+1]  == null)
                            {
                                tabla  [i][0+1] = 1;
                            }
                            else
                            {
                                if(tabla [i][0+1]  != 0)
                                {
                                    tabla [i][0+1]  = tabla [i][0+1] + 1;
                                }
                            }

                            if (tabla   [i+1][0+1] == null)
                            {
                                tabla   [i+1][0+1] = 1;
                            }
                            else
                            {
                                if(tabla [i+1][0+1]  != 0)
                                {
                                    tabla [i+1][0+1] = tabla [i+1][0+1]+ 1;
                                }
                            }

                            if (tabla  [i+1][0] == null)
                            {
                                tabla  [i+1][0]= 1;
                            }
                            else
                            {
                                if(tabla [i+1][0] != 0)
                                {
                                    tabla [i+1][0] = tabla [i+1][0] + 1;
                                }
                            }

                        }
                        else if (i == 0 && j != 0 && j != numLargo - 1)  //si hay un 0 en el primer renglón
                        {
                            if (tabla  [0][j-1] == null)
                            {
                                tabla  [0][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [0][j-1] != 0)
                                {
                                    tabla [0][j-1] = tabla [0][j-1] + 1;
                                }
                            }

                            if (tabla  [0+1][j-1] == null)
                            {
                                tabla  [0+1][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [0+1][j-1] != 0)
                                {
                                    tabla [0+1][j-1] = tabla [0+1][j-1] + 1;
                                }
                            }

                            if (tabla [0+1][j] == null)
                            {
                                tabla [0+1][j] = 1;
                            }
                            else
                            {
                                if(tabla [0+1][j] != 0)
                                {
                                    tabla [0+1][j] = tabla [0+1][j] + 1;
                                }
                            }

                            if (tabla [0+1][j+1]  == null)
                            {
                                tabla [0+1][j+1]  = 1;
                            }
                            else
                            {
                                if(tabla [0+1][j+1] != 0)
                                {
                                    tabla [0+1][j+1] = tabla [0+1][j+1] + 1;
                                }
                            }

                            if (tabla  [0][j+1]  == null)
                            {
                                tabla  [0][j+1]   = 1;
                            }
                            else
                            {
                                if(tabla [0][j+1] != 0)
                                {
                                    tabla [0][j+1] = tabla [0][j+1] + 1;
                                }
                            }
                        }
                        else if (j == numLargo - 1 && i != 0 && i != numLargo - 1)
                        {
                            if (tabla [i-1][numLargo-1] == null)
                            {
                                tabla  [i-1][numLargo-1]   = 1;
                            }
                            else
                            {
                                if(tabla [i-1][numLargo-1] != 0)
                                {
                                    tabla [i-1][numLargo-1] = tabla [i-1][numLargo-1] + 1;
                                }
                            }

                            if (tabla  [i-1][numLargo-2] == null)
                            {
                                tabla  [i-1][numLargo-2] = 1;
                            }
                            else
                            {
                                if(tabla [i-1][numLargo-2] != 0)
                                {
                                    tabla [i-1][numLargo-2] = tabla [i-1][numLargo-2] + 1;
                                }
                            }

                            if (tabla [i][numLargo-2] == null)
                            {
                                tabla [i][numLargo-2]  = 1;
                            }
                            else
                            {
                                if(tabla [i][numLargo-2] != 0)
                                {
                                    tabla [i][numLargo-2] = tabla [i][numLargo-2] + 1;
                                }
                            }

                            if (tabla  [i+1][numLargo-2] == null)
                            {
                                tabla  [i+1][numLargo-2]  = 1;
                            }
                            else
                            {
                                if(tabla [i+1][numLargo-2] != 0)
                                {
                                    tabla [i+1][numLargo-2] = tabla [i+1][numLargo-2] + 1;
                                }
                            }

                            if (tabla [i+1][numLargo-1] == null)
                            {
                                tabla [i+1][numLargo-1] = 1;
                            }
                            else
                            {
                                if(tabla [i+1][numLargo-1] != 0)
                                {
                                    tabla [i+1][numLargo-1] = tabla [i+1][numLargo-1] + 1;
                                }
                            }
                        }

                        else if (i == numLargo - 1 && j != 0 && j != numLargo - 1)
                        {
                            if (tabla [numLargo-1][j-1] == null)
                            {
                                tabla [numLargo-1][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [numLargo-1][j-1] != 0)
                                {
                                    tabla [numLargo-1][j-1] = tabla [numLargo-1][j-1] + 1;
                                }
                            }

                            if (tabla  [numLargo-2][j-1] == null)
                            {
                                tabla  [numLargo-2][j-1] = 1;
                            }
                            else
                            {
                                if(tabla  [numLargo-2][j-1] != 0)
                                {
                                    tabla  [numLargo-2][j-1] = tabla  [numLargo-2][j-1] + 1;
                                }
                            }

                            if (tabla  [numLargo-2][j] == null)
                            {
                                tabla  [numLargo-2][j] = 1;
                            }
                            else
                            {
                                if(tabla  [numLargo-2][j] != 0)
                                {
                                    tabla  [numLargo-2][j] = tabla  [numLargo-2][j] + 1;
                                }
                            }

                            if (tabla  [numLargo-2][j+1] == null)
                            {
                                tabla  [numLargo-2][j+1] = 1;
                            }
                            else
                            {
                                if(tabla  [numLargo-2][j+1] != 0)
                                {
                                    tabla  [numLargo-2][j+1] = tabla [numLargo-2][j+1] + 1;
                                }
                            }

                            if (tabla  [numLargo-1][j+1] == null)
                            {
                                tabla  [numLargo-1][j+1] = 1;
                            }
                            else
                            {
                                if(tabla  [numLargo-1][j+1] != 0)
                                {
                                    tabla  [numLargo-1][j+1] = tabla [numLargo-1][j+1] + 1;
                                }
                            }
                        }
                        else
                        {
                            if (tabla [i-1][j-1] == null)
                            {
                                tabla  [i-1][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [i-1][j-1] != 0)
                                {
                                    tabla [i-1][j-1]= tabla [i-1][j-1] + 1;
                                }
                            }

                            if (tabla [i][j-1] == null)
                            {
                                tabla [i][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [i][j-1] != 0)
                                {
                                    tabla [i][j-1] = tabla [i][j-1] + 1;
                                }
                            }

                            if (tabla [i+1][j-1] == null)
                            {
                                 tabla [i+1][j-1] = 1;
                            }
                            else
                            {
                                if(tabla [i+1][j-1] != 0)
                                {
                                    tabla [i+1][j-1] = tabla [i+1][j-1] + 1;
                                }
                            }

                            if (tabla [i+1][j] == null)
                            {
                                tabla [i+1][j] = 1;
                            }
                            else
                            {
                                if(tabla [i+1][j] != 0)
                                {
                                    tabla [i+1][j] = tabla [i+1][j] + 1;
                                }
                            }

                            if (tabla [i+1][j+1] == null)
                            {
                                tabla [i+1][j+1] = 1;
                            }
                            else
                            {
                                if(tabla [i+1][j+1] != 0)
                                {
                                    tabla [i+1][j+1] = tabla [i+1][j+1] + 1;
                                }
                            }

                            if (tabla [i][j+1] == null)
                            {
                                tabla [i][j+1] = 1;
                            }
                            else
                            {
                                if(tabla [i][j+1] != 0)
                                {
                                    tabla [i][j+1]= tabla [i][j+1] + 1;
                                }
                            }

                            if (tabla [i-1][j+1] == null)
                            {
                                tabla [i-1][j+1]= 1;
                            }
                            else
                            {
                                if(tabla [i-1][j+1] != 0)
                                {
                                    tabla [i-1][j+1] = tabla [i-1][j+1] + 1;
                                }
                            }

                            if (tabla [i-1][j] == null)
                            {
                                tabla [i-1][j] = 1;
                            }
                            else
                            {
                                if(tabla [i-1][j] != 0)
                                {
                                    tabla [i-1][j] = tabla [i-1][j] + 1;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public static void validadorTamanoTablero() //Este método valida que el taaño del tablero sea un numero
    {
        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("¿De cuánto por cuánto desea el tablero?  Escriba el número");
        String input = scan.nextLine();
        while (validInput == false)
        {

            try
            {
                buscaminas.numLargo = Integer.valueOf(input);
                if(buscaminas.numLargo > 1)
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("No se puede hacer una tabla con un 1 o menor que un 1 ");
                    System.out.println("Introduce otro número");
                    input = scan.nextLine();
                }

            }

            catch (Exception e)
            {
                System.out.println("Lo que introdujo no es un número");
                System.out.println("Introduce una respuesta válida");
                input = scan.nextLine();
            }
        }
    }

    public static void validadorNumMinas()  //Aquí valida que el numero de minas
    {



        boolean validInput = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("¿Cuántas minas desea en el tablero?  Escriba el número");
        String input = scan.nextLine();

        int limite = (buscaminas.numLargo*buscaminas.numLargo);

        while (validInput == false)
        {

            try
            {
                buscaminas.numMinas = Integer.valueOf(input);  //Trata de convertir el input a entero, si on puede, le a decir que introdusca otra cosa.

                if (buscaminas.numMinas >= 1  && buscaminas.numMinas < limite)
                {
                    validInput = true;

                }
                else
                {
                    int limUsuario = limite - 1;  //Para que el juegador sepa de que numero a que numero puede poner

                    System.out.println("escriba un numero entre el 1 y el "+ limUsuario);
                    input = scan.nextLine();
                }
            }

            catch (Exception e)
            {
                System.out.println("Lo que introdujo no es una opción válida");
                System.out.println("Introduce una respuesta válida");
                input = scan.nextLine();
            }
        }
    }

   

}
