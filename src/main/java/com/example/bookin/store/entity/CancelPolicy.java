package com.example.bookin.store.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CancelPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancel_policy_id")
    private Long cancelPolicyId;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_id")
    private Store store;

    // 취소 수수료
    @Column(name = "cancellation_fee")
    private BigDecimal cancellationFee;

    // 취소 마감 시간
    @Column(name = "cancellation_deadline")
    private LocalDateTime cancellationDeadline;

}
