package com.madhan.schooldatabase.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CouseMaterial {
    @Id
    @SequenceGenerator(name = "courseMaterial_sequence",sequenceName = "courseMaterial_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseMaterial_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY
    )
    @JoinColumn(name = "courseid",
    referencedColumnName = "courseId")

    private Course course;
}
