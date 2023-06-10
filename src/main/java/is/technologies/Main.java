package is.technologies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Street, House and Flat API", version = "2.0", description = "Information"))
public class Main{
    public static void main(String[] args) {
        /*long startTime1 = System.currentTimeMillis();

        StreetRepositoryHibernate streetRepositoryHibernate = new StreetRepositoryHibernate();
        StreetEntity street1 = new StreetEntity();

        for (int i = 1; i <= 100; i++) {
            street1.setStreetName("Moskovskaya");
            street1.setPostalCode(196124);
            street1.setStreetId(Long.valueOf(i));

            streetRepositoryHibernate.save(street1);
        }

        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();

        StreetRepositoryJDBC streetRepositoryJDBC = new StreetRepositoryJDBC();
        StreetEntity street2 = new StreetEntity();

        for (int i = 101; i <= 200; i++) {
            street2.setStreetName("Moskovskaya");
            street2.setPostalCode(196124);
            street2.setStreetId(Long.valueOf(i));

            streetRepositoryJDBC.save(street2);
        }

        long endTime2 = System.currentTimeMillis();

        long startTime3 = System.currentTimeMillis();

        StreetRepositoryMyBatis streetRepositoryMyBatis = new StreetRepositoryMyBatis();
        StreetEntity street3 = new StreetEntity();

        for (int i = 201; i <= 300; i++) {
            street3.setStreetName("Moskovskaya");
            street3.setPostalCode(196124);
            street3.setStreetId(Long.valueOf(i));

            streetRepositoryMyBatis.save(street3);
        }

        long endTime3 = System.currentTimeMillis();

        System.out.println("Hibernate add: " + (endTime1 - startTime1) + " milliseconds");
        System.out.println("JDBC add: " + (endTime2 - startTime2) + " milliseconds");
        System.out.println("MyBatis add: " + (endTime3 - startTime3) + " milliseconds\n");

        startTime1 = System.currentTimeMillis();
        List<StreetEntity> list1 = streetRepositoryHibernate.getAll();
        endTime1 = System.currentTimeMillis();

        startTime2 = System.currentTimeMillis();
        List<StreetEntity> list2 = streetRepositoryJDBC.getAll();
        endTime2 = System.currentTimeMillis();

        startTime3 = System.currentTimeMillis();
        List<StreetEntity> list3 = streetRepositoryMyBatis.getAll();
        endTime3 = System.currentTimeMillis();

        System.out.println("Hibernate get all: " + (endTime1 - startTime1) + " milliseconds");
        System.out.println("JDBC get all: " + (endTime2 - startTime2) + " milliseconds");
        System.out.println("MyBatis get all: " + (endTime3 - startTime3) + " milliseconds");

        streetRepositoryJDBC.deleteAll();*/

        /*StreetRepositoryJDBC streetRepositoryJDBC = new StreetRepositoryJDBC();

        HouseEntity entity = new HouseEntity();

        entity.setHouseType("гараж");
        entity.setNumberOfFloors(15);
        entity.setHouseName("Hello");
        entity.setHouseId(1);
        entity.setDateOfConstruction(new Date(2011,5,3));
        entity.setStreet(streetRepositoryJDBC.getById(1));

        HouseRepositoryMyBatis repositoryMyBatis = new HouseRepositoryMyBatis();

        System.out.println(repositoryMyBatis.getById(1).getStreet().getStreetName());*/


        /*AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        HouseRepository houseRepository = applicationContext.getBean(HouseRepository.class);

        StreetEntity street1 = new StreetEntity();

        street1.setStreetName("HeheHaha");
        street1.setPostalCode(196124);
        street1.setStreetId(Long.valueOf(3));

        Optional<HouseEntity> house = houseRepository.findById(1L);
        System.out.println(house.get().getStreet().getStreetName());*/
        //streetRepository.delete();

        /*HouseRepository houseRepository = applicationContext.getBean(HouseRepository.class);

        HouseEntity house = new HouseEntity();

        house.setStreet(street1);
        house.setHouseType("гараж");
        house.setHouseName("Dom");
        house.setHouseId(Long.valueOf(2));
        house.setDateOfConstruction(new Date(2011,05,3));
        house.setNumberOfFloors(15);

        System.out.println(streetRepository.getAllByVId(1));*/

        SpringApplication.run(Main.class, args);
    }
}