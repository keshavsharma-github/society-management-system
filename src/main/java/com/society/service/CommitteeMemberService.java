package com.society.service;

import com.society.dto.CommitteeMemberDTO;
import com.society.exception.LoginException;

public interface CommitteeMemberService {
    void registerCommitteeMember(CommitteeMemberDTO committeeMemberDTO);
    void updateCommitteeMember(String key, Long aId, CommitteeMemberDTO committeeMemberDTO) throws LoginException;
	CommitteeMemberDTO getMyProfile(String key) throws LoginException;
}
