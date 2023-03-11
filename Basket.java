package Raffle6;

public class Basket {
    public int weight;
    public boolean emptyBasket;

    public Basket(int weight) {
        this.weight = weight;
    }

    public boolean isEmpty() {
        emptyBasket = true;
        if (weight == 0) {
            System.out.println("В корзине больше нет игрушек");
            emptyBasket = false;
        }
        return emptyBasket;
    }

    @Override
    public String toString() {
        return "Basket[" + weight + "]";
    }
}
