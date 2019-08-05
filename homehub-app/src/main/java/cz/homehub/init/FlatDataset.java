package cz.homehub.init;

import cz.homehub.api.FlatType;
import cz.homehub.entity.Flat;
import cz.homehub.repository.FlatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FlatDataset implements Dataset {

    private static final String HOUSE_NUMBER_03 = "408/3";
    private static final String HOUSE_NUMBER_04 = "408/4";

    @Autowired
    private FlatDao flatDao;

    @Override
    public void load() {
        createFlat(61, 57.7, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(62, 57.7, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(63, 65.4, FlatType.THREE_KK, HOUSE_NUMBER_03);
        createFlat(64, 59.3, FlatType.TWO_KK, HOUSE_NUMBER_04);
        createFlat(65, 57.7, FlatType.TWO_KK, HOUSE_NUMBER_04);
        createFlat(66, 90.3, FlatType.FOUR_KK, HOUSE_NUMBER_04);
        createFlat(67, 73.9, FlatType.THREE_KK, HOUSE_NUMBER_03);
        createFlat(68, 57.8, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(69, 54.8, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(70, 59.4, FlatType.TWO_KK, HOUSE_NUMBER_04);
        createFlat(71, 73.9, FlatType.THREE_KK, HOUSE_NUMBER_04);
        createFlat(72, 54.8, FlatType.TWO_KK, HOUSE_NUMBER_04);
        createFlat(73, 55.9, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(74, 57.8, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(75, 54.8, FlatType.TWO_KK, HOUSE_NUMBER_03);
        createFlat(76, 37.1, FlatType.ONE_KK, HOUSE_NUMBER_04);
        createFlat(77, 78.2, FlatType.THREE_KK, HOUSE_NUMBER_04);
        createFlat(78, 54.8, FlatType.TWO_KK, HOUSE_NUMBER_04);

    }

    private void createFlat(Integer number, Double floorSize, FlatType flatType, String houseNumber){
        Flat flat = new Flat();
        flat.setNumber(number);
        flat.setFloorSize(floorSize);
        flat.setFlatType(flatType);
        flat.setHouseNumber(houseNumber);
        flatDao.save(flat);
    }
}
