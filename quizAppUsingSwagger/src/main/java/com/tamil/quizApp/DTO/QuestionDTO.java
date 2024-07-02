package com.tamil.quizApp.DTO;

import java.util.List;

public class QuestionDTO {

        private Integer Id;
        private String correctAnswer;

        // Getters and setters
        public Integer getId() {
            return Id;
        }

        public void  setId(Integer Id) {
            this.Id = Id;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        private List<QuestionDTO> questionAnswers;

        // Getters and setters
        public List<QuestionDTO> getQuestionAnswers() {
            return questionAnswers;
        }

        public void setQuestionAnswers(List<QuestionDTO> questionAnswers) {
            this.questionAnswers = questionAnswers;
        }
    }


