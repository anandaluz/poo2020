package projetolapiseira;
import java.util.Scanner;

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