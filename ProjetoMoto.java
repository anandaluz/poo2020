package projetomoto;
import java.util.Scanner;

class Pessoa{
    String nome;
    int idade;
    
    public Pessoa (String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
}

public class Moto {

    Pessoa passageiro; 
    
    /*public Moto(){
        
    }*/
    int tempo = 0;
    int maxTempo = 10;
    int minuto;
    int resto = 0;
    int qntTempo;
    
    void embarcar(String nome, int idade){                   //passaria como parâmetro(Pessoa passageiro)
        if(this.passageiro == null){
                                                            //this.passageiro = passageiro;
            this.passageiro = new Pessoa(nome, idade);
        }
        else {
            System.out.println("Ja tem gente na moto");
        }
    }
    
    void desembarcar(){
        if(this.passageiro != null){
            this.passageiro = null;
            System.out.println("Saindo");
        }
        else {
            System.out.println("Não tem ninguém na moto.");
        }
    }
    
    void dirigir(){
        if(this.passageiro == null){
            System.out.println("Não tem ninguém na moto.");
        }
        else if(this.passageiro.idade < 2){
           System.out.println("Idade inferior ao permitido");           
        }
        else if(this.passageiro.idade > 10){
            System.out.println("Idade superior ao permitido");
        }
        else{
            System.out.println("Voce precisa pagar para adicionar tempo");
        }
    }
    void rodar(int qnt){
        if(qnt < 0){
            return;
        }
        else if(passageiro == null){
            System.out.println("Não tem ninguém na moto.");
            return;
        }
        else if(this.tempo - qnt < 0){
            System.out.println("Voce tem menos tempo que isso");
            return;
        }
        else if(this.tempo - qnt == 0){
            System.out.println("Seu tempo acabou, pague para mais tempo");
            return;
        }
        else if(this.tempo - qnt > 0){
            resto = this.tempo - qnt;
            System.out.println("Tempo restante: " + this.resto);
        }
        this.tempo -= qnt;
    }
    
    void pagar(int qnt){
        if(qnt < 0){
            return;
        }
        else if(this.tempo + qnt > maxTempo){
            System.out.println("So aceita ate 10");
            return;
        }
        this.tempo += qnt;
    }
    
    void show(){
        System.out.println("Seu tempo é: " +this.tempo);
    }
}


public class ProjetoMoto {

    public static void main(String[] args) {
        
        Moto moto = new Moto();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");
            
            if(entradaUsuario[0].equals("end")){ 
                break;
            }
            else if(entradaUsuario[0].equals("embarcar")){
                int idade = Integer.parseInt(entradaUsuario[2]);
                moto.embarcar(entradaUsuario[1], idade);
            }
            else if(entradaUsuario[0].equals("desembarcar")){
                moto.desembarcar();
            }
            else if(entradaUsuario[0].equals("dirigir")){
                moto.dirigir();
            }
            else if(entradaUsuario[0].equals("rodar")){
                int qnt = Integer.parseInt(entradaUsuario[1]);
                moto.rodar(qnt);
            }
            else if(entradaUsuario[0].equals("pagar")){
                int qnt = Integer.parseInt(entradaUsuario[1]);
                moto.pagar(qnt);
            }
            else if(entradaUsuario[0].equals("show")){
                moto.show();
            }
            else{
                System.out.println("Comando inválido");
            }
        }
}
}