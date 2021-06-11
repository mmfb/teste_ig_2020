package pt.iade.eval.models;

public class Empregado implements Custeavel{
    private static final double MIN_BONUS=20000;
    private static final double PERC_BONUS= 0.05;
    private static final double VALOR_SEGURO = 1000;
    protected double salario;
    protected String nome;
    protected double receita;
    protected TipoContrato contrato;
    public Empregado(double salario, String nome, TipoContrato contrato) {
        this.salario = salario;
        this.nome = nome;
        this.contrato = contrato;
        this.receita = 0;
    }
    public void setReceita(double receita) {
        this.receita = receita;
    }
    public void setContrato(TipoContrato contrato) {
        this.contrato = contrato;
    }
    @Override
    public double getCusto() {
        double custo = 0;
        if (contrato == TipoContrato.RECIBOVERDE)
            custo = 12*salario;
        else custo = 14*salario;
        if (contrato.isSeguroSaude()) 
            custo += VALOR_SEGURO;
        if (contrato.isBonus() && receita > MIN_BONUS)
            custo += receita*PERC_BONUS;
        return custo;
    }
    @Override
    public String getDescricao() {
        return nome;
    }
    @Override
    public double getReceita() {
        return receita;
    }    
}
