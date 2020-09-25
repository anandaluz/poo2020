package projetolapiseira;

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