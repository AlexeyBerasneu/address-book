# Contact Book 📒

A simple **console application** for managing a list of contacts.  
This project demonstrates practical usage of Java **Collections Framework** (`List`, `Set`, `Map`),  
proper overriding of `equals()` and `hashCode()`, and working with **iterators**.

---

## 🚀 Features

- Add new contacts  
- Delete existing contacts  
- View all contacts in order of addition  
- Search contacts by **name** or **phone number**  
- Group contacts by categories (e.g., *Work, Family, Friends*)  
- Guarantee **uniqueness of contacts** (using `equals()` & `hashCode()`)  

---

## 📂 Data Model

**Contact class fields:**
- `String name` – first and last name  
- `String phone` – phone number  
- `String email` – email address  
- `String group` – category (*Work, Family, Friends, etc.*)  

**Key points:**
- Override `equals()` and `hashCode()` to ensure uniqueness (e.g., based on `name` + `phone`)  
- Override `toString()` for convenient console output  

---

## 🛠️ Collections Used

- **List** (`ArrayList`) – maintains insertion order for displaying contacts  
- **Set** (`HashSet`) – ensures uniqueness (no duplicates)  
- **Map** (`HashMap`) – groups contacts by category (key = group, value = list of contacts)  

---

## 📋 Operations

1. **Add a contact**  
   - Input: name, phone, email, group  
   - Check for duplicates (via `Set`)  
   - Add to `List`, `Set`, and `Map`  

2. **Delete a contact**  
   - Remove by name (or other unique key)  
   - Must be removed from all collections  

3. **View all contacts**  
   - Display in order of insertion using an **iterator**  

4. **Search contact**  
   - By name or phone number  

5. **View contacts by group**  
   - Input: group name  
   - Display all contacts from `Map` for that group  

---

## 🖥️ Console Menu

```
1 - Add contact
2 - Delete contact
3 - View all contacts
4 - Search contact
5 - View contacts by group
0 - Exit
```

---

## ⚠️ Error Handling

- If a duplicate contact is added → notify user: *"This contact already exists!"*  
- If trying to delete a non-existing contact → notify user  

---

## ✅ Example Run

```
Choose action:
1 - Add contact
2 - Delete contact
3 - View all contacts
4 - Search contact by name
5 - View contacts by group
0 - Exit
> 1
Enter name: Ivan Ivanov
Enter phone: 123456
Enter email: ivan@example.com
Enter group: Work
Contact added.

> 5
Enter group name: Work
Contacts in group "Work":
Ivan Ivanov | 123456 | ivan@example.com

> 1
Enter name: Ivan Ivanov
Enter phone: 123456
Enter email: ivan2@example.com
Enter group: Work
This contact already exists!
```

---

## 🎯 Learning Outcomes

By completing this project, you will:  
- Apply `List`, `Set`, and `Map` in one application  
- Understand importance of correct `equals()` and `hashCode()` implementation  
- Practice using **iterators** for traversing collections  
- Build a complete **Contact Book**, extendable with features like file storage or advanced search  

---

## 📌 Future Improvements

- Save contacts to file (persistence)  
- Support JSON/CSV import & export  
- Add advanced search (by multiple fields)  
- User-friendly GUI version  
