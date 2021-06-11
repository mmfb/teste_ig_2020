package pt.iade.eval.models;

public class Servico implements Custeavel {
    protected String descricao;
    protected double valor;
    protected double roi;
    public Servico(String descricao, double valor, double roi) {
        this.descricao = descricao;
        this.valor = valor;
        this.roi = roi;
    }
    @Override
    public double getCusto() {
        return valor;
    }
    @Override
    public String getDescricao() {
        return descricao;
    }
    @Override
    public double getReceita() {
        double custo =getCusto(); 
        return roi*custo+custo;
        // return (1+roi)*getCusto();
    }
    
    
}
