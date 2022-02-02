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

    public List<Apartment> findApartmentByExtras(String ... args) {
        List<String> extraStringList = makeList(args);
        List<Apartment> extraApartment = new ArrayList<>();
//
        for (Apartment apartment : apartments) {
            if (apartment.getExtras().contains(extraStringList.toString())) {
                extraApartment.add(apartment);
            }
        }
        return extraApartment;
    }

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
