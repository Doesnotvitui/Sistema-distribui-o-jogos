import java.util.*;

public class Catalogo {
    private ArrayList<Jogo> jogos;
    
    public Catalogo() {
        this.jogos = new ArrayList<Jogo>();
    }
    
    public Catalogo(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    public void comprarJogo(String nome) {
        jogos.add(new Jogo(nome, 0, "", 0, 0, 0, 0.0));
    }
    
    public static void main (String[] args) {
        ArrayList <Jogo> jogos_catalogo = new ArrayList<Jogo>();
        ArrayList <Jogo> jogos_biblioteca = new ArrayList<Jogo>();
        
        Catalogo catalogo = new Catalogo (jogos_catalogo);
        
        Biblioteca biblioteca = new Biblioteca(jogos_biblioteca);
        
        Jogo jogo1 = new Jogo ("Zelda", 2005, "rpg", 0,0,10,13.60);
        Jogo jogo2 = new Jogo ("Elden Ring", 2018, "rpg", 0,0,100,134.60);
        Jogo jogo3 = new Jogo ("MK1", 2024, "luta", 0,0,5,200.60);
        
        jogos_catalogo.add(jogo1);
        jogos_catalogo.add(jogo2);
        jogos_catalogo.add(jogo3);
        
        Usuario Pedro = new Usuario ("Pedro", biblioteca);
        
        catalogo.comprarJogo("Zelda");
        
        
        System.out.println(Pedro);
        
    
        
    }
}

public class Biblioteca {
    private ArrayList<Jogo> jogos;
    
    public Biblioteca() {
        this.jogos = new ArrayList<Jogo>();
    }
    
    public ArrayList<Jogo> getJogos() {
        return jogos;
    }
    
    public Biblioteca(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }   
    
    public Jogo escolherJogo(String nome, String categoria, int anoLancamento) {
        for (Jogo jogo : jogos) {
            if (jogo.getNome().equals(nome) && 
                jogo.getCategoria().equals(categoria) && 
                jogo.getAnoLancamento() == anoLancamento) {
                return jogo;
            }
        }
        return null;
    }
    public String toString() {
        return String.format("Jogos: %s", jogos);
    }
}

public class Usuario {
    private String nome;
    private Biblioteca biblioteca;
    
    public Usuario(String nome, Biblioteca biblioteca) {
        this.nome = nome;
        this.biblioteca = biblioteca;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void votar(Jogo jogo, boolean isPositivo) {
        jogo.votar(isPositivo);
    }
    
    public Jogo escolherJogo(String nome, String categoria, int anoLancamento) {
        
        for (Jogo jogo : biblioteca.getJogos()) {
            if (jogo.getNome().equals(nome) && 
                jogo.getCategoria().equals(categoria) && 
                jogo.getAnoLancamento() == anoLancamento) {
                return jogo;
            }
        }
        return null;
    }
    
    public String toString() {
        return String.format("nome: %s|Biblioteca: %s ", nome, biblioteca.getJogos());
    }
}

public class Jogo {
    private String nome;
    private int anoLancamento;
    private String categoria;
    private int votacoesPositivas;
    private int votacoesNegativas;
    private int quantidadeVendas;
    private double preco;
    
    public Jogo(String nome, int anoLancamento, String categoria, 
               int votacoesPositivas, int votacoesNegativas, 
               int quantidadeVendas, double preco) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.categoria = categoria;
        this.votacoesPositivas = votacoesPositivas;
        this.votacoesNegativas = votacoesNegativas;
        this.quantidadeVendas = quantidadeVendas;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getAnoLancamento() {
        return anoLancamento;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public int getVotacoesPositivas() {
        return votacoesPositivas;
    }
    
    public int getVotacoesNegativas() {
        return votacoesNegativas;
    }
    
    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void votar(boolean isPositivo) {
        if (isPositivo) {
            votacoesPositivas += 1;
        } else {
            votacoesNegativas += 1;
        }
    }
    
    public void incrementaVendas() {
        Scanner s = new Scanner(System.in);
        System.out.println("Cópias vendidas: ");
        quantidadeVendas += s.nextInt();
    }
    
    public String toString() {
        return String.format("nome: %s|Ano lançamento: $d|categoria: %s|Votações positivas: $d|Votações Negativas: %d| Quantidade vendas: %d| preço: %.3f", nome, anoLancamento, categoria, votacoesPositivas, votacoesNegativas, quantidadeVendas, preco);
    }
}