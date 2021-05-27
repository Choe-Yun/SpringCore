package springproject.springcore.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import springproject.springcore.Member.Grade;
import springproject.springcore.Member.Member;
import springproject.springcore.Member.MemberService;
import springproject.springcore.Member.MemberServiceImpl;
import springproject.springcore.Order.Order;
import springproject.springcore.Order.OrderService;
import springproject.springcore.Order.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
