package pl.edu.wszib.jwd.jwdcolors.Controller.dao;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.jwd.jwdcolors.Controller.model.SelectedColor;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //za kazdym razem jak wywolamy te testy to zostaną objęte transakcję i nie zostaną utrwalone w bazie danych
class SelectedColorDaoTest {
    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_RED = "red";
    public static final int TOTAL_COLORS = 3;


    @Autowired //wstrzykiwanie danych
    SelectedColorDao selectedColorDao;

    @BeforeEach
        // przed kazda metoda testowa to zostanie uruchomione
    void setUp() {

        //przed kazdym testowaniem tworzymy 3 modele
        SelectedColor selectedColor1 = new SelectedColor(COLOR_BLUE, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR_RED, new Date());
        SelectedColor selectedColor3 = new SelectedColor(COLOR_RED, new Date());

        //sprawdamy czy są już zapisane
        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());
        assertNull(selectedColor3.getId());


        //zapisujemy
        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);
        selectedColorDao.save(selectedColor3);

        //sprawdzamy czy sa zapisane
        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());
        assertNotNull(selectedColor3.getId());

    }

    //metoda testowa
    @Test
    void testDetchData() { //testujemy odczytywanie danych z bazy danych

        SelectedColor selectedColor = selectedColorDao.findFirstByColor(COLOR_RED);   //obiekt.metoda(dana)
        assertEquals(COLOR_RED, selectedColor.getColor(), "Znaleziono nieprawidłowy kolor");     //to co sie spodziewamy, to co dostalismy, komunikat jesli cos poszlo nie tak
    }


    //druga metoda testowa


    @Test
    void TestFetchAllData(){
        Collection selectedColors = (Collection) selectedColorDao.findAll();   // to w nawiasie to rzutowanie na typ Collection
        assertEquals(TOTAL_COLORS, selectedColors.size(), "Nieprawidłowa liczba kolorów");
    }
}