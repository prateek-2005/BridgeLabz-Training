package com.clinic.dao;

import com.clinic.dto.VisitHistory;

import java.util.List;

public interface VisitHistoryDAO {

    int insertVisitHistory(VisitHistory visitHistory);

    boolean updateVisitHistory(VisitHistory visitHistory);

    boolean deleteVisitHistory(int visitId);

    VisitHistory getVisitHistoryById(int visitId);

    VisitHistory getVisitHistoryByAppointmentId(int appointmentId);

    List<VisitHistory> getAllVisitHistories();

}