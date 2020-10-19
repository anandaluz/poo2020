import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class  Fone  {
    String foneId;
    String número;

    Fone (String foneId, String número)  {
        this.foneId  =  foneId;
        this.número  =  número;
    }

    public String toString() {
        return "["  +  this.foneId  +  ":"  +  this.número  +  "]" ;
    }
}

class Contato {
    String nome;
    ArrayList<Fone> fones;
    boolean favorito;

    public Contato(String nome) {
        this.nome = nome;
        fones = new ArrayList<>();
    }

    public String toString() {
        String saida = "- " + this.nome;
        int i = 0;
        for (Fone fone : fones) {
            if (this.favorito == true) {
                saida += "@" + this.nome + "[" + i + ":" + fone + "]";
                i++;
            } else {
                saida += "-" + this.nome + "[" + i + ":" + fone + "]";
                i++;
            }
        }
        return saida;
    }
}

class Agenda {
    Map<String, Contato> contatos;
    Map<String, Contato> favoritos;
    Contato contato;

    public Agenda() {
        contatos = new TreeMap<String, Contato>();
        favoritos = new TreeMap<String, Contato>();
    }

    public Contato getContato(String nome) {
        if (this.contatos.equals(nome)) {
            System.out.println("Não existe contato com esse nome");
        }
        return this.contatos.get(nome);
    }

    public void addContato(Contato contato) {
        if (this.contatos.equals(contato.nome)) {
            System.out.println("Nome já existe");
        } else {
            this.contatos.set(contato.nome, contato);
        }
    }

    public void rmvContato(String nome) {
        if (this.contatos.equals(nome)) {
            System.out.println("Não existe contato com esse nome");
        } else {
            this.contatos.remove(nome);
        }
    }

    public void favoritar(String nome) {
        //String contato = this.contatos.get(nome);
        if(contato.favorito == true){
            System.out.println("Contato já favoritado");
        }
        else {
            this.favoritos.put(nome, contato);
            contato.favorito = true;
        }
    }

    public void desfavoritar(String nome) {
        if(contato.favorito == true){
            System.out.println("Contato já favoritado");
        }
        else {
            this.favoritos.remove(nome, contato);
            contato.favorito = false;
        }
    }

    public Map<String, Contato> getContatos() {

        return this.contatos;
    }

    public Map<String, Contato> getFavoritos() {
        return favoritos;
    }
}

    /*  */

public class Controle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            String linha = scan.nextLine();
            String entradaUsuario[] = linha.split(" ");

            if (entradaUsuario[0].equals("end")) {
                break;
            } else if (entradaUsuario[0].equals("show")) {
                agenda.getContato(entradaUsuario[1]);
            } else if (entradaUsuario[0].equals("add")) {
                agenda.addContato(new Contato(entradaUsuario[1]));
            } else if (entradaUsuario[0].equals("rmv")) {
                agenda.rmvContato(entradaUsuario[1]);
            } else if (entradaUsuario[0].equals("favoritar")) {
                agenda.favoritar(entradaUsuario[1]);
            } else if (entradaUsuario[0].equals("desfavoritar")) {
                agenda.desfavoritar(entradaUsuario[1]);
            } else if (entradaUsuario[0].equals("showF")) {
                System.out.println(agenda.favoritos);
            } else if (entradaUsuario[0].equals("showT")) {
                System.out.println(agenda);
            } else {
                System.out.println("Comando inválido");
            }
        }
    }
}

