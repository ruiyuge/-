// ContactController.java (处理HTTP请求)
@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    // 省略构造函数

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping("/add")
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }
}