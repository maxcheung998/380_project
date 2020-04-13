/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.service;

import com.ouhk.webforum.model.Poll;
import com.ouhk.webforum.model.PollVote;
import java.io.IOException;
import java.util.List;

public interface PollService {
    
    public List<Poll> getPolls();
     
    public Poll getPoll(long id);
    
     public List<PollVote> getPollsVoted();
     
    public PollVote getPollVoted(long id);
    
    public List<PollVote> getUserVoted(String username, long id);
    
//     public List<PollVote> getVotedGroup(long pollid);
    public Long getPollVotedCount(long id, String selected);
    
    public Long getPollVotedUser(long id, String username);
    
    public Long getPollVotedTotalCount(long id);
     
    public List<Poll> getLatestPoll();
    
    public long addPoll(String question, String choice_1,
        String choice_2, String choice_3, String choice_4) throws IOException;
    
    public void votePoll(long pollId, String username, String voted)
        throws IOException;
    
    
   
}
