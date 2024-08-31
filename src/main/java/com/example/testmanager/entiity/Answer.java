package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="is_correct")
    private boolean isCorrect;

    @Column(name ="answer_text")
    private String answerText;

    @Column(name ="question_id", nullable = false, insertable = false, updatable = false)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


}
