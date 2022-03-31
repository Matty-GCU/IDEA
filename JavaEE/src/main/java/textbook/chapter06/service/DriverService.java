package textbook.chapter06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import textbook.chapter06.mapper.DriverMapper;
import textbook.chapter06.po.Driver;

import java.util.List;

@Service
@Transactional
public class DriverService {
    
    @Autowired
    DriverMapper driverMapper;
    
    public void test() {
        System.out.println(driverMapper.deleteAllDrivers());
        System.out.println(driverMapper.insertDriver("id001", "name001", 11));
        System.out.println(driverMapper.insertDriver("id002", "name002", 12));
        System.out.println(driverMapper.getDriverById("id001"));
        List<Driver> allDrivers = driverMapper.getAllDrivers();
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }
}
