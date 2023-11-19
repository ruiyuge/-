package 体系结构.B_S;

// Contact.java (实体类，表示联系人)
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    // 省略getter和setter
}
