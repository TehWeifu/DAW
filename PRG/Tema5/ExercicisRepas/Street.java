public class Street {
    private final Building[] arrOfBuildings;

    public Street(final int capacity) {
        arrOfBuildings = new Building[capacity];
    }

    public boolean addBuilding(final Building building) {
        for (int i = 0; i < arrOfBuildings.length; i++) {
            if (arrOfBuildings[i] == null) {
                arrOfBuildings[i] = building;
                return true;
            }
        }
        return false;
    }

    public boolean remplaceBuilding(final Building building, final int position) {
        if (position < 0 || position >= arrOfBuildings.length) {
            return false;
        }

        if (arrOfBuildings[position] instanceof Hotel) {
            Hotel.decreaseCount();
        }

        if (arrOfBuildings[position] instanceof Restaurant) {
            Restaurant.decreaseCount();
        }

        if (arrOfBuildings[position] instanceof Apartment) {
            Apartment.decreaseCount();
        }

        arrOfBuildings[position] = building;
        return true;
    }

    public boolean isFull() {
        for (Building building : arrOfBuildings) {
            if (building == null) return false;
        }
        return true;
    }

    public int findBuildingByID(final int id) {
        for (int i = 0; i < arrOfBuildings.length; i++) {
            if (arrOfBuildings[i].getId() == id) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder tmpBuilder = new StringBuilder();

        for (Building building : arrOfBuildings) {
            if (building != null) {
                tmpBuilder.append(String.format("%s%n%n", building));
            }
        }
        return tmpBuilder.toString();
    }
}
