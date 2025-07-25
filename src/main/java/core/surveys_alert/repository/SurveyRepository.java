package core.surveys_alert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import core.surveys_alert.domain.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
