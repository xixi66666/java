package model;

import java.util.Objects;

public class Reader {
    private String readerId;
    private String readerName;
    private String type;
    private String sex;
    private String password;

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(readerId, reader.readerId) &&
                Objects.equals(readerName, reader.readerName) &&
                Objects.equals(type, reader.type) &&
                Objects.equals(sex, reader.sex) &&
                Objects.equals(password, reader.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, readerName, type, sex, password);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId='" + readerId + '\'' +
                ", readerName='" + readerName + '\'' +
                ", type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
