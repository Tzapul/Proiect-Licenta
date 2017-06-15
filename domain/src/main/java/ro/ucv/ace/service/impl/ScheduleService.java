package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.repository.IScheduleRepository;
import ro.ucv.ace.service.IScheduleService;

/**
 * Created by tzapt on 6/15/2017.
 */
@Service("scheduleService")
@Transactional(rollbackFor = Exception.class)
public class ScheduleService implements IScheduleService {

    @Autowired
    private IScheduleRepository scheduleRepository;


}
