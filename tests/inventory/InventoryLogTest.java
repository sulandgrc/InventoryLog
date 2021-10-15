package inventory;

import inventory.InventoryLog;
import static org.junit.Assert.*;
import org.junit.Test;

public class InventoryLogTest {

    @Test
    public void testAdd() {

        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('b');
        assertEquals("[azaab]", log.toString());

    }

    @Test
    public void testSetOver(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.set('a',4);
        assertEquals("[azaaa]", log.toString());
    }

    @Test
    public void testSetUnder(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        log.set('a',2);
        assertEquals(2, log.get('a'));
    }

    @Test
    public void testSetZero(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        log.set('a',0);
        assertEquals(0, log.get('a'));
        assertEquals(1, log.get('z'));
    }
    @Test
    public void testSetUnder2(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('a');
        log.add('a');
        log.add('a');
        log.add('a');
        log.add('a');
        log.set('a',1);
        assertEquals(1, log.get('a'));
    }
    @Test
    public void testSetEqual(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        log.set('a',4);
        assertEquals(4, log.get('a'));
    }

    @Test
    public void testContains(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        assertTrue(log.contains('a'));
        assertTrue(log.contains('z'));
        assertFalse(log.contains('b'));
    }

    @Test
    public void testIsEmpty(){
        InventoryLog log = new InventoryLog();
        assertTrue(log.isEmpty());
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        assertFalse(log.isEmpty());
    }

    @Test
    public void testGet(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        assertEquals(4, log.get('a'));
        assertEquals(1, log.get('z'));
    }

    @Test
    public void testGetZero(){
        InventoryLog log = new InventoryLog();
        assertEquals(0, log.get('a'));
        assertEquals(0, log.get('z'));
    }

    @Test
    public void testSize(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('a');
        assertEquals(5, log.size());

    }

    @Test
    public void testSubtract(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('a');
        log.add('b');
        log.subtract('a');
        assertEquals("[zb]", log.toString());
    }
    @Test
    public void testToString(){
        InventoryLog log = new InventoryLog();
        log.add('a');
        log.add('z');
        log.add('a');
        log.add('A');
        log.add('B');
        log.add('?');
        assertEquals("[azaab]", log.toString());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSetCount(){
        InventoryLog inv = new InventoryLog();
        inv.set('a', -1);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSetCharacter(){
        InventoryLog inv = new InventoryLog();
        inv.set('?', 9);

    }
}