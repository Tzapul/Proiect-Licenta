package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.dto.guest.GuestDto;
import ro.ucv.ace.model.Guest;
import ro.ucv.ace.repository.IGuestRepository;
import ro.ucv.ace.service.IGuestService;

/**
 * Created by itsix on 26/06/2017.
 */
@Service("guestService")
@Transactional(rollbackFor = Exception.class)
public class GuestService implements IGuestService {

    @Autowired
    private IGuestRepository guestRepository;

    @Override
    public GuestDto register() {
        Guest guest = guestRepository.save(new Guest());

        GuestDto guestDto =  new GuestDto(guest.getId());

        return guestDto;
    }
}
