package projetomochila;
import java.util.Scanner;

public class ProjetoMochila {

    public static void main(String[] args) {
       Mochila mochila = new Mochila();
       Scanner scan = new Scanner(System.in);
       
       while(true){
           String linha = scan.nextLine();
           String entradaUsuario[] = linha.split(" ");
           
           if(entradaUsuario[0].equals("end")){
               break;
           }
           else if(entradaUsuario[0].equals("colocar")){
               int qnt = Integer.parseInt(entradaUsuario[1]);
               mochila.colocar(qnt);
           }
           else if (entradaUsuario[0].equals("tirar")){
               int qnt = Integer.parseInt(entradaUsuario[1]);
               mochila.tirar(qnt);
           }
           else if (entradaUsuario[0].equals("abrir")){
               String a = null;
               mochila.abrir(a);
           }
           else if(entradaUsuario[0].equals("fechar")){
               mochila.fechar();
           }
           else if(entradaUsuario[0].equals("show")){
               mochila.show();
           }
           else{
               System.out.println("Comando invalido");
           }
       }
    }
    
}
