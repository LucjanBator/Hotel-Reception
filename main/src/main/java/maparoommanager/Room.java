package maparoommanager;
/**
 * Klasa reprezentująca pojedynczy pokój w systemie zarządzania hotelem.
 */
public class Room {
    private final int number;
    private final String description;
    private final double price;
    private String guestName;
    /**
     * Konstruktor klasy Room.
     *
     * @param number      Numer pokoju.
     * @param description Opis pokoju.
     * @param price       Cena pokoju.
     */
    public Room(int number, String description, double price) {
        this.number = number;
        this.description = description;
        this.price = price;
    }
    /**
     * Pobiera numer pokoju.
     *
     * @return Numer pokoju.
     */
    public int getNumber() {
        return number;
    }
    /**
     * Pobiera opis pokoju.
     *
     * @return Opis pokoju.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Pobiera cenę pokoju.
     *
     * @return Cena pokoju.
     */
    public double getPrice() {
        return price;
    }
    /**
     * Pobiera nazwę gościa aktualnie zamieszkującego pokój.
     *
     * @return Nazwa gościa lub null, jeśli pokój jest wolny.
     */
    public String getGuestName() {
        return guestName;
    }
    /**
     * Przeprowadza proces zameldowania gościa do pokoju.
     *
     * @param guestName Nazwa gościa do zameldowania.
     */
    public void checkIn(String guestName) {
        this.guestName = guestName;
    }
    /**
     * Przeprowadza proces wymeldowania gościa z pokoju.
     */
    public void checkOut() {
        this.guestName = null;
    }
}
