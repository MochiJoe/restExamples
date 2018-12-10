//Creating this from scratch
// starting over completely

package hello;

public class Greeting {

    private long id;
    private String content;


    protected Greeting(long id, String content) {
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
