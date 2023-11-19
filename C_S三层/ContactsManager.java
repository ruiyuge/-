package 体系结构.C_S三层;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    private List<String> contacts;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
    }

    public synchronized void addContact(String contact) {
        // 在这里处理添加联系人到通讯录的逻辑
        contacts.add(contact);
        // 这里可以将联系人信息写入文本文件或者其他数据存储方式
    }

    public synchronized String getAllContacts() {
        // 在这里处理获取所有联系人的逻辑
        return contacts.toString();
        // 可以从文本文件或者其他数据存储方式中读取联系人信息并返回
    }
}
