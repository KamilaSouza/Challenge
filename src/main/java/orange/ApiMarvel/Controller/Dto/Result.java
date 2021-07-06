package orange.ApiMarvel.Controller.Dto;

import java.util.List;

public class Result {

    private Integer id;
    private String title;
    private Creators creators;
    private String isbn;
    private List<Price> prices;
    private String description;


    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public String getDescription() {
        return description;
    }

    public Creators getCreators() {
        return creators;
    }

    public Integer getId() {
        return id;
    }
}

