package com.example.bookin.businessowner.entity;

import com.example.bookin.base.BaseTimeEntity;
import com.example.bookin.member.entity.Member;
import com.example.bookin.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "business_owner")
public class BusinessOwner extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_owner_id")
    private Long businessOwnerId;

    @Column(name = "nick_name")
    private String nickname;

    @OneToMany(mappedBy = "business_owner",cascade = CascadeType.ALL)
    private List<Store> stores = new ArrayList<>();

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "business_owner", cascade = CascadeType.ALL)
    private BusinessOwnerNumber businessOwnerNumber;
    @Builder
    public BusinessOwner(String nickname, List<Store> stores, Member member) {
        this.nickname = nickname;
        this.stores = stores;
        this.member = member;
    }
}
