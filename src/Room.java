public class Room {
//    private int id;
    private int roomNumber;
    private int capacity;
    private boolean availability;
    public Room(int roomNumber, int capacity, boolean availability) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.availability = availability;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setRoomNumber(int roomName){
        this.roomNumber = roomName;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public boolean getAvailability(){
        return this.availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
