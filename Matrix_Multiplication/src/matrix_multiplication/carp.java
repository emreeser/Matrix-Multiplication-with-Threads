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
import java.io.*;
import java.util.*;

public class carp extends Thread{
    dosya2 d2=new dosya2();//ikinci matris
    
    private int []x=new int[d2.satir_say()];//ikinci matrisin satır sayısıyla birinci matrisin sütunu eşit eleman sayısı içerdiğinden 
                                                  // ikinci matrisin satır sayısı büyüklüğünde dizi oluşturduk      
                        
    
    public carp(int[] x) {  //constructor
        this.x = x;
    }
    @Override
    public void run() {
        try(Scanner scanner=new  Scanner(new FileReader("matrix2.txt"))){
            dosya2 ds2=new dosya2();
            int sec_rows=ds2.satir_say();//ikinci matris satır sayısı
            int sec_columns=ds2.sutun_say(); //ikinci matris sütun sayısı
            String []line=new String[sec_rows*sec_columns];//ikinci matris eleman sayısı büyüklüğünde elemanlara erişme dizisi
            int [] matriks = new int[sec_rows*sec_columns];//String elemanları int diziye çekme dizisi
            int co=0;//diziyi iki boyutluya çevirirken işimize yarayacak sayaç
            dosya1 ds3=new dosya1();
            int sa=ds3.satir_say();//ilk matris satır sayısı
            int su=ds3.sutun_say();//ilk matris sütun sayısı
            int ikid[][]=new int[sec_rows][sec_columns];//işlemlerimizi yapmak için matris elemanları için iki boyutlu dizi
            int[]sonuc=new int[sec_columns];//sonuç matrisi satır satır olacağı için dizi
            while(scanner.hasNextLine()) {
                for(int q=0;q<sec_rows*sec_columns;q++){
                    line = scanner.next().trim().split(" "); //ikinci matrisin elemanlarına ulaşmak için parçalama metodu
                    matriks[q]=Integer.parseInt(line[0]);  // ayrışan elemanları integer tipine çevirip diziye atma
                }
                for(int v=0;v<sec_rows;v++){
                    for(int m=0;m<sec_columns;m++){
                        ikid[v][m]=matriks[co]; //diziyi iki boyulu diziye çevirme
                        co++;
                    }
                }
            }//while bitişi
            
            
               for(int m=0;m<sec_columns;m++){
                for(int v=0;v<su;v++){           
                   sonuc[m]+=x[v]*ikid[v][m];        //birinci dizinin satır elemanlarıyla ikinci dizinin 
                                                    //elemanlarının çarpılması ve sonuc diziye aktarılması
                }}
            
            for (int i=0; i<sec_columns; i++) {
                System.out.print(sonuc[i]+"  ");   //sonuc matrisinin yazılması
            }
            System.out.println("");//matris sonucunun düzenli görünmesi için alt satıra inme
        }//try bitişi
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!!!");
        } catch (IOException ex) {
                System.out.println("Dosya açılırken hata oluştu!");
        }
        }
        
        
    }
