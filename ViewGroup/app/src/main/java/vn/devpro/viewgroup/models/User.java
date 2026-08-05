package vn.devpro.viewgroup.models;

public class User {

    private int avatar;
    String name;
    String email;

    boolean isSelected = false;

    public User(int avatar, String name, String email) {
        this.avatar = avatar;
        this.name = name;
        this.email = email;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
