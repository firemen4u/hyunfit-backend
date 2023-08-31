package com.backend.hyunfit.domain.pt.service;

import com.backend.hyunfit.domain.pt.dto.PersonalTrainingDTO;
import com.backend.hyunfit.global.exception.BusinessException;

public interface PersonalTrainingService {

    /**
     * Pt 예약 정보를 생성하는 메서드입니다.
     *
     * @param ptDTO Pt 예약 정보를 생성합니다.
     * @throws BusinessException 예약이 생성되지 않을 때 발생하는 예외입니다.
     *                          이 예외는ErrorCode.DB_QUERY_INSERT_EXCEPTION 에러 코드와 함께 발생합니다.
     */
    void createPt(PersonalTrainingDTO ptDTO);

    /**
     * Pt 예약 정보를 수정하는 메서드입니다.
     *
     * @param ptDTO Pt 예약 정보를 수정합니다.
     * @throws BusinessException 예약이 수정되지 않을 때 발생하는 예외입니다.
     *                          이 예외는ErrorCode.DB_QUERY_UPDATE_EXCEPTION 에러 코드와 함께 발생합니다.
     */
    void modifyPt(PersonalTrainingDTO ptDTO);


    /**
     * Pt 예약 리뷰를 생성하는 메서드입니다.
     *
     * @param ptDTO Pt 예약 리뷰를 생성합니다.
     * @throws BusinessException 예약이 생성되지 않을 때 발생하는 예외입니다.
     *                          이 예외는ErrorCode.DB_QUERY_INSERT_EXCEPTION 에러 코드와 함께 발생합니다.
     */
    void createPtReview(PersonalTrainingDTO ptDTO);


    /**
     * Pt 예약 리뷰를 수정하는 메서드입니다.
     *
     * @param ptSeq Pt 예약 리뷰를 생성합니다.
     * @throws BusinessException 예약이 생성되지 않을 때 발생하는 예외입니다.
     *                          이 예외는ErrorCode.DB_QUERY_INSERT_EXCEPTION 에러 코드와 함께 발생합니다.
     */
    PersonalTrainingDTO selectOnePtBySeq(Long ptSeq);
}
