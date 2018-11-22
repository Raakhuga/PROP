
package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class GroupSubject {
    private final Subject subject;
    private final Group group;
    
    public GroupSubject(Subject subject, Group group) {
        this.subject = subject;
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public Group getGroup() {
        return group;
    }
}
