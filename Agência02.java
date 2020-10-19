import java.util.*;

class Cliente{
    String id;
    ArrayList<Conta> contas;

    public Cliente(String id) {
        this.id = id;
        contas = new ArrayList<Conta>();
    }

    void addConta(Conta conta){

        contas.add(conta);
    }

    public String toString(){

        return id;
    }
}

class Operação {
    int id;
    double valor;

    public Operação(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }
}

class Conta{
    int id;
    double saldo;
    String idCliente;
    Operação operação;
    ArrayList<Operação> extrato;

    public Conta(int id, String idCliente){
        this.id = id;
        this.saldo = 0;
        this.idCliente = idCliente;
    }

    private void addOperação(int id, double valor) {
        saldo += valor;

        Operação operação = new Operação(id, valor);
        extrato.add(operação);

    }

    public double saque(int id, double valor) {
        if (saldo < valor) {
            System.out.println("Saldo insuficiente.");
            return saldo;
        }
        addOperação(id, saldo);
        return (saldo -= valor);
    }

    public double depósito(int id, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return saldo;
        }
        addOperação(id, saldo);
        return (saldo += valor);
    }

    public double atualizaçãoMensal(){
        return saldo;
    }

    public String toString() {

        return id + ":" + idCliente + ":" + saldo;
    }
}
class ContaCorrente extends Conta{

    public ContaCorrente(int id, String idClinte) {

        super(id, idClinte); //super chama o construtor da superclasse
    }

    public double atualizaçãoMensal() {

        return saldo -= 20;
    }

    public String toString() {

        return super.toString() + ":CC";
    }
}

class ContaPoupança extends Conta {

    public ContaPoupança(int id, String idCliente) {

        super(id, idCliente);
    }

    public double atualizaçãoMensal() {

         return saldo += saldo * 0.01;
    }

    public String toString() {

        return super.toString() + ":CP";
    }
}

class Agencia{
    Map<String, Cliente> clientes;
    Map<Integer, Conta> contas;
    int nextId;

    public Agencia(){
        clientes = new TreeMap<String, Cliente>();
        contas = new TreeMap<Integer, Conta>();
        int nextId = 0;
    }

    public void addCliente(String id){
        if(clientes.get(id) == null){
            Conta poupança = new ContaPoupança(nextId++, id);
            Conta corrente = new ContaCorrente(nextId++, id);
            Cliente cliente = new Cliente(id);
            cliente.addConta(poupança);
            cliente.addConta(corrente);
            clientes.put(id, cliente);
            contas.put(poupança.id, poupança);
            contas.put(corrente.id, corrente);
        }
    }

    public String toString() {
        String saida = "";
        for(Conta conta : contas.values()){
            saida += conta + "\n";
        }
        return saida;
    }
}

public class Controle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Agencia agencia = new Agencia();
        Conta conta = new Conta(0, null);
        ContaPoupança poupança = new ContaPoupança(0, null);
        ContaCorrente corrente = new ContaCorrente(0, null);

        while (true) {
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");

            if (entradaUsuario[0].equals("end")) {
                break;
            } else if (entradaUsuario[0].equals("show")) {
                System.out.println(agencia);
            } else if (entradaUsuario[0].equals("adicionar")) {
                agencia.addCliente(entradaUsuario[1]);
            }
            else if(entradaUsuario[0].equals("depositar")){
                conta.depósito(Integer.parseInt(entradaUsuario[1]), Double.parseDouble(entradaUsuario[2]));
            }
            else if(entradaUsuario[0].equals("sacar")){
                conta.saque(Integer.parseInt(entradaUsuario[1]), Double.parseDouble(entradaUsuario[2]));
            }
            else if(entradaUsuario[0].equals("update")){
                poupança.atualizaçãoMensal();
                corrente.atualizaçãoMensal();
                System.out.println(agencia);
            }
            else {
                System.out.println("Comando inválido");
            }
        }
    }
}