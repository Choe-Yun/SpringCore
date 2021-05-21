package springproject.springcore.Order;

import springproject.springcore.Discount.DiscountPolicy;
import springproject.springcore.Discount.FixDiscountPolicy;
import springproject.springcore.Member.Member;
import springproject.springcore.Member.MemberRepository;
import springproject.springcore.Member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override // 주문 정보가 들어오면 맴버아이디를 먼저 조회후 할인 정책을 넘겨줌
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
