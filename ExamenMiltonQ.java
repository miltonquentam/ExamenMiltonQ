/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.algoritmosgamaven;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Software Student
 */
public class ExamenMiltonQ {
    public int[][] leerArchivo(File file){
    int[][] matriz=null;
    int contadorFila=0, catColumna=0;
    Scanner s=null;
        try {
            s=new Scanner(file);
            while (s.hasNextLine()) {                
                String linea=s.nextLine();
                if (contadorFila==1) {
                    String[] vector=linea.split("\t");
                    catColumna=vector.length;
                }
                contadorFila++;
            }
            
            
            s=new Scanner(file);
            matriz=new int[contadorFila-1][catColumna];
            contadorFila=0;
            
            while (s.hasNextLine()) {                
                String linea=s.nextLine();
                if (contadorFila!=0) {
                    String[] vector=linea.split("\t");
                    for (int i = 0; i < vector.length; i++) {
                        matriz[contadorFila-1][i]=Integer.parseInt(vector[i].trim());
                    }
                }
                contadorFila++;
            }                                    
        } catch (IOException e) {
        }finally{
            try {
                s.close();
            } catch (Exception e) {
            }
        }            
    return matriz;
    }
    
    public void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    public void escribirArchivo(String[] head, int[][] data, String nameFile){
        Writer out=null;
        int contador=0;
        try {
        String url=System.class.getResource("/").getFile().replaceAll("%20", " ");
            System.out.println("Ruta:"+url);
            String[] urlReal=url.split("target");
            out=new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(urlReal[0]+"src/main/resources/"+nameFile),"UTF-8"));
            if (head!=null && data!=null) {
                
            }else if(head==null && data!=null){
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[0].length; j++) {
                        try {
                            out.write(data[i][j]+"\t");
                            if (i<data.length-1) {
                                if(j==data[0].length-1){
                                out.write("\n");
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }else{
                System.out.println("Los parametros de entrada estan vacios");
            }
            
        } catch (Exception e) {
        }finally{
            try {
                out.close();
            } catch (Exception e) {
            }
        }    
    }
    
   public int[][] transformada06MiltonQ(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        int contador=0;
        for (int i = 0; i < matriz.length;i++) {
            for (int j = 0; j < matriz[0].length; j++){
                if(contador<=i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }
        
       return matriz; 
    }
   public int[][] transformada25MiltonQ(int dim, int numInit){
        int contador=0;
          int[][] matriz=new int[dim][dim];
          for (int x = 0; x < matriz.length; x++) {
              if(contador%2==0){
                  for (int y = 0; y < matriz[0].length; y++) {
                      matriz[x][y]=numInit;
                      numInit++;
                  }
              }else{
                  for (int y = matriz[0].length-1; y >=0; y--) {
                      matriz [x][y]=numInit;
                      numInit++;
                  }
              }
              contador++;
        }
        return matriz;
    }
   public int[][] transformada11MiltonQ(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        int contador=0;
        for (int i = 0; i < matriz.length;i++) {
            for (int j = matriz[0].length-1; j>=0; j--){
                if(j<dim-i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }
        
       return matriz; 
    }
   public int[][] transformada30MiltonQ(int dim, int numInit){
    int[][] matriz=new int[dim][dim];
        for (int c = 0; c < dim/2; c++) {
                  
            for (int ldx = c; ldx < dim-c-1; ldx++) {
                matriz[ldx][dim-1-c]=numInit;
                numInit++;                
            }
            for (int lix = dim-c-1; lix > c; lix--) {
                matriz[dim-1-c][lix]=numInit;
                numInit++;                
            }
            for (int lxx = dim-c-1; lxx > c; lxx--) {
                matriz[lxx][c]=numInit;
                numInit++;                
            }
            for (int lsx = c; lsx < dim-c-1; lsx++) {
                matriz[c][lsx]=numInit;
                numInit++;
            }      
        }
        
        if(dim%2!=0){
        matriz[dim/2][dim/2]=numInit--;
        }
        
        return matriz;
     }
   public int[][] transformada07MiltonQ(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        int contador=0;
        for (int i = 0; i < matriz.length;i++) {
            for (int j = 0; j < matriz[0].length; j++){
                if(j<dim-i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }
        
       return matriz; 
    }
    public static void main(String[] args) {
        ExamenMiltonQ lea=new ExamenMiltonQ();//Objeto lea
        URL fileUrl=System.class.getResource("/02-exemplo7.txt");
        System.out.println("Ruta:"+fileUrl.getFile());
        System.out.println("Ruta real:"+fileUrl.getFile().replaceAll("%20", " "));
        lea.imprimirMatriz(lea.leerArchivo(new File(fileUrl.getFile().replaceAll("%20", " "))));        
        System.out.println("Escribir Archivos");
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingree la Dimension de la Matriz:");
        int dimM=sc.nextInt();
        System.out.println("Ingrese el numero de Inicio");
        int numInic=sc.nextInt();        
        lea.escribirArchivo(null, lea.transformada06MiltonQ(dimM, numInic), "Transformada06.txt");
        lea.escribirArchivo(null, lea.transformada25MiltonQ(dimM, numInic), "Transformada25.txt");
        lea.escribirArchivo(null, lea.transformada11MiltonQ(dimM, numInic), "Transformada11.txt");
        lea.escribirArchivo(null, lea.transformada30MiltonQ(dimM, numInic), "Transformada30.txt");
        lea.escribirArchivo(null, lea.transformada07MiltonQ(dimM, numInic), "Transformada07.txt");
    }
}