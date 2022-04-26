package pojo;

public class BorrowCard {
    User user;
    long code;
    
    public BorrowCard() {
    }
    
    public BorrowCard(User user, long code) {
        this.user = user;
        this.code = code;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "BorrowCard{" +
                "user=" + user +
                ", code=" + code +
                '}';
    }
}
