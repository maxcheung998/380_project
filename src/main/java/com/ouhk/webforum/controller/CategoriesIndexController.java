/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.controller;

import com.ouhk.webforum.model.Poll;
import com.ouhk.webforum.model.PollVote;
import com.ouhk.webforum.service.PollService;
import java.security.Principal;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categories")
public class CategoriesIndexController {

    @Autowired
    private PollService pollService;

    @GetMapping({""})
    public String index(ModelMap model, Principal principal) {

        HashMap<String, String> hash_map = new HashMap<String, String>();
        if (pollService.getLatestPoll().isEmpty()) {

        } else {
            Poll poll = pollService.getLatestPoll().get(0);
            hash_map.put("id", Long.toString(poll.getId()));
            hash_map.put("question", poll.getQuestion());
            hash_map.put("total_count", Long.toString(pollService.getPollVotedTotalCount(poll.getId())));
            hash_map.put("choice_1", poll.getChoice_1());
            hash_map.put("choice_2", poll.getChoice_2());
            hash_map.put("choice_3", poll.getChoice_3());
            hash_map.put("choice_4", poll.getChoice_4());
            hash_map.put("VotesC1", Long.toString(pollService.getPollVotedCount(poll.getId(), poll.getChoice_1())));
            hash_map.put("VotesC2", Long.toString(pollService.getPollVotedCount(poll.getId(), poll.getChoice_2())));
            hash_map.put("VotesC3", Long.toString(pollService.getPollVotedCount(poll.getId(), poll.getChoice_3())));
            hash_map.put("VotesC4", Long.toString(pollService.getPollVotedCount(poll.getId(), poll.getChoice_4())));
            hash_map.put("UserVoted", "false");
            if (principal != null) {
                hash_map.put("username", principal.getName());
                Long voted = pollService.getPollVotedUser(poll.getId(), principal.getName());
                if (voted == 1){
                    hash_map.put("UserVoted", "true");
                } 
            }
            System.out.println(hash_map);
        }

        model.addAttribute("poll", hash_map);

//        model.addAttribute("voted", pollService.getUserVoted(principal.getName(), pollid));
        return "categories";
    }
}
