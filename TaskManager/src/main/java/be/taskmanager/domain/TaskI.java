package be.taskmanager.domain;

import java.time.LocalDateTime;

public interface TaskI {
    String getTitle();

    String getDesc();

    LocalDateTime getDeadline();
}
