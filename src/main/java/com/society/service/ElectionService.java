package com.society.service;

import com.society.dto.ElectionPositionDTO;
import com.society.dto.ElectionResultDTO;
import com.society.dto.VotingDTO;
import com.society.entity.ElectionPosition;
import com.society.exception.LoginException;

public interface ElectionService {
	ElectionPosition registerCandidatesForPosition(ElectionPositionDTO electionPosition);

	ElectionPosition updateCandidatesForPosition(ElectionPositionDTO electionPosition);

	void deletePositionDetails(ElectionPositionDTO electionPosition);

	ElectionResultDTO getElectionResultsForPosition(ElectionPositionDTO electionPosition);

	String castVote(VotingDTO voting) throws LoginException;

	ElectionPosition getPositionDetails(String positionName);
}
