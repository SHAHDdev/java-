
import  java.time.LocalDate;

public class borrowingProcess {
    private book book;
    private borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public borrowingProcess(book book, borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    public void returnbook() {
        this.returnDate = LocalDate.now();
        book.setAvailable(true);
        borrower.returnbook(book);
    }

    public void displayInfo() {
        System.out.println("الكتاب: " + book.getTitle());
        System.out.println("المستعير: " + borrower.getName());
        System.out.println("تاريخ الإعارة: " + borrowDate);
        if (returnDate != null) {
            System.out.println("تاريخ الاسترجاع: " + returnDate);
        } else {
            System.out.println("الكتاب لم يُسترجع بعد.");
        }
    }
    
    
        
    
        public borrower getborrower() {
            return borrower;
        }
    
        
    }
    

