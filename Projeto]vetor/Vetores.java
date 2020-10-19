package vetores;
import java.util.ArrayList;
import java.util.Scanner;

public class Vetores {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.add(7);
        lista.add(0);
        lista.add(2);
        lista.add(3);
        lista.add(9);
        lista.add(0);
        
            while(true){
                String linha = scan.nextLine();
                String entradaUsuario[] = linha.split(" ");
                
                if(entradaUsuario[0].equals("end")){
                    break;
                }
                else if(entradaUsuario[0].equals("adicionar")){             //adicionar os valores na lista
                    for(int i = 1; i < entradaUsuario.length; i++){
                        lista.add(Integer.parseInt(entradaUsuario[i]));
                    }
                }
                else if(entradaUsuario[0].equals("show")){                   //mostrar a lista
                    for (int i = 0; i < lista.size(); i++){    
                    }
                    System.out.println(lista);
                }
                else if(entradaUsuario[0].equals("showinver")){
                    for(int i = lista.size() - 1; i >= 0; --i)
			System.out.print(lista.get(i) + " ");
                }
                else if(entradaUsuario[0].equals("get")){
                    int posição = Integer.parseInt(entradaUsuario[1]);
                    System.out.print(lista.get(posição));
                }
                else if(entradaUsuario[0].equals("set")){                     //mudar valor de uma posição
                    int posição = Integer.parseInt(entradaUsuario[1]);
                    int valor = Integer.parseInt(entradaUsuario[2]);
                    lista.set(posição, valor);
                }
                else if(entradaUsuario[0].equals("procurar")){
                    for(int i = 1; i < entradaUsuario.length; i++){
                        if(entradaUsuario[1] == null){
                            System.out.println("-1");
                        }
                        else{
                            System.out.println("Elemento na posição: " + lista.indexOf(Integer.parseInt(entradaUsuario[i])));
                        }
                    }
                }
                else if(entradaUsuario[0].equals("remover")){
                    int indice = Integer.parseInt(entradaUsuario[1]);
                    if(indice < 0 || indice > lista.size()){
                        System.out.println("Indice nao existe");
                    }
                    else{
                        lista.remove(Integer.parseInt(entradaUsuario[1]));
                    }
                }
                else if(entradaUsuario[0].equals("rma")){
                    int valor = Integer.parseInt(entradaUsuario[1]);
                    for(int i = 0; i < lista.size(); i++){
                        if (valor == lista.get(i)) {
			    lista.remove(i);
                            i--;
			}
                    }
                }
                else{
                    System.out.println("Comando inválido");
                }
     
            }
    }
}