import java.util.List;

class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }
}

class Order {
    List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
