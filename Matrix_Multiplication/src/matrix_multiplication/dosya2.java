/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_multiplication;

/**
 *
 * @author EMRE ESER
 */
import java.util.*;
import java.io.*;
public class dosya2 {
    
    //ikinci matrisin bulunduğu txt uzantılı dosyayı okuma ve satır sütun sayılarına ulaşma classs ı
    
    private int satir2=0;
    private int sutun2=0;
    public int satir_say(){
    try(Scanner scanner=new  Scanner(new FileReader("matrix2.txt"))){
         while(scanner.hasNextLine()){
                
                satir2++; 
                scanner.nextLine();
         }     
    }
    
    catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
        return satir2;
    
    
    
    }   
    public int sutun_say(){
    try(Scanner scanner=new  Scanner(new FileReader("matrix2.txt"))){
         while(scanner.hasNextLine()){
                
                 
                String[] line = scanner.nextLine().trim().split(" ");
                sutun2=line.length;
         }      
    }
    
    catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
        return sutun2;
    }   
}
