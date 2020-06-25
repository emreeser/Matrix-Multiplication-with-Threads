
package matrix_multiplication;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author EMRE ESER
 */
public class Matrix_Multiplication {

    public static void main(String[] args) {
        dosya1 ds1 =new dosya1();
        int first_rows=ds1.satir_say();
        int first_columns=ds1.sutun_say();
        String []line=new String[first_columns];
        int [][] matriks = new int[first_rows][first_columns];
        int [] gecici=new int[first_rows*first_columns];
        int [] aktar=new int[first_columns];
        try(Scanner scanner=new  Scanner(new FileReader("matrix1.txt"))){ //ilk matris okuma 
         
         int sayac=0;  
         while(scanner.hasNextLine()) {
             
             for(int i=0;i<first_rows*first_columns;i++){
                 line = scanner.next().trim().split(" ");//ilk matrisin elemanlarına ulaşmak için parçalama metodu
                 
                 gecici[i]=Integer.parseInt(line[0]);// ayrışan elemanları integer tipine çevirip diziye atma
                 
             }
             
         }//while bitişi     
             for(int r=0;r<first_rows;r++){ // n adet(satır sayısı) thread için for
                 
                 
                 for(int x=0;x<first_columns;x++){
                     
                     aktar[x] = gecici[sayac]; // sütun elemanlarını aktar dizisine atmak
                      sayac++;
                 }// x değişkenli for bitişi
                 carp cr=new carp(aktar); // thread oluşturulur aktar dizisi elemanlarını içerir
                 cr.start();
                 try {
                     cr.join(); //thread senkronizasyonunu sağlar
                 } catch (InterruptedException ex) {
                     System.out.println("Thread kesintiye uğradı!!!");
                 }
                 
             }// r değişkenli for bitişi
           
        }//try bitişi 
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
    }
    
}
