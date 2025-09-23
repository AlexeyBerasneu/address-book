package school.sorokin.javacore;

import java.util.Objects;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private Enum typeOfGroup;

    public Contact(String name, String phone, String email, Enum typeOfGroup) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.typeOfGroup = typeOfGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum getTypeOfGroup() {
        return typeOfGroup;
    }

    public void setTypeOfGroup(Enum typeOfGroup) {
        this.typeOfGroup = typeOfGroup;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ", typeOfGroup=" + typeOfGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
