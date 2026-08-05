package vn.devpro.pinterest_demo.models;

public class Image_Info {
    private int image;
    private int avatar;
    private String name;

    private boolean isFavorite;
    private boolean isSaved;

    public Image_Info(int image, int avatar, String name, boolean isFavorite, boolean isSaved) {
        this.image = image;
        this.avatar = avatar;
        this.name = name;
        this.isFavorite = isFavorite;
        this.isSaved = isSaved;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
