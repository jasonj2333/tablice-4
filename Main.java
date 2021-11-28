import java.io.*;
import java.util.*;

public class Main {

  public static void losuj_tablice(int[][] m, int x, int y, int h) {
      Random rand = new Random();
      for ( int i = 0; i < x; i++ ) {
          for ( int j = 0; j < y; j++ ) {

              m[i][j] = rand.nextInt(h+1);
              System.out.println("Element ["+i+"]["+j+"]: " + m[i][j]);
          }
        }
    }

   public static void main(String[] args) {
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int x, y;
         System.out.println("Podaj liczbe wierszy macierzy: ");
         x = Integer.parseInt(in.readLine());
         System.out.println("Podaj liczbe kolumn macierzy: ");
         y = Integer.parseInt(in.readLine());        
         int[][] m = new int[x][y];
         losuj_tablice(m, x, y, 100);
        //  for ( int i = 0; i < x; i++ ) {
        //     for ( int j = 0; j < y; j++ ) {
        //        System.out.println("Podaj element ["+i+"]["+j+"]: ");
        //        m[i][j] = Integer.parseInt(in.readLine());
        //     }
        //  }
         
         int min_x = 0, min_y = 0, min_i;
         int[] min_w = new int[x];
         for ( int i = 0; i < x; i++ ) {
            min_i = 0;
            for ( int j = 0; j < y; j++ ){
               if ( m[i][j] < m[min_x][min_y] ) {
                  min_x = i;
                  min_y = j;
               }

               if ( m[i][j] < m[i][min_i] ) {
                  min_i = j;
               }
            }
            min_w[i] = min_i;
         }
         
         System.out.println("Najmniejszy element znajduje sie w wierszu nr "+
                            (min_x)+" i kolumnie nr "+(min_y)+
                            " a jego wartosc wynosi "+m[min_x][min_y]);
        
        int max_min=0, value;
        int suma = 0;
        for ( int i = 0; i < x; i++ ){
          value = m[i][min_w[i]];
          suma += value;
           System.out.println("Najmniejszy element w wierszu nr " + i + " wynosi: " + value);
           if ( value > m[max_min][min_w[max_min]] ) {
                  max_min = i;
            }
        }
        System.out.println("Największy z mininum jest w wierszu nr " + max_min + " wynosi: " + m[max_min][min_w[max_min]]);
        System.out.println("Średnia z mininum wynosi: " + suma / (float)x);
      } catch(IOException e) {
      }
   }
}

/*
 * Cwiczenia:
 * 1. Znajdz najwieksze z minimow poszczegolnych wierszy.
 * 2. Policz srednia minimow wierszy.
 */

 
