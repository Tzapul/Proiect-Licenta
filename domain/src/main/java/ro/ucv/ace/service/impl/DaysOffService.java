package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.repository.IDaysOffRepository;
import ro.ucv.ace.service.IDaysOffService;

/**
 * Created by tzapt on 6/15/2017.
 */
@Service("daysOffService")
@Transactional(rollbackFor = Exception.class)
public class DaysOffService implements IDaysOffService {

    @Autowired
    private IDaysOffRepository daysOffRepository;


}
