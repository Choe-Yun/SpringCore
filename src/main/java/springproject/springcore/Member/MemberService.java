package springproject.springcore.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
