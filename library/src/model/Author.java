package model;
//

import java.util.Objects;

/**
 *
 * @author lygwangyp
 * @category “作者信息表”
 */


public class Author {
    //基本属性，name和id
    private String name;
    private String id;
    //基本属性的getter和setter方法
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    /*重写hashcode() equals()和toString()方法

     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                name.equals(author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString(){
        return "Author's name = " + name +" id = " + id;
    }

}
