package com.tamil.quizApp.Service;

import com.tamil.quizApp.DTO.DataListDto;
import com.tamil.quizApp.DTO.GlobalResponseDTO;
import com.tamil.quizApp.DTO.QuestionDTO;
import com.tamil.quizApp.Model.Question;
import com.tamil.quizApp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService
{
    @Autowired
    QuestionRepository questionRepository;

@Override
    public DataListDto getAllQuestions(int pageIndex, int pageSize, String search)
{
        DataListDto data =new DataListDto();
        Page<Map<String,Object>> rawResult=null;
        rawResult=questionRepository.getAllQuestions(PageRequest.of(pageIndex,pageSize),search);
        data.setData(rawResult.getContent());
        data.setStatus(true);
        data.setLength((int) rawResult.getTotalElements());
        return data;
    }
    @Override
     public DataListDto getByCategory(int pageIndex, int pageSize, String category) {
        DataListDto data = new DataListDto();
        Page<Map<String,Object>> rawResult=null;
        rawResult=questionRepository.getByCategory(PageRequest.of(pageIndex,pageSize),category);
        data.setData(rawResult.getContent());
        data.setStatus(true);
        data.setLength((int) rawResult.getTotalElements());
        return data;
    }

    @Override
    public GlobalResponseDTO createQuestion(Question question){
    GlobalResponseDTO res = new GlobalResponseDTO();
    questionRepository.save(question);
    res.setMessage("question added successfully");
    res.setData(question);
    res.setStatus(true);
    return res;
    }
    @Override
    public String deleteQuestion(Integer id) {
        if (questionRepository.existsById(id))
        {
            questionRepository.deleteById(id);
            return "Question deleted successfully";
        }
        else
        {
            return "Question not found";
        }
    }

    @Override
    public DataListDto getQuizQuestions(int pageIndex, int pageSize, String search)
    {
        DataListDto data =new DataListDto();
        Page<Map<String,Object>> rawResult=null;
        rawResult=questionRepository.getQuizQuestions(PageRequest.of(pageIndex,pageSize),search);
        data.setData(rawResult.getContent());
        data.setStatus(true);
        data.setLength((int) rawResult.getTotalElements());
        return data;
    }

    @Override
    public Map<Integer, Boolean> checkAnswers(List<QuestionDTO> questionDTOs) {
        Map<Integer, Boolean> results = new HashMap<>();

        for (QuestionDTO dto : questionDTOs) {
            Integer id = dto.getId();
            String answer = dto.getCorrectAnswer();

            Optional<Question> questionOpt = questionRepository.findById(id);
            if (questionOpt.isPresent()) {
                Question question = questionOpt.get();
                results.put(id, question.getCorrectAnswer().equals(answer));
            } else {
                results.put(id, false);
            }
        }

        return results;
    }
    @Override
    public Integer countCorrectAnswers(List<QuestionDTO> questionDTOs) {
        int correctCount = 0;

        for (QuestionDTO dto : questionDTOs) {
            int id = dto.getId();
            String answer = dto.getCorrectAnswer();
            Optional<Question> questionOpt = questionRepository.findById(id);
            if (questionOpt.isPresent()) {
                Question question = questionOpt.get();
                if (question.getCorrectAnswer().equals(answer)) {
                    correctCount++;
                }
            }
        }
        return correctCount;
    }




}
