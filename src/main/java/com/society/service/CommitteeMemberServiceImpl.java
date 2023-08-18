package com.society.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.society.dto.CommitteeMemberDTO;
import com.society.entity.CommitteeMember;
import com.society.entity.CurrentUserSession;
import com.society.exception.LoginException;
import com.society.exception.NotFoundException;
import com.society.repository.CommitteeMemberRepository;
import com.society.repository.CurrentUserSessionRepository;

@Service
public class CommitteeMemberServiceImpl implements CommitteeMemberService {

    private final CommitteeMemberRepository committeeMemberRepository;
    private final CurrentUserSessionRepository currSession;

    public CommitteeMemberServiceImpl(CommitteeMemberRepository committeeMemberRepository,
                                      CurrentUserSessionRepository currSession) {
        this.committeeMemberRepository = committeeMemberRepository;
        this.currSession = currSession;
    }

    @Override
    public void registerCommitteeMember(CommitteeMemberDTO committeeMemberDTO) {
     	
        CommitteeMember committeeMember = new CommitteeMember();
        committeeMember.setEmail(committeeMemberDTO.getEmail());
        committeeMember.setfName(committeeMemberDTO.getfName());
        committeeMember.setmInit(committeeMemberDTO.getmInit());
        committeeMember.setlName(committeeMemberDTO.getlName());
        committeeMember.setWingNo(committeeMemberDTO.getWingNo());
        committeeMember.setFlatNo(committeeMemberDTO.getFlatNo());
        committeeMember.setFloorNo(committeeMemberDTO.getFloorNo());
        committeeMember.setMemberCount(committeeMemberDTO.getMemberCount());
        committeeMember.setPassword(committeeMemberDTO.getPassword());

        committeeMemberRepository.save(committeeMember);
    }

    @Override
    public void updateCommitteeMember(String key, Long aId, CommitteeMemberDTO committeeMemberDTO) throws LoginException {
        CurrentUserSession currSess = currSession.findByPrivateKey(key);
        if (currSess == null) {
            throw new LoginException("Login required");
        }

        CommitteeMember committeeMember = committeeMemberRepository.findById(aId)
                .orElseThrow(() -> new NotFoundException("Committee Member not found"));

        committeeMember.setEmail(committeeMemberDTO.getEmail()); //email of society will be fixed and will pass from one admin to next admin
        committeeMember.setfName(committeeMemberDTO.getfName());
        committeeMember.setmInit(committeeMemberDTO.getmInit());
        committeeMember.setlName(committeeMemberDTO.getlName());
        committeeMember.setWingNo(committeeMemberDTO.getWingNo());
        committeeMember.setFlatNo(committeeMemberDTO.getFlatNo());
        committeeMember.setFloorNo(committeeMemberDTO.getFloorNo());
        committeeMember.setMemberCount(committeeMemberDTO.getMemberCount());
        committeeMember.setPassword(committeeMemberDTO.getPassword());


        committeeMemberRepository.save(committeeMember);
    }
    
    //newly added 16th august
    @Override
    public CommitteeMemberDTO getMyProfile(String key) throws LoginException {
    	CurrentUserSession currSess = currSession.findByPrivateKey(key);
        if (currSess == null) {
            throw new LoginException("Login required");
        }

        Long committeeMemberId = currSess.getCommitteemember().getaId();

        CommitteeMember committeeMember = committeeMemberRepository.findById(committeeMemberId)
                .orElseThrow(() -> new NotFoundException("Committee Member not found"));

        CommitteeMemberDTO committeeMemberDTO = new CommitteeMemberDTO();
        committeeMemberDTO.setaId(committeeMember.getaId());
        committeeMemberDTO.setEmail(committeeMember.getEmail());
        committeeMemberDTO.setfName(committeeMember.getfName());
        committeeMemberDTO.setmInit(committeeMember.getmInit());
        committeeMemberDTO.setlName(committeeMember.getlName());
        committeeMemberDTO.setPassword(committeeMember.getPassword());
        committeeMemberDTO.setWingNo(committeeMember.getWingNo());
        committeeMemberDTO.setFlatNo(committeeMember.getFlatNo());
        committeeMemberDTO.setFloorNo(committeeMember.getFloorNo());
        committeeMemberDTO.setMemberCount(committeeMember.getMemberCount());

        return committeeMemberDTO;
    }

}
