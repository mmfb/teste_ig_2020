package pt.iade.eval.models;

public interface Custeavel {
    String getDescricao();
    double getCusto();
    double getReceita();
    default double getLucro() {
        return getReceita() - getCusto();
    }
}
