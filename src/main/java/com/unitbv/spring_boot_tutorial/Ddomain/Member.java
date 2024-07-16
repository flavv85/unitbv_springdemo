package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "MEMBER")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id", nullable = false)
    String id;

    @Column(name = "member_name", nullable = false)
    String name;

    @Column(name = "member_nickname", nullable = false)
    String nickname;
}
