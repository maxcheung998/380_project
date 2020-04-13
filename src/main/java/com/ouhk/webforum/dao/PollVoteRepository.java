/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.dao;

import com.ouhk.webforum.model.PollVote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PollVoteRepository extends JpaRepository<PollVote, Long> {
    
        @Query("select u from PollVote u where u.username = ?1 AND u.pollid = ?2")
        List<PollVote> findVoted(String username, long pollid);
        
//        @Query("select count(u) as count, u.selected from PollVote u where pollid = ?1 group by u.selected")
//        List<PollVote> findVotedCount(long pollid);
        
        Long countByPollidAndSelected(Long pollid, String selected);
        Long countByPollid(Long pollid);
        Long countByPollidAndUsername(Long pollid, String username);

}