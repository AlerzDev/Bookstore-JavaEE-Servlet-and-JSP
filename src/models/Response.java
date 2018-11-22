package models;

public class Response {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
