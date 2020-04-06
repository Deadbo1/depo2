package Models;

public class CakesDecorations {
    private int cakeId;
    private int decorationId;

    public CakesDecorations(Cakes cakeId, Decorations decorations) {
        this.cakeId = cakeId.getId();
        this.decorationId = decorations.getId();
    }

    public int getCakeId() {
        return cakeId;
    }

    public int getDecorationId() {
        return decorationId;
    }

    @Override
    public String toString() {
        return "Models.CakesDecorations{" +
                "cakeId=" + cakeId +
                ", decorationId=" + decorationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CakesDecorations)) return false;
        CakesDecorations that = (CakesDecorations) o;
        return getCakeId() == that.getCakeId() &&
                getDecorationId() == that.getDecorationId();
    }

}
