
package matrix_multiplication;

/**
 *
 * @author EMRE ESER
 */
import java.util.*;
import java.io.*;
public class dosya1 { 

    //birinci matrisin bulunduğu txt uzantılı dosyayı okuma ve satır sütun sayılarına ulaşma classs ı
    
    private int satir1=0;
    private int sutun1=0;
    public int satir_say(){
    
        try(Scanner scanner=new  Scanner(new FileReader("matrix1.txt"))){
         while(scanner.hasNextLine()){//satır boş olana kadar gider
                
                satir1++; //satır1 değişkeni satırlar geçerken artırılır
                scanner.nextLine();//bir sonraki satıra geç
               
         }     
    }
    
    catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
        return satir1;
    
    
    
    }   
    public int sutun_say(){
    try(Scanner scanner=new  Scanner(new FileReader("matrix1.txt"))){
         while(scanner.hasNextLine()){
                
                 
                String[] line = scanner.nextLine().trim().split(" ");//her satırın eleman sayısına boşlukları parçalayarak ulaşma
                sutun1=line.length;//her satırın eleman sayısı aynı olacağı için satırdaki eleman sayısını bulduk
         }      
    }
    
    catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
        return sutun1;
    }   
    
    
}