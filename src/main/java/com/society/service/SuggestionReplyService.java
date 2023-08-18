package com.society.service;

import java.util.List;

import com.society.dto.SuggestionReplyDTO;
import com.society.exception.LoginException;
import com.society.exception.NotFoundException;

public interface SuggestionReplyService {
    void addSuggestionReply(String key, Long sid, SuggestionReplyDTO suggestionReplyDTO) throws LoginException;
    List<SuggestionReplyDTO> getAllSuggestionReplies(String key) throws LoginException;
    void updateSuggestionReply(String key, Long replyId, SuggestionReplyDTO suggestionReplyDTO) throws LoginException, NotFoundException;
    void deleteSuggestionReply(String key, Long replyId) throws LoginException, NotFoundException;
	List<SuggestionReplyDTO> getSuggestionRepliesForResident(String key) throws LoginException;
}
