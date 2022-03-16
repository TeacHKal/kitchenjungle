package com.teachkal.user;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @SequenceGenerator(name = "app_user_id_sequence", sequenceName = "app_user_id_sequence")
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_id_sequence")
    private Long id;
    @Column(unique = true)
    private String name;
    private Float protein;
    private Float fat;
    private Float carb;

}
