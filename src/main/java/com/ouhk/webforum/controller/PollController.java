/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ouhk.webforum.controller;

import com.ouhk.webforum.model.Poll;
import com.ouhk.webforum.model.PollVote;
import com.ouhk.webforum.service.PollService;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("poll")
public class PollController {

    @Autowired
    private PollService pollService;

    private Map<Long, Poll> pollDatabase = new Hashtable<>();

    @GetMapping({"", "/list"})
    public String index(ModelMap model) {

        model.addAttribute("pollDatabase", pollService.getLatestPoll());
        return "poll";
    }

    @GetMapping("/view/{pollId}")
    public String viewPoll(@PathVariable("pollId") long pollId, ModelMap model) {
        Poll poll = pollService.getPoll(pollId);
        if (poll == null) {
            return "redirect:/poll";
        }
        HashMap<String, String> hash_map = new HashMap<String, String>();
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
        model.addAttribute("poll", hash_map);
        return "viewpoll";
    }

    @GetMapping({"/addpoll"})
    public ModelAndView addPoll(ModelMap model) {
        return new ModelAndView("addpoll", "pollForm", new PollForm());
    }

    @PostMapping({"/addpoll"})
    public String createPoll(PollForm form, Principal principal) throws IOException {
        long pollId = pollService.addPoll(form.getQuestion(),
                form.getChoice_1(), form.getChoice_2(), form.getChoice_3(), form.getChoice_4());
        return "redirect:/poll";
    }

    @PostMapping({"/votePoll/{pollId}/{choice}"})
    public String votePoll(@PathVariable("pollId") long pollId,
            @PathVariable("choice") String choice, Principal principal) throws IOException {
        pollService.votePoll(pollId, principal.getName(), choice);
        return "redirect:/categories";
    }

    public static class PollForm {

        private String question;
        private String choice_1;
        private String choice_2;
        private String choice_3;
        private String choice_4;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getChoice_1() {
            return choice_1;
        }

        public void setChoice_1(String choice_1) {
            this.choice_1 = choice_1;
        }

        public String getChoice_2() {
            return choice_2;
        }

        public void setChoice_2(String choice_2) {
            this.choice_2 = choice_2;
        }

        public String getChoice_3() {
            return choice_3;
        }

        public void setChoice_3(String choice_3) {
            this.choice_3 = choice_3;
        }

        public String getChoice_4() {
            return choice_4;
        }

        public void setChoice_4(String choice_4) {
            this.choice_4 = choice_4;
        }

    }

}
