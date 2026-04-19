package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD " + dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                // Dịch chuyển các phần tử phía sau lên trước
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD " + dvd.getTitle() + " has been removed from the store.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD was not found in the store.");
        }
    }
    
    public void printStore() {
        System.out.println("**********STORE**********");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("*************************");
    }
}