import java.util.ArrayList;
import java.util.Scanner;

class Produto{
    public String nome;
    public int unidade;
    public float valor;

    public Produto(String nome, int unidade, float valor){
        this.nome = nome;
        this.unidade = unidade;
        this.valor = valor;
    }

    public String toString() {

        return nome + " : " + unidade + "U : " + valor + " RS";
    }
}

class Maquina {
    private ArrayList<Produto> espirais;
    Produto produto;
    float saldo;
    int maxProdutos;

    public Maquina(int capacidade, int maxProdutos) {
        espirais = new ArrayList<Produto>();
        for (int i = 0; i < capacidade; i++)
            espirais.add(produto);
    }

    public int getCapacidade() {

        return espirais.size();
    }

    public float getSaldo() {

        return saldo;
    }

    public void inserir(float saldo) {

        this.saldo += saldo;
    }

    public boolean adicionar(String nome, int unidade, float valor, int indice) {
        if (indice < 0 || indice >= getCapacidade()) {
            System.out.println("Índice inválido!!");
            return false;
        }
        else if (espirais.get(indice) != null) {
            System.out.println("Espiral já ocupada");
            return false;
        }
        else if (unidade > maxProdutos){
            System.out.println("Não é suportado essa quantidade de produtos");
            return false;
        }
        for (Produto produto : espirais) {
            if (produto != null && produto.nome.equals(nome)) {
                System.out.println("Produto já adicionado!!");
                return false;
            }
        }
        espirais.set(indice, new Produto(nome, unidade, valor));
        return true;
    }

    public boolean resetar(int indice) {
        if (espirais.get(indice) == null) {
            System.out.println("Espiral vazia");
            return false;
        }

        espirais.set(indice, null);
        return true;
    }

    public float comprar(int indice, int unidade){
        if(getSaldo() == 0 || getSaldo() < produto.valor){
            System.out.println("Saldo insuficiente");
            return saldo;
        }
        else if(espirais.equals(null)){
            System.out.println("Espiral vazia");
            return this.saldo;
        }
        else if (produto.unidade <=0){
            System.out.println("Não há produto disponível");
            return this.saldo;
        }
        else if (produto.unidade - unidade <=0){
            System.out.println("Quantidade de produto insuficiente");
            return this.saldo;
        }
        else {
            System.out.println(produto.nome);
            produto.unidade -= unidade;
            return this.saldo -= produto.valor;
        }
    }

    public String toString(){

        String saida = "Saldo: " + getSaldo()+ " RS\n";
        int i = 0;
        for(Produto produto : espirais){
            if(produto == null){
                saida += +i+ " vazio : 0 U : 0.00 RS\n";
            }
            else
                saida += +i+ " [" + produto + "]\n";
            i++;
        }
        return saida;

    }
}

public class JunkFood {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Maquina maquina = new Maquina(0, 0);

        while(true){
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");

            if(entradaUsuario[0].equals("end")){
                break;
            }
            else if(entradaUsuario[0].equals("show")){
                System.out.println(maquina);
            }
            else if(entradaUsuario[0].equals("adicionar")){
                maquina.adicionar(entradaUsuario[1], Integer.parseInt(entradaUsuario[2]),
                        Float.parseFloat(entradaUsuario[3]), Integer.parseInt(entradaUsuario[4]));
            }
            else if(entradaUsuario[0].equals("iniciar")){
                maquina = new Maquina(Integer.parseInt(entradaUsuario[1]), Integer.parseInt(entradaUsuario[2]));
            }
            else if(entradaUsuario[0].equals("comprar")){
                maquina.comprar(Integer.parseInt(entradaUsuario[1]), Integer.parseInt(entradaUsuario[2]));
            }
            else if(entradaUsuario[0].equals("resetar")){
                maquina.resetar(Integer.parseInt(entradaUsuario[1]));
            }
            else if(entradaUsuario[0].equals("inserir")){
                maquina.inserir(Float.parseFloat(entradaUsuario[1]));
            }
            else {
                System.out.println("Comando inválido");
            }
        }
    }
}
