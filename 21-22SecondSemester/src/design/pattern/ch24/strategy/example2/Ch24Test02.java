package design.pattern.ch24.strategy.example2;

import design.pattern.ch24.strategy.example2.context.MovieTicket;
import design.pattern.ch24.strategy.example2.strategy.ChildrenDiscount;

public class Ch24Test02 {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket(30);
        movieTicket.setDiscount(new ChildrenDiscount());
        System.out.println(movieTicket.getPrice());
    }
}
