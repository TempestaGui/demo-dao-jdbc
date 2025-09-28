package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    private String name;
    private Integer id;

    public Department(String name, Integer id){
        this.id = id;
        this.name = name;
    }

    public Department() {

    }

    public String getName(){
        return this.name;
    }
    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(Integer id){
        this.id= id;
    }
    @Override
    public String toString(){
        return "Department [name = "+this.name+", id = "+this.id+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
