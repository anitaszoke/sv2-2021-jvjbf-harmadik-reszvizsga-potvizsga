package contentsite;

import java.util.HashSet;
import java.util.Set;

public class ContentService {

    private Set<User> allUsers = new HashSet<>();
    private Set<Content> allContent = new HashSet<>();

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }

    public void registerUser(String name, String password) {
        if (userNameTake(name)) {
            throw new IllegalArgumentException("Username is already taken: " + name);
        }
        allUsers.add(new User(name, password));
    }

    public void addContent(Content content) {
        if (isContantTake(content)) {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        }
        allContent.add(content);

    }

    public void logIn(String username, String password) {
        User user = new User(username, password);

        if (!checkingName(username))
            throw new IllegalArgumentException("Username is wrong!");

        if (!checkingPassword(username, password)) {
            throw new IllegalArgumentException("Password is Invalid!");
        }
    }

    private boolean checkingPassword(String username, String password) {
        int passwordForCheck = (username + password).hashCode();
        for (User user : allUsers) {
            if (user.getUserName().equals(username)) {
                User thisUser = user;
                if (thisUser.getPassword() == passwordForCheck) {
                    thisUser.setLogIn(true);
                    return true;

                }
            }
        }
        return false;
    }

    private boolean checkingName(String username) {
        for (User user : allUsers) {
            if (user.getUserName().equals(username)) {
                user.setLogIn(true);
                return true;
            }
        }
        return false;
    }


    private boolean userNameTake(String name) {
        return allUsers.stream()
                .map(User::getUserName)
                .anyMatch(n -> n.equals(name));
    }

    private boolean isContantTake(Content content) {
        return allContent.stream()
                .anyMatch(c -> c.getTitle().equals(content.getTitle()));
    }


    public void clickOnContent(User user, Content content) {
        if (!user.isLogIn()) {
            throw new IllegalStateException("Log in to watch this content!");
        }
        if (content.isPremiumContent() && user.isPremiumMember()) {
            content.click(user);
        } else {
            throw new IllegalStateException("Upgrade for Premium to watch this content!");
        }
        if (!content.isPremiumContent()) {
            content.click(user);
        }


    }
}

