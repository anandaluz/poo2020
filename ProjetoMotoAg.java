package projetomotoag;

import java.util.Scanner;

public class ProjetoMotoAg {

    public static void main(String[] args) {
        
        MotoA moto = new MotoA();
        Scanner scan = new Scanner(System.in);
        
        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");
            
            if(entradaUsuario[0].equals("end")){ //comparação de strings
                break;
            }
            else if(entradaUsuario[0].equals("embarcar")){
                int idade = Integer.parseInt(entradaUsuario[0]);
                moto.embarcar(entradaUsuario[1], idade);
            }
            else if(entradaUsuario[0].equals("desembarcar")){
                moto.desembarcar();
            }
            else if(entradaUsuario[0].equals("dirigir")){
                moto.dirigir();
            }
            else{
                System.out.println("Comando inválido");
            }
        }
    }
    
}
