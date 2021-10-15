package inventory;

import java.util.ArrayList;
import java.util.Collections;

public class InventoryLog implements Inventory {

    private ArrayList<Character> log;

    public InventoryLog() {
        log = new ArrayList<>();
    }

    @Override
    public void add(char c) {
        if (Character.isLetter(c)) {
            log.add(Character.toLowerCase(c));
        }
    }

    @Override
    public void subtract(char c) {
        c = Character.toLowerCase(c);
        log.removeAll(Collections.singleton(c));
    }

    @Override
    public int get(char c) {
        if (Character.isLetter(c)) {
            return Collections.frequency(log, Character.toLowerCase(c));
        }
        return -1;
    }


    /**
     * updates the count of the character c in the inventory accordingly:
     * if desired count is 0, then all matching characters are removed from the inventory
     * if desired count < current number of characters, then current - desired characters are removed
     * if desired count > current number of characters, then desired - current characters are added
     * @param c character to update in inventory, throws IllegalArgumentException if
     * character is not a letter
     * @param count number to update count with, throws IllegalArgumentException if negative
     */
    @Override
    public void set(char c, int count) {
        if (!Character.isLetter(c)) {
            throw new IllegalArgumentException(c + " is a letter.");
        }
        if (count < 0) {
            throw new IllegalArgumentException(count + " cannot be negative.");
        }
        c = Character.toLowerCase(c);

        // changes = current count of characters in inventory - desired count
        int changes = get(c) - count;
        if (changes < 0) { // add some characters to achieve count
            for (int i = 1; i <= Math.abs(changes); i++) {
                add(c);
            }
        } else if (changes > 0) { // remove some characters to achieve count
            for (int i = 1; i <= changes; i++) {
                log.remove((Character) c);
            }
        } else if (count == 0) { // remove all characters
            subtract(c);
        }
    }

    @Override
    public boolean contains(char c) {
        return log.contains(Character.toLowerCase(c));
    }

    @Override
    public int size() {
        return log.size();
    }

    @Override
    public boolean isEmpty() {
        return log.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("[");

        for (Character c : log) {
            toReturn.append(c);
        }
        toReturn.append("]");
        return toReturn.toString();

    }

}
