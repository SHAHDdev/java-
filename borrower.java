

import java.util.ArrayList;

public class borrower {
    private String name;
    private String studentId;
    private ArrayList<book> borrowedbooks;

    public borrower(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedbooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void borrowbook(book book) {
        borrowedbooks.add(book);
    }

    public void returnbook(book book) {
        borrowedbooks.remove(book);
    }

    public void displayInfo() {
        System.out.println("الاسم: " + name);
        System.out.println("الرقم الجامعي: " + studentId);
        System.out.println("الكتب المستعارة:");
        if (borrowedbooks.isEmpty()) {
            System.out.println("لا توجد كتب مستعارة.");
        } else {
            for (book book : borrowedbooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}
