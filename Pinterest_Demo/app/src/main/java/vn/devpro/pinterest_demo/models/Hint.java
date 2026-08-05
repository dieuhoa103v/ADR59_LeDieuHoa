package vn.devpro.pinterest_demo.models;

public class Hint {
    private String hint;
    private boolean isSelected;

    public Hint(String hint, boolean isSelected) {
        this.hint = hint;
        this.isSelected = isSelected;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
