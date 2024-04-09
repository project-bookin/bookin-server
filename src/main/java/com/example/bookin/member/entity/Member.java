package com.example.bookin.member.entity;

import com.example.bookin.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "member_name")
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type")
    private MemberType memberType;
    @Builder
    public Member(String email, String password, String memberName,MemberType memberType) {
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.memberName = memberName;
    }
}
