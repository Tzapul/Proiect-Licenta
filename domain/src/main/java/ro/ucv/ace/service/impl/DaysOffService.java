package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.impl.DaysOffBuilder;
import ro.ucv.ace.dto.daysOff.DaysOffDto;
import ro.ucv.ace.dto.daysOff.ESDaysOffDto;
import ro.ucv.ace.helper.INotificationSender;
import ro.ucv.ace.model.DaysOff;
import ro.ucv.ace.repository.IDaysOffRepository;
import ro.ucv.ace.service.IDaysOffService;
import ro.ucv.ace.visitor.DaysOffVisitor;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/15/2017.
 */
@Service("daysOffService")
@Transactional(rollbackFor = Exception.class)
public class DaysOffService implements IDaysOffService {

    @Autowired
    private IDaysOffRepository daysOffRepository;

    @Autowired
    private DaysOffVisitor daysOffVisitor;

    @Autowired
    private DaysOffBuilder daysOffBuilder;

    @Autowired
    private INotificationSender notificationSender;

    @Override
    public List<DaysOffDto> getAllDaysOff() {
        List<DaysOff> daysOffs = daysOffRepository.findAll();
        List<DaysOffDto> daysOffDtos = new ArrayList<>();

        daysOffs.forEach(d -> {
            d.accept(daysOffVisitor);
            daysOffDtos.add(daysOffVisitor.getDaysOffDto());
        });

        return daysOffDtos;
    }

    @Override
    public DaysOffDto delete(int id) {
        DaysOff daysOff = daysOffRepository.delete(id);
        daysOff.accept(daysOffVisitor);

        notificationSender.sendNotification(daysOff.getDate());

        return daysOffVisitor.getDaysOffDto();
    }

    @Override
    public DaysOffDto save(ESDaysOffDto daysOffDto) {
        DaysOff daysOff = daysOffRepository.save(daysOffBuilder.build(daysOffDto));
        daysOff.accept(daysOffVisitor);
        return daysOffVisitor.getDaysOffDto();
    }
}
