package get;

public class ModelOfInstance {
    private String userName;
    private String password;
    private String url;

    public ModelOfInstance(String userName, String password,String url) {
        this.userName = userName;
        this.password = password;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
