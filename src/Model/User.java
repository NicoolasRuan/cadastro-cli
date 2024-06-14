package Model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private Integer age;
    private Double height;

    @Override
    public String toString() {
        return "name: "+name  + "\n" + "email: "+email + "\n" + "age: "+age + "\n" + "height: "+height;
    }

    public User(String name, String email, String age, String height) {
        this.name = name;
        this.email = email;
        this.age = Integer.valueOf(age);
        this.height = Double.valueOf(height);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
