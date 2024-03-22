package maparoommanager;

import java.util.ArrayList;
import java.util.List;
/**
 * Prosta implementacja mapy (słownika) oparta na liście.
 *
 * @param <K> Typ klucza.
 * @param <V> Typ wartości.
 */
public class MyMap<K, V> {
    private final List<MyEntry<K, V>> entries = new ArrayList<>();
    /**
     * Dodaje parę klucz-wartość do mapy.
     *
     * @param key   Klucz do dodania.
     * @param value Wartość do dodania.
     */
    public void put(K key, V value) {
        entries.add(new MyEntry<>(key, value));
    }
    /**
     * Pobiera wartość przypisaną do danego klucza.
     *
     * @param key Klucz, dla którego pobierana jest wartość.
     * @return Wartość przypisana do klucza lub null, jeśli klucz nie istnieje.
     */
    public V get(K key) {
        for (MyEntry<K, V> entry : entries) {
            if (entry.key().equals(key)) {
                return entry.value();
            }
        }
        return null;
    }
    /**
     * Zwraca listę wpisów w mapie.
     *
     * @return Lista wpisów (par klucz-wartość) w mapie.
     */
    public List<MyEntry<K, V>> entrySet() {
        return entries;
    }
    /**
     * Sprawdza, czy mapa zawiera podany klucz.
     *
     * @param key Klucz do sprawdzenia.
     * @return true, jeśli mapa zawiera klucz, w przeciwnym razie false.
     */
    public boolean containsKey(K key) {
        for (MyEntry<K, V> entry : entries) {
            if (entry.key().equals(key)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Prosta implementacja wpisu w mapie, przechowująca parę klucz-wartość.
     *
     * @param <K> Typ klucza.
     * @param <V> Typ wartości.
     */
    public record MyEntry<K, V>(K key, V value) {
    }
}
