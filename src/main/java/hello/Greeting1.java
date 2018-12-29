package hello;

public class Greeting1 {

    private final long id;
    private final String content;

    public Greeting1(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
