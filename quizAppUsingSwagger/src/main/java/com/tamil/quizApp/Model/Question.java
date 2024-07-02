package com.tamil.quizApp.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="questiondb")
@NoArgsConstructor
@JsonIgnoreProperties
@Getter
@Setter
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
   private Integer id;

    @Column(name="question_title")
    private String questionTitle;

    @Column(name="option_a")
    private String optionA;

    @Column(name="option_b")
    private String optionB;

    @Column(name="option_c")
    private String optionC;

    @Column(name="option_d")
    private String optionD;

    @Column(name="category")
    private String category;


    @Column(name="difficulty_level")
    private String difficultyLevel;


    @Column(name="correct_answer")
    private String correctAnswer;


}

