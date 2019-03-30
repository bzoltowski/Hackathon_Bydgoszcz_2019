package testing;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private Integer id;
    private String title;

    @SerializedName("body")
    private String text;

    public Post(int userId, int id, String title, String text) {

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }




}
