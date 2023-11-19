// ContactService.java (联系人的业务逻辑处理)
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    // 省略构造函数和其他方法

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}