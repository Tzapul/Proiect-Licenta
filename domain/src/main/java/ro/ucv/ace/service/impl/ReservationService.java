package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.repository.IReservationRepository;
import ro.ucv.ace.service.IReservationService;

/**
 * Created by tzapt on 6/15/2017.
 */
@Service("reservationService")
@Transactional(rollbackFor = Exception.class)
public class ReservationService implements IReservationService{

    @Autowired
    private IReservationRepository reservationRepository;


}
