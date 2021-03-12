package main;

import static org.junit.jupiter.api.Assertions.*;

class IDLListTest {

    @org.junit.jupiter.api.Test
    void add() {
        // Testing method add(int index, E elem) int
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 4);
        myIntList.add(2, 3);

        int[] resultsInt = {1,2,3,4};
        for (int i=0; i<myIntList.size(); i++) {
            assertEquals(myIntList.get(i), resultsInt[i]);
        }

        // Testing method add(int index, E elem) String
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        String[] resultsStr = {"cat", "bat", "hat", "mat"};
        for (int i=0; i<myStrList.size(); i++) {
            assertEquals(myStrList.get(i), resultsStr[i]);
        }

        myStrList.add("first");

        // testing return
        assertTrue(myStrList.add(3, "extra"));

        // Testing method add(E elem)
        assertEquals(myStrList.get(0), "first");

    }

    @org.junit.jupiter.api.Test
    void append() {
        // Testing method add(int index, E elem) int
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 4);
        myIntList.add(2, 3);
        myIntList.append(5);


        assertEquals(myIntList.get(myIntList.size()-1), 5);
    }

    @org.junit.jupiter.api.Test
    void get() {
        // test getting valid values
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 4);
        myIntList.add(2, 3);

        int[] resultsInt = {1,2,3,4};
        for (int i=0; i<myIntList.size(); i++) {
            assertEquals(myIntList.get(i), resultsInt[i]);
        }

        // test with invalid indices
        assertThrows(IndexOutOfBoundsException.class, () -> myIntList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> myIntList.get(-1));
    }

    @org.junit.jupiter.api.Test
    void getHead() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.getHead(), "cat");

        // for empty list
        IDLList<String> myStrList2 = new IDLList<String>();
        assertThrows(NullPointerException.class, () -> myStrList2.getHead());
    }

    @org.junit.jupiter.api.Test
    void getLast() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.getLast(), "mat");

        // for empty list
        IDLList<String> myStrList2 = new IDLList<String>();
        assertThrows(NullPointerException.class, () -> myStrList2.getLast());
    }

    @org.junit.jupiter.api.Test
    void size() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.size(), 4);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.remove();

        String[] results = {"bat", "hat", "mat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty string
        IDLList<Integer> myIntList = new IDLList<Integer>();
        assertThrows(IllegalStateException.class, () -> myIntList.remove());

    }

    @org.junit.jupiter.api.Test
    void removeLast() {

        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.removeLast();

        String[] results = {"cat", "bat", "hat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty string
        IDLList<Integer> myIntList = new IDLList<Integer>();
        assertThrows(IllegalStateException.class, () -> myIntList.removeLast());
    }

    @org.junit.jupiter.api.Test
    void removeAt() {

        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.removeAt(1);

        String[] results = {"cat", "hat", "mat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty list
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(10);
        assertThrows(IllegalStateException.class, () -> myIntList.removeAt(10));

    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        // remove first occurrence of element
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 2);
        myIntList.add(2, 3);

        // remove entry and check return
        assertTrue(myIntList.remove(2));
        assertFalse(myIntList.remove(-1));

        int[] results = {1,3,2};
        for (int i=0; i<3; i++) {
            assertEquals(myIntList.get(i), results[i]);
        }
    }
}