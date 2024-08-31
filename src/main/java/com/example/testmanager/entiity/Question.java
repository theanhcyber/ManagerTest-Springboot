package com.example.testmanager.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="question_text",nullable = false)
    private String questionText;

    @Column(name ="topic_id", insertable = false, updatable = false)
    private Long topicId;

    @Column(name ="difficulty")
    private Integer difficulty;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<ExamQuestion> examQuestions;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public void addAnswers(List<Answer> answers) {
        for (var answer: answers ){
            answer.setQuestion(this);
        }
        this.setAnswers(answers);
    }

    public String getTopicCode() {
        return topic.getCode();
    }



}
