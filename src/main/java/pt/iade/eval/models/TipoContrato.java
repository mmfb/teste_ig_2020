package pt.iade.eval.models;

public enum TipoContrato {
    RECIBOVERDE (false,false),
    COMERCIAL (false,true),
    PRODUCAO (true,false),
    ADMINISTRADOR (true,true);
    final private boolean seguroSaude;
    final private boolean bonus;
    private TipoContrato(boolean seguroSaude, boolean bonus) {
        this.seguroSaude = seguroSaude;
        this.bonus = bonus;
    }
    public boolean isSeguroSaude() {
        return seguroSaude;
    }
    public boolean isBonus() {
        return bonus;
    }
}
