package pl.edu.wszib.jwd.jwdcolors.Controller.model;


import jakarta.persistence.*;

import java.util.Date;


@Entity

@Table(name = "SelectedColors", schema = "jwdcolors") //schemat trzeba zrobic w management studio
//obiekt zawierający informacje o tym jakie informacje chcę utrwalić w bazie danych
public class SelectedColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String color;
    private Date ctime;  //creation time


    //2 konstruktory. Bezargumentowy jest potrzebny dla JPA; ten zwykły do testowania

    public SelectedColor() {
    }


    public SelectedColor( String color, Date ctime) {
        this.id = id;
        this.color = color;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
