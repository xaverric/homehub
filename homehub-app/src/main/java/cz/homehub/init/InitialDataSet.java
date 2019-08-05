package cz.homehub.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitialDataSet {

    @Autowired
    private List<Dataset> datasets;

    public InitializingBean load() {
        datasets.forEach(t -> t.load());

        return null;
    }

}
