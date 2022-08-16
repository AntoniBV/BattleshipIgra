public enum ShipType {
    NOSAC(1),
    KRSTARICA(2),
    BORBENIBROD(2),
    RAZARAC(3),
    PODMORNICA(4);

    public final Integer label;

    ShipType(Integer label) {
        this.label = label;
    }
}

