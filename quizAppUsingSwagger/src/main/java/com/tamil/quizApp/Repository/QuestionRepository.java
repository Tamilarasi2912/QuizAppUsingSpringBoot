package com.tamil.quizApp.Repository;

import com.tamil.quizApp.Model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query(value = "select * from questiondb",nativeQuery = true)
    Page<Map<String, Object>> getAllQuestions(Pageable pageable,@Param("search") String search);

    @Query(value="select * from questiondb  where category =:category",nativeQuery = true)
    Page<Map<String, Object>> getByCategory(Pageable pageable, @Param("category") String category);

    @Query(value ="select * from questiondb q where q.category=:category ORDER BY NEWID()",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category);

    @Query(value = "select id,question_title,option_a,option_b,option_c,option_d from questiondb",nativeQuery=true)
    Page<Map<String, Object>> getQuizQuestions(Pageable pageable,@Param("search") String search);
}
