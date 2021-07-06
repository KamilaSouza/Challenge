package orange.ApiMarvel.Controller.Dto;

public class ComicsBaseDto {

    private Integer code;
    private String status;
    private String copyright;
    private Data data;
    private String etag;

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public Data getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }
}
