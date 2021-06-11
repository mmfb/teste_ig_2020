package pt.iade.eval.models;

public class Equipamento {
    private String nome;
    private double valor;
    public Equipamento(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return nome+":"+valor;
    }
    
}
