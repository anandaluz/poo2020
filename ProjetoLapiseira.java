package projetolapiseira;
import java.util.Scanner;

class Grafite{
    
    float ponta;
    
    public Grafite(float ponta){
        this.ponta = ponta;
    }
}

public class Lapiseira {
    
    Grafite grafite;
    float tamanho = 0;
    float desgaste = 0;
    float maxTamanho = 9;
    
    void iniciar(Grafite grafite){ 
        if(this.grafite == null){
            this.grafite = grafite;
            System.out.println("Iniciando");
        }
        else{
            System.out.println("Projeto iniciado, retire os grafites");
        }
    }
    
    void inserir(float qnt){
        if(this.grafite == null){
            System.out.println("Voce nao iniciou sua lapiseira");
            return;
        }
        else if(this.grafite.ponta != 0.5){
            System.out.println("Ponta do grafite nao suportada");
        }
        else if(qnt < 0){
            return;
        }
        else if((qnt*3) + tamanho > this.maxTamanho){
            System.out.println("Quantidade nao suportada");
            return;
        }
        this.tamanho += (qnt*3);
        System.out.println("" + this.tamanho);
    }
    
    void escrever(float qnt){
        
        //desgaste = (int) (tamanho - (qnt*0.1));  
        //System.out.println("" + this.desgaste);
        
        if (this.grafite == null){
            System.out.println("Voce nao iniciou sua lapiseira");
        }
        else if (this.tamanho == 0){
            System.out.println("Sem grafite");
        }
        else if(this.tamanho - (qnt*0.1) < 0){
            System.out.println("Voce nao pode escrever esse tanto");
            return;
        }
        else if(this.tamanho - (qnt*0.1) == 0){
            System.out.println("Seus grafites acabaram");  
        }                                                  
        this.tamanho -= (qnt*0.1);
        System.out.println("" +this.tamanho);
    }
    
    void retirar(){
        if(this.grafite != null){
            this.grafite = null;
            System.out.println("Grafite retirado");
        }
        else {
            System.out.println("Lapiseira sem grafite");
        }
    }
}

public class ProjetoLapiseira {

    public static void main(String[] args) {
        
        Lapiseira lapiseira = new Lapiseira();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");
            
            if(entradaUsuario[0].equals("end")){ 
                break;
            }
            else if(entradaUsuario[0].equals("iniciar")){
                float ponta = Float.parseFloat(entradaUsuario[1]);       
                Grafite grafite = new Grafite(ponta);  
                lapiseira.iniciar(grafite);
                //lapiseira.iniciar(new Grafite(Float.parseFloat(entradaUsuario[1])));
            }
            else if(entradaUsuario[0].equals("inserir")){
                float qnt = Float.parseFloat(entradaUsuario[1]);
                lapiseira.inserir(qnt);
            }
            else if(entradaUsuario[0].equals("retirar")){
                lapiseira.retirar();
            }
            else if(entradaUsuario[0].equals("escrever")){
                float qnt = Float.parseFloat(entradaUsuario[1]);
                lapiseira.escrever(qnt);
            }
            else{
                System.out.println("Comando inválido");
            }
        }
    
}
}