package pl.edu.wszib.jwd.jwdcolors.Controller.dao;


//dao = data access object

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.jwdcolors.Controller.model.SelectedColor;


//Integer moze byc za mały dla ogromnych serwisów. Dla laboratorium id moze byc Integerem
@Repository
public interface SelectedColorDao extends CrudRepository<SelectedColor, Integer > {

    SelectedColor findFirstByColor(String color); // na podstawie nazwy sam zaproponuje impolementacje, dlatego nazwa jest bardzo wazna
    //z jpa to juz tyle. Reszta zrobi sie sama
    //mozemy testowac tylko DAO -> trzeba napisac testy integracyjne ( jednostkowe - małych czesci); integracyjne - wiekszych czesci aplikacji
//ctrl shif T --> nowy test
}
