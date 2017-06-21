package ro.ucv.ace.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.service.IRegisterService;

/**
 * Created by tzapt on 6/20/2017.
 */
@Service("registerService")
@Transactional(rollbackFor = Exception.class)
public class RegisterService implements IRegisterService {


}
