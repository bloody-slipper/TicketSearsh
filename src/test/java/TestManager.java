import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestManager {
    RepositoryTickets repo = new RepositoryTickets();
    ManagerTickets manager = new ManagerTickets(repo);

    Ticket ticket1 = new Ticket(1, 5_600, "LED", "VKO", 95);
    Ticket ticket2 = new Ticket(22, 5_900, "LED", "VKO", 80);
    Ticket ticket3 = new Ticket(333, 5_300, "LED", "VKO", 90);
    Ticket ticket4 = new Ticket(4444, 35_000, "LED", "BEG", 170);
    Ticket ticket5 = new Ticket(55555, 28_900, "LED", "BEG", 840);
    Ticket ticket6 = new Ticket(6666, 22_500, "LED", "BEG", 540);
    Ticket ticket7 = new Ticket(777, 42_600, "LED", "FCO", 360);
    Ticket ticket8 = new Ticket(88, 62_550, "FCO", "LED", 420);
    Ticket ticket9 = new Ticket(9, 22_000, "FCO", "LED", 1260);
    Ticket ticket10 = new Ticket(10, 4_200, "VKO", "LED", 85);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

    }

    @Test
    public void shouldAddTicket() {

        manager.add(ticket10);

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.findAll("VKO", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFromTo() {

        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = manager.findAll("LED", "VKO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("FCO", "VKO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        manager.removeById(4444);

        Ticket[] expected = {ticket6, ticket5};
        Ticket[] actual = manager.findAll("LED", "BEG");

        assertArrayEquals(expected, actual);
    }

}
