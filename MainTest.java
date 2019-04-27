import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        try {
            new FileNotFoundException();
            fail("Exception not thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Operation Not Supported", e.getMessage());
        }

    }

    @Test
    public void getWords() {
        String thing = "casa";
        String word = "house";

        assertNotSame(thing, word);
}}