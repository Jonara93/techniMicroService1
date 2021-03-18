package be.technifutur.mlivraison.utils;

public enum DeliverySupplier {
    DHL(150, 3), DPD(75, 5), BPOST(50, 7);

    int price;
    int nbOfDays;

    DeliverySupplier(int price, int nbOfDays) {
        this.price = price;
        this.nbOfDays = nbOfDays;
    }

    public int getPrice() {
        return price;
    }

    public int getNbOfDays() {
        return nbOfDays;
    }
}
