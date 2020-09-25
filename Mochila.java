package projetomochila;

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