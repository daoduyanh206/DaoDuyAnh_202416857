public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED)
        {
            System.out.println("The cart is already full");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
        if(qtyOrdered == MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i = 0; i < qtyOrdered; i++)
        {
            if(itemsOrdered[i] == disc)
            {
                for(int j = i + 1; j < qtyOrdered; j++)
                    itemsOrdered[j-1] = itemsOrdered[j];
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost()
    {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++)
        {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}
