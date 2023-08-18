package com.society.service;

import java.util.List;

import com.society.dto.ComplaintDTO;
import com.society.dto.SuggestionDTO;
import com.society.entity.Complaint;
import com.society.exception.LoginException;

public interface ComplaintService {
    ComplaintDTO registerComplaint(String key,ComplaintDTO complaintDTO) throws LoginException;
    void updateComplaint(String key,Long cid, ComplaintDTO complaintDTO) throws LoginException;
    void deleteComplaint(String key,Long cid) throws LoginException;
    List<ComplaintDTO> getAllComplaints(String key) throws LoginException;
	List<ComplaintDTO> getAllComplaintsOfAllMember(String key) throws LoginException;
    
   
}

