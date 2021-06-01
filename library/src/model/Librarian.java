package model;

import java.util.Objects;

public class Librarian {
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(Username, librarian.Username) &&
                Objects.equals(Password, librarian.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Username, Password);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
