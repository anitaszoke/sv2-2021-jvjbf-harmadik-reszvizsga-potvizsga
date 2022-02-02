package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApartmentRental {

    List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }


    public List<Apartment> findApartmentByLocation(String location) {
        return apartments.stream()
                .filter(apartment -> apartment.getLocation().equals(location))
                .toList();
    }

//    public List<Apartment> findApartmentByExtras(String ... args) {
//        List<String> extrass = makeList(args);
//
//        return apartments.stream()
//
//
//    }

    private List<String> makeList(String ... args) {
        List<String> extra = new ArrayList<>(args.length);
        Collections.addAll(extra, args);
        return extra;
    }


    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType) {
        return apartments.stream()
                .anyMatch(bathRoom -> bathRoom.getBathRoomType().equals(bathRoomType));
    }

    public List<Integer> findApartmentsSize() {
        return apartments.stream()
                .map(Apartment::getSize)
                .toList();
    }
}
