package com.springboot.rals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "[user]", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    // duy tri lien ket giua 2 ENTITY user va role
    //"fetch = FetchType.EAGER", nghĩa là JPA sẽ cố gắng truy xuất dữ liệu của mối quan hệ nhiều-nhiều ngay lập tức khi bạn truy xuất đối tượng gốc mà có chứa mối quan hệ này.
    //Điều này đồng nghĩa rằng dữ liệu của các đối tượng liên quan sẽ được nạp vào bộ nhớ và sẵn sàng cho việc sử dụng ngay cả trước khi bạn thực sự truy cập chúng.

    //"cascade" là một thuộc tính được sử dụng để xác định các thao tác mà bạn muốn "kế thừa" từ thực thể cha sang thực thể con.
    // Ví dụ, khi bạn thực hiện một thao tác trên thực thể cha (ví dụ: lưu hoặc xóa), bạn có thể muốn các thực thể con cũng thực hiện các thao tác tương tự.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    //tao 1 bang thu trung gian de duy tri moi quan he giua user va role bang cach join 2 bang user va role
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn (name = "user_id" , referencedColumnName = "id"), // bang user co PK la userid va no tro thanh FK torng babg users_roles
            inverseJoinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }
}
