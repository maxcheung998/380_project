/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.service;

import com.ouhk.webforum.dao.PollRepository;
import com.ouhk.webforum.dao.PollVoteRepository;
import com.ouhk.webforum.model.Poll;
import com.ouhk.webforum.model.PollVote;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PollServiceImpl implements PollService {

    @Resource
    private PollRepository pollRepo;

    @Resource
    private PollVoteRepository pollvoteRepo;

    @Override
    @Transactional
    public List<Poll> getPolls() {
        return pollRepo.findAll();
    }

    @Override
    @Transactional
    public Poll getPoll(long id) {
        return pollRepo.findOne(id);
    }

    @Override
    @Transactional
    public List<PollVote> getPollsVoted() {
        return pollvoteRepo.findAll();
    }

    @Override
    @Transactional
    public PollVote getPollVoted(long id) {
        return pollvoteRepo.findOne(id);
    }

    @Override
    @Transactional
    public List<PollVote> getUserVoted(String username, long id) {
        return pollvoteRepo.findVoted(username, id);
    }

    @Override
    @Transactional
    public List<Poll> getLatestPoll() {
        return pollRepo.findLatestPoll();
    }

    @Override
    @Transactional
    public Long getPollVotedCount(long pollid, String selected) {
        return pollvoteRepo.countByPollidAndSelected(pollid, selected);
    }

    @Override
    @Transactional
    public Long getPollVotedTotalCount(long pollid) {
        return pollvoteRepo.countByPollid(pollid);
    }
    
    @Override
    @Transactional
    public Long getPollVotedUser(long pollid, String username) {
        return pollvoteRepo.countByPollidAndUsername(pollid,username);
    }

//    @Override
//    @Transactional
//    public List<PollVote> getVotedGroup(long pollid) {
//        return pollvoteRepo.findVotedCount(pollid);
//    }
    
    @Override
    @Transactional
    public long addPoll(String question, String choice_1,
            String choice_2, String choice_3, String choice_4) throws IOException {
        Poll poll = new Poll();
        poll.setQuestion(question);
        poll.setChoice_1(choice_1);
        poll.setChoice_2(choice_2);
        poll.setChoice_3(choice_3);
        poll.setChoice_4(choice_4);

        Poll savedPoll = pollRepo.save(poll);
        return savedPoll.getId();
    }

    public void votePoll(long pollId, String username, String voted)
            throws IOException {
        PollVote vote = new PollVote();
        vote.setPollid(pollId);
        vote.setUsername(username);
        vote.setSelected(voted);
        pollvoteRepo.save(vote);
    }

}
