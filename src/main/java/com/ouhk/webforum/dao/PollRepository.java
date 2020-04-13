
package com.ouhk.webforum.dao;

import com.ouhk.webforum.model.Poll;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PollRepository extends JpaRepository<Poll, Long> {
    
      @Query("select u from Poll u order by id desc")
        List<Poll> findLatestPoll();
}
