package 体系结构.B_S;

// ContactRepository.java (联系人的数据库操作)
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // 可以自定义一些查询方法，比如按姓名查找联系人等
}
