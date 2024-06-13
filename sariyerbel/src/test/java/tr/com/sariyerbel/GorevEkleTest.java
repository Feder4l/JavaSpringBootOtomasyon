package tr.com.sariyerbel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.com.sariyerbel.GorevEkle.Gorev;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GorevEkleTest {

    private GorevEkle gorevEkle;

    @BeforeEach
    void setUp() {
        gorevEkle = new GorevEkle();
        GorevEkle.GOREV_LISTESI.clear();
    }

    @Test
    public void testListele() {
        Gorev gorev1 = new Gorev("Gorev1", "1");
        Gorev gorev2 = new Gorev("Gorev2", "2");
        GorevEkle.GOREV_LISTESI.add(gorev1);
        GorevEkle.GOREV_LISTESI.add(gorev2);

        List<Gorev> gorevList = gorevEkle.listele();
        assertEquals(2, gorevList.size());
        assertEquals(gorev1, gorevList.get(0));
        assertEquals(gorev2, gorevList.get(1));
    }

    @Test
    public void testBul() {
        Gorev gorev1 = new Gorev("Gorev1", "1");
        GorevEkle.GOREV_LISTESI.add(gorev1);

        Gorev result = gorevEkle.bul("1");
        assertEquals(gorev1, result);

        Gorev resultNotFound = gorevEkle.bul("2");
        assertNull(resultNotFound);
    }

    @Test
    public void testEkle() {
        Gorev gorev = new Gorev("Gorev1", "1");
        gorevEkle.ekle(gorev);

        List<Gorev> gorevList = gorevEkle.listele();
        assertEquals(1, gorevList.size());
        assertEquals(gorev, gorevList.get(0));
    }
}
