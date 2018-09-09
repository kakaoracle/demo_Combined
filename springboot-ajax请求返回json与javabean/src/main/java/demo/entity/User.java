package demo.entity;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id; // 主键ID

    private String name; // 姓名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
