package design_questions.parking_lot;

import java.util.List;

/**
 * @author shivanidwivedi on 17/04/20
 * @project JavaProgramming
 *
 * TODO: implement another parking lot where S can park in M and L size spaces
 */
public interface ParkingLot {
    Ticket enter(Vehicle v);
    void exit(Ticket ticket);
    List<Space> getAllSpaces();
    List<Space> getAvailableSpaces();
    boolean addSpace(Space space);
}
