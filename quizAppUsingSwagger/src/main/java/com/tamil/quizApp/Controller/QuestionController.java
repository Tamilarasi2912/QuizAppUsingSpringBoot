package com.tamil.quizApp.Controller;
import com.tamil.quizApp.DTO.DataListDto;
import com.tamil.quizApp.DTO.GlobalResponseDTO;
import com.tamil.quizApp.DTO.QuestionDTO;
import com.tamil.quizApp.Model.Question;
import com.tamil.quizApp.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;

    @GetMapping("all-questions")
    public ResponseEntity<DataListDto> getAllQuestions(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, String search) {
        DataListDto list = iQuestionService.getAllQuestions(pageIndex, pageSize, search);
        return new ResponseEntity<DataListDto>(list, HttpStatus.OK);
    }

    @GetMapping("get-by-category")
    public ResponseEntity<DataListDto> getByCategory(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, @RequestParam("category") String category) {
        {
            DataListDto list = iQuestionService.getByCategory(pageIndex, pageSize, category);
            return new ResponseEntity<DataListDto>(list, HttpStatus.OK);
        }

    }

    @PostMapping("create-question")
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        GlobalResponseDTO res = new GlobalResponseDTO();
        res = iQuestionService.createQuestion(question);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("delete-question/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        return iQuestionService.deleteQuestion(id);
    }

    @GetMapping("get-quiz-questions")
    public ResponseEntity<DataListDto> getQuizQuestions(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, String search) {
        DataListDto list = iQuestionService.getQuizQuestions(pageIndex, pageSize, search);
        return new ResponseEntity<DataListDto>(list, HttpStatus.OK);
    }

    @PostMapping("check-correct-answer")
    public ResponseEntity<Map<Integer, Boolean>> checkAnswers(@RequestBody List<QuestionDTO> questionDTOs) {
        Map<Integer, Boolean> results = iQuestionService.checkAnswers(questionDTOs);
        return ResponseEntity.ok(results);
    }
    @PostMapping("count-correct-answer")
    public ResponseEntity<Integer> countCorrectAnswers(@RequestBody QuestionDTO questionDTO) {
        int correctCount = iQuestionService.countCorrectAnswers(questionDTO.getQuestionAnswers());
        return ResponseEntity.ok(correctCount);
    }

}
