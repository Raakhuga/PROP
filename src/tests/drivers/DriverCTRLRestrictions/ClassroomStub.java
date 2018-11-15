/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.drivers.DriverCTRLRestrictions;

import domain.Classroom;
import domain.Timetable;
import java.util.List;

/**
 *
 * @author hasee
 */
public class ClassroomStub {
    Classroom classrooms[];
    
    public ClassroomStub() {
        classrooms = new Classroom[3];
        classrooms[0] = new Classroom(100, "A6001", 5, 8, 20, true, false, false);
        classrooms[1] = new Classroom(100, "A6002", 5, 8, 20, false, true, false);
        classrooms[2] = new Classroom(100, "A6003", 5, 8, 20, false, false, true);
    }

    public Classroom getClassroomiesim(int i) {
        return classrooms[i];
    }

    
}
