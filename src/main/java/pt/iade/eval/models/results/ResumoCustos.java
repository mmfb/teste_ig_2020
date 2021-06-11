package pt.iade.eval.models.results;

public class ResumoCustos {
    private double custo;
    private double receita;
    private double lucro;
    public ResumoCustos(double custo, double receita, double lucro) {
        this.custo = custo;
        this.receita = receita;
        this.lucro = lucro;
    }
    public double getCusto() {
        return custo;
    }
    public double getReceita() {
        return receita;
    }
    public double getLucro() {
        return lucro;
    }
}
