import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColorTest {

    private Color color;
    private Color hexColor;

    @BeforeEach
    public void setUp() {
        color = new Color(100,20,30);
        hexColor = new Color("#32A852");
    }

    @Test
    public void testInvalidMaxColorRed() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(256, 50, 200);
        });
    }

    @Test
    public void testInvalidMaxColorGreen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 256, 200);
        });
    }

    @Test
    public void testInvalidMaxColorBlue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 50, 256);
        });
    }

    @Test
    public void testInvalidMinColorRed() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(-1, 50, 200);
        });
    }

    @Test
    public void testInvalidMinColorGreen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, -1, 200);
        });
    }

    @Test
    public void testInvalidMinColorBlue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color(100, 50, -1);
        });
    }

    @Test
    public void testConstructorWithValidValues() {
        assertEquals(100, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals(30, color.getBlue());
        assertEquals("#64141E", color.getHexValue());
    }

    @Test
    public void testHexConstructorWithValidHex() {
        assertEquals("#32A852", hexColor.getHexValue());
        assertEquals(50, hexColor.getRed());
        assertEquals(168, hexColor.getGreen());
        assertEquals(82, hexColor.getBlue());
    }

    @Test
    public void testHexConstructorWithInvalidHex() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Color("32A852");
        });
    }

    @Test
    public void testHexConstructorWithNullHex() {
        assertThrows(NullPointerException.class, () -> {
            new Color(null);
        });
    }

    @Test
    public void testGetRed() {
        assertEquals(100, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals(30, color.getBlue());
        assertEquals("#64141E", color.getHexValue());
    }

    @Test
    public void testGetGreen() {
        assertEquals(20, color.getGreen());
        assertEquals(100, color.getRed());
        assertEquals(30, color.getBlue());
        assertEquals("#64141E", color.getHexValue());
    }

    @Test
    public void testGetBlue() {
        assertEquals(30, color.getBlue());
        assertEquals(100, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals("#64141E", color.getHexValue());
    }

    @Test
    public void testGetHexValue() {
        assertEquals("#64141E", color.getHexValue());
        assertEquals(100, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals(30, color.getBlue());
    }

    @Test
    public void testSetValidRed() {
        color.setRed(140);
        assertEquals(140, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals(30, color.getBlue());
        assertEquals("#8C141E", color.getHexValue());
    }

    @Test
    public void testSetInvalidRed() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setRed(256);
        });
    }

    @Test
    public void testSetValidGreen() {
        color.setGreen(45);
        assertEquals(100, color.getRed());
        assertEquals(45, color.getGreen());
        assertEquals(30, color.getBlue());
        assertEquals("#642D1E", color.getHexValue());
    }

    @Test
    public void testSetInvalidGreen() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setGreen(256);
        });
    }

    @Test
    public void testSetValidBlue() {
        color.setBlue(70);
        assertEquals(100, color.getRed());
        assertEquals(20, color.getGreen());
        assertEquals(70, color.getBlue());
        assertEquals("#641446", color.getHexValue());
    }

    @Test
    public void testSetInvalidBlue() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setBlue(256);
        });
    }

    @Test
    public void testSetValidHexValue() {
        color.setHexValue("#64123E");
        assertEquals("#64123E", color.getHexValue());
        assertEquals(100, color.getRed());
        assertEquals(18, color.getGreen());
        assertEquals(62, color.getBlue());
    }

    @Test
    public void testSetInvalidHexValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            color.setHexValue("64123E");
        });
    }

    @Test
    public void testSetNullHexValue() {
        assertThrows(NullPointerException.class, () -> {
            color.setHexValue(null);
        });
    }

    @Test
    public void testToString() {
        assertEquals("[value=#64141E, r=100, g=20, b=30]", color.toString());
    }

}