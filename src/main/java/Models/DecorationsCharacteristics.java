package Models;

public class DecorationsCharacteristics {
    private int decorationId;
    private int decorationCharacteristicId;

    public DecorationsCharacteristics(Decorations cakeDecorationId, Characteristics cakeDecorationCharacteristicId) {
        this.decorationId = cakeDecorationId.getId();
        this.decorationCharacteristicId = cakeDecorationCharacteristicId.getId();
    }

    public int getDecorationId() {
        return decorationId;
    }

    public int getDecorationCharacteristicId() {
        return decorationCharacteristicId;
    }
}
