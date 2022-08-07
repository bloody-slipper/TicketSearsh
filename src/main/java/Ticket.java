public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int time;

    public Ticket(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;

    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.getPrice();
    }

}




