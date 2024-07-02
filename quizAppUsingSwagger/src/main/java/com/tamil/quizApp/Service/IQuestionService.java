package com.tamil.quizApp.Service;

import com.tamil.quizApp.DTO.DataListDto;
import com.tamil.quizApp.DTO.GlobalResponseDTO;
import com.tamil.quizApp.DTO.QuestionDTO;
import com.tamil.quizApp.Model.Question;

import java.util.List;
import java.util.Map;


public interface IQuestionService  {


    DataListDto getAllQuestions(int pageIndex, int pageSize, String search);
    DataListDto getByCategory(int pageIndex, int pageSize, String category);
    GlobalResponseDTO createQuestion(Question question);
    String deleteQuestion(Integer id);
    DataListDto getQuizQuestions(int pageIndex, int pageSize, String search);
    Map<Integer, Boolean> checkAnswers(List<QuestionDTO> questionAnswerDTOs);

    Integer countCorrectAnswers(List<QuestionDTO> questionDTOs);
}
