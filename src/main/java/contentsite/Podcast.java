package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Podcast implements Content{
    //mindig meghallgatható,
    // nem prémium

    private String title;
    private List<String> speakers = new ArrayList<>();

    private List<User> clickingUsers = new ArrayList<>();

    public Podcast(String title, List<String> speakers) {
        this.title = title;
        this.speakers = speakers;
    }

    public List<String> getSpeakers() {
        return speakers;
    }

    public List<User> getClickingUsers() {
        return clickingUsers;
    }

    @Override
    public boolean isPremiumContent() {
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(clickingUsers);
    }

    @Override
    public void click(User user) {
        clickingUsers.add(user);

    }


}
