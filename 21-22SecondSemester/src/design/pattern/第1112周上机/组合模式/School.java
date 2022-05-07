package design.pattern.第1112周上机.组合模式;

import java.util.ArrayList;
import java.util.List;

public class School extends AbstractOffice {
    
    private List<AbstractOffice> officeList = new ArrayList<>();
    
    public School(String name) {
        super(name);
    }
    
    @Override
    public void addOffice(AbstractOffice office) {
        officeList.add(office);
    }
    
    @Override
    public void sendDocument() {
        for (AbstractOffice office : officeList) {
            office.sendDocument();
        }
    }
}
