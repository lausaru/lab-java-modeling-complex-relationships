package AssociationOfNurses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;
    private Date renewal; // date on which the member's membership will be renewed

    public Member() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId && Objects.equals(name, member.name) && memberStatus == member.memberStatus && Objects.equals(renewal, member.renewal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, memberStatus, renewal);
    }
}
