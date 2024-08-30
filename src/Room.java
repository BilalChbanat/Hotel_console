public class Room {
//    private int id;
    private String roomName;
    private int capacity;
    private boolean availability;
    public Room(String roomName, int capacity, boolean availability) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.availability = availability;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
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
