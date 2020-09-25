package tamagotchi;
import java.util.Scanner;

public class Tamagotchi {

    public static void main(String[] args) {
        
        Pet pet = null;
        Scanner scan = new Scanner(System.in);
                
        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");
            
            if(entradaUsuario[0].equals("end")){ 
                break;
            }
            else if(entradaUsuario[0].equals("iniciar")){
                int energia = Integer.parseInt(entradaUsuario[2]);
                int saciedade = Integer.parseInt(entradaUsuario[3]);   
                int limpeza = Integer.parseInt(entradaUsuario[4]);   
                pet = new Pet(entradaUsuario[1], energia, saciedade, limpeza);  
            }
            else if(entradaUsuario[0].equals("show")){
                System.out.println(pet);
            }
            else if(entradaUsuario[0].equals("brincar")){
                pet.brincar();
            }
            else if(entradaUsuario[0].equals("comer")){
                pet.comer();
            }
            else if(entradaUsuario[0].equals("dormir")){
                pet.dormir();
            }
            else if(entradaUsuario[0].equals("banhar")){
                pet.banhar();
            }
            else {
                System.out.println("Comando inválido");
            }
        }
    }
}
