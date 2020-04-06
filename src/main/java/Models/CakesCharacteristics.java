package Models;

public class CakesCharacteristics {
    private int cakeId;
    private int characteristicId;

    public CakesCharacteristics(Cakes cakeId, Characteristics characteristicId) {
        this.cakeId = cakeId.getId();
        this.characteristicId = characteristicId.getId();
    }

    public int getCakeId() {
        return cakeId;
    }

    public int getCharacteristicId() {
        return characteristicId;
    }
}
