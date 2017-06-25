package ro.ucv.ace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ucv.ace.builder.impl.ScheduleDayBuilder;
import ro.ucv.ace.dto.scheduleDay.EScheduleDayDto;
import ro.ucv.ace.dto.scheduleDay.ScheduleDayDto;
import ro.ucv.ace.exception.WrongScheduleInterval;
import ro.ucv.ace.model.ScheduleDay;
import ro.ucv.ace.repository.IScheduleDayRepsitory;
import ro.ucv.ace.service.IScheduleDayService;
import ro.ucv.ace.visitor.ScheduleDayVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzapt on 6/25/2017.
 */
@Service("scheduleDayService")
@Transactional(rollbackFor = Exception.class)
public class ScheduleDayService implements IScheduleDayService {

    @Autowired
    private IScheduleDayRepsitory scheduleDayRepsitory;

    @Autowired
    private ScheduleDayVisitor scheduleDayVisitor;

    @Autowired
    private ScheduleDayBuilder scheduleDayBuilder;

    @Override
    public List<ScheduleDayDto> getAllScheduleDays() {
        List<ScheduleDay> scheduleDays = scheduleDayRepsitory.findAll();
        List<ScheduleDayDto> scheduleDayDtos = new ArrayList<>();

        scheduleDays.forEach(sd -> {
            sd.accept(scheduleDayVisitor);
            scheduleDayDtos.add(scheduleDayVisitor.getScheduleDayDto());
        });

        return scheduleDayDtos;
    }

    @Override
    public ScheduleDayDto save(ScheduleDayDto scheduleDayDto) {

        if (scheduleDayDto.getStart() > scheduleDayDto.getEnd()) {
            throw new WrongScheduleInterval("Start should be lower than end!");
        }

        ScheduleDay scheduleDay = scheduleDayRepsitory.save(scheduleDayBuilder.build(scheduleDayDto));
        scheduleDay.accept(scheduleDayVisitor);
        return scheduleDayVisitor.getScheduleDayDto();
    }

    @Override
    public ScheduleDayDto delete(int id) {
        ScheduleDay scheduleDay = scheduleDayRepsitory.delete(id);
        scheduleDay.accept(scheduleDayVisitor);
        return scheduleDayVisitor.getScheduleDayDto();
    }

    @Override
    public ScheduleDayDto update(EScheduleDayDto scheduleDayDto, int id) {
        ScheduleDay scheduleDay = scheduleDayRepsitory.findOne(id);
        scheduleDay.update(scheduleDayDto.getStart(), scheduleDay.getEnd());

        scheduleDay = scheduleDayRepsitory.save(scheduleDay);
        scheduleDay.accept(scheduleDayVisitor);

        return scheduleDayVisitor.getScheduleDayDto();
    }
}
