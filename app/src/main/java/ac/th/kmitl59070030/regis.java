package ac.th.kmitl59070030;

import android.content.ContentValues;

public class regis {
    private String user_id;
    private  String name;
    private String age;
    private String password;

    public void setCv(String user_id,String name,String age,String password) {
        this.user_id=user_id;
        this.name=name;
        this.age=age;
        this.password=password;
    }

    public ContentValues getCv() {
        return cv;
    }

    ContentValues cv = new ContentValues();

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
