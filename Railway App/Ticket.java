public class Ticket {
    private  int ticketId;
    private  User user;
    private Train train;
    private int SeatBooked;
    private static int counter=1001;


    public Ticket( User user, Train train, int seatBooked) {
        this.ticketId =counter++;
        this.user = user;
        this.train = train;
        SeatBooked = seatBooked;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return SeatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        SeatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    @Override
    public String toString() {
        return "Ticket Id:"+ticketId+"| Train:"+train.getName()+"| route:"+train.getSource()+"---> "+train.getDestination()+
                "|Seats:"+SeatBooked+"|Booked by:"+user.getFullname();
    }
}
