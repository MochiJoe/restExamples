package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // This is what I decided to do on my own random generated
    //Stuff in a restful service.
    private static final String[] intro = {"Oooooop, " +
            "here she come... %s!",
            "Ugh, why she gotta be here... %s!",
            "She has a lot of clout, here comes... %s!"};
    //This need to be inside the method where it was being
    //... so that it could be random at each refresh.

    //int rand = (int) (Math.random() * (intro.length));

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",
            defaultValue = "world") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }

    @RequestMapping("/Spell")
    public Greeting greeting2(@RequestParam(value = "name",
            defaultValue = "MISU BANGIE") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format("Here she come, that Bitch... %s", name));
    }

    @RequestMapping("/intro")
    public Greeting greeting3(@RequestParam(value = "name",
            defaultValue = "Cunttessa") String name) {

        int rand = (int) (Math.random() * (intro.length));
        return new Greeting(counter.incrementAndGet(),
                String.format(intro[rand], name));
    }

}
