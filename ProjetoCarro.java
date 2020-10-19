package projetocarro;
import java.util.Scanner;

public class Carro {
    
    int nPessoas = 0;
    int nMaxPessoas = 5;
    int caber;
    int km = 0;
    int maxKm = 20;
    int gasolina = 0;
    int maxGasolina = 20;
    int qntGasolina;
    
    void embarcar(int qnt){
        if(qnt < 0){
            return;
        }
        else if(nPessoas + qnt > nMaxPessoas){
            caber = nMaxPessoas - nPessoas;
            if(caber <= 0) {
                System.out.println("Sem vagas.");
                return;
            }
            else {
                System.out.println("Sem espaço, so tem vaga para "+(caber)+" pessoa(s).");
                return;
            }
            
        }
        this.nPessoas += qnt;
        System.out.println("Pode entrar");
    }
    
    void desembarcar(int qnt){
        if(qnt < 0){
            return;
        }
        else if(qnt > nPessoas){
            System.out.println("So tem "+(nPessoas)+" no carro");
            return;
        }
        this.nPessoas -= qnt;
        System.out.println("Saindo");
    }
    
    void rodar(int qnt){
        if(qnt < 0){
            return;
        }
        else if(gasolina == 0 || nPessoas <= 0){
            System.out.println("Precisa de gente no carro e/ou abastecer primeiro");
            return;
        }
        else if(km + qnt > maxKm){
            System.out.println("Nao tem quantidade suficiente pra rodar tudo isso");
            return;
        }
        this.km += qnt;
        System.out.println("Rodando");
    }
    
    void abastecer(int qnt){
        if(km + qnt <= 0){
            return;
        }
        else if(gasolina + qnt > maxGasolina){
            System.out.println("So cabem 20 litros");
            return;
        }
        this.gasolina += qnt;
        System.out.println("Abastecendo");
    }   
    
    void show(){
        System.out.println("N de pessoas no carro: " + this.nPessoas);
    }
    
    void quilometros(){
        System.out.println("Quilometro(s) rodado(s): " + this.km);
    }
    
    void tanque(){
        qntGasolina = gasolina - km;
        if(qntGasolina == 0){
            System.out.println("Sem gasolina");
        } else 
            System.out.println("Ainda tem " +this.qntGasolina+ " de gasolina");
    }
}   
    

public class ProjetoCarro {

    public static void main(String[] args) {
        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");
            
            if(entradaUsuario[0].equals("end")){ //comparação de strings
                break;
            }
            else if(entradaUsuario[0].equals("show")){
                carro.show();
            }
            else if(entradaUsuario[0].equals("abastecer")){
                int qnt = Integer.parseInt(entradaUsuario[1]); //entradaUsuário é uma string, o método embarcar espera um int
                carro.abastecer(qnt);                          //Integer.parseInt transformar uma string em um inteiro        
            }
            else if(entradaUsuario[0].equals("embarcar")){
                int qnt = Integer.parseInt(entradaUsuario[1]); //entradaUsuário é uma string, o método embarcar espera um int
                carro.embarcar(qnt);                          //Integer.parseInt transformar uma string em um inteiro        
            }
            else if(entradaUsuario[0].equals("desembarcar")){
                int qnt = Integer.parseInt(entradaUsuario[1]);
                carro.desembarcar(qnt);
            }
            else if(entradaUsuario[0].equals("rodar")){
                int qnt = Integer.parseInt(entradaUsuario[1]);
                carro.rodar(qnt);
            }
            else if(entradaUsuario[0].equals("quilometros")){
                carro.quilometros();
            }
            else if(entradaUsuario[0].equals("tanque")){
                carro.tanque();
            }
            else 
               System.out.println("Comando inválido");
            
        }
                    
    }
}
