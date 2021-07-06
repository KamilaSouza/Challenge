package orange.ApiMarvel.Model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Comics {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int comicId;

    private String title;

    private float price;

    private String author;

    private String isbn; // International Standard Book Number

    private String description;

    private float priceWithDiscount;

    public Comics() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comics comics = (Comics) o;
        return Objects.equals(id, comics.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }


    public float getPriceWithDiscount() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        char lastChar = isbn.charAt(isbn.length() - 1);
        return priceWithDiscount = discountCalculated(dayOfWeek, lastChar, isbn, price);
    }

    public void setPriceWithDiscount(float priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public float discountCalculated(DayOfWeek dayOfWeek, char lastChar, String isbn, float price) {
        float newPrice = price;
        float discount = (float) 0.9;
        switch (dayOfWeek) {
            case MONDAY:
                if (lastChar == '0' || lastChar == '1') {
                    newPrice = (price * discount);
                }
                break;
            case TUESDAY:
                if (lastChar == '2' || lastChar == '3') {
                    newPrice = (price * discount);
                }
                break;
            case WEDNESDAY:
                if (lastChar == '4' || lastChar == '5') {
                    newPrice = (price * discount);
                }
                break;
            case THURSDAY:
                if (lastChar == '6' || lastChar == '7') {
                    newPrice = (price * discount);
                }
                break;
            case FRIDAY:
                if (lastChar == '8' || lastChar == '9') {
                    newPrice = (price * discount);
                }
                break;
            case SATURDAY:
                newPrice = newPrice;
                break;
            case SUNDAY:
                newPrice = newPrice;
                break;
        }
        return newPrice;
    }

}

