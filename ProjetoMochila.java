package projetomochila;
import java.util.Scanner;

public class Mochila {
    
    int nObjetos = 0;
    int maxObjetos = 10;
    int caber;
    int aberto = 0;
    
    void colocar(int qnt){
        if(qnt <= 0){
            return;
        }
        else if(aberto == 0){
            System.out.println("Precisa abrir a mochila");
            return;
        }
        else if(qnt + nObjetos > maxObjetos){
            caber = maxObjetos - nObjetos;
            if(caber <= 0){
                System.out.println("Nao cabe mais objetos, voce preencheu os " +(maxObjetos)+" espaços");
                return;
            } else {
                System.out.println("Espaço para " +(caber)+ " objeto(s)");
                return;
            }
        }
        this.nObjetos += qnt;
        System.out.println("Colocando");
        
    }
    
    void tirar(int qnt){
        if(qnt <= 0) {
            return;
        }
        else if(qnt > nObjetos){
            System.out.println("A mochila nao tem essa quantidade de objetos");
            return;
        }
        this.nObjetos -= qnt;
        System.out.println("Tirando");
    }
    
    void fechar(){
        System.out.println("Fechando");
        this.aberto = 0;
    }
    void abrir(String a){
        this.aberto++;
        System.out.println("Abrindo");
    }
    
    void show(){
        System.out.println("N de obejtos na mochila: "+this.nObjetos);
    }
}

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
