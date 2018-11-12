package sample;

import javafx.collections.ObservableList;

import java.util.Random;

public class Deck {

    public ObservableList cards = javafx.collections.FXCollections.observableArrayList();

    public ObservableList getCards() {
        return cards;
    }

    public static void main(String[] args) {
    }

    //
    public Deck() {
        for (Card.Value value : Card.Value.values()) {
            for (Card.Face face : Card.Face.values()) {
                cards.add(new Card(value, face));
            }
        }
    }



    /*
    - turns ist im Button in der Main = 12
    - Random neues Index für die Karte -> neuer Index liegt in der Länge der Liste, tauscht
      anschließend es die zwei zufälligen Karten miteinander.
    */
    public void shuffle(int turns) {
        Random random = new Random();
        for (int i = 0; i < turns; i++) {
            int index1 = random.nextInt(cards.size());
            int index2 = random.nextInt(cards.size());
            swap(index1, index2);
        }
    }

    private void swap(int index1, int index2) {
        Card card1 = (Card) cards.get(index1);
        Card card2 = (Card) cards.get(index2);
        cards.set(index2, card1);
        cards.set(index1, card2);
    }



    public void quicksort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            quicksort(low, pivot-1);
            quicksort(pivot+1, high);
        }

    }

    public int partition(int low, int high) {
        Card pivot = (Card) cards.get(high);
        int i;
        i = low;
        int j;
        for (j = low; j < high; j++ ) {
            Card card1 = (Card) cards.get(j);
            if (pivot.compareTo(card1) == 1) {
                swap(i, j);
                i += 1;
            }
        } swap(i, high);


        return i;
    }
}

// Low: array[0]
// High: array.size(-1)

