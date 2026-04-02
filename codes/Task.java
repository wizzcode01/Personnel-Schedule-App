package codes;

import java.time.LocalTime;

public class Task {

    private String task;
    private LocalTime alarmTime;

    public Task(String task, LocalTime alarmTime) {
        this.task = task;
        this.alarmTime = alarmTime;
    }

    public String getTask() {
        return task;
    }

    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    public void setTask(String newTask) {
        this.task = newTask;
    }

    public void setAlarmTime(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String toString() {
        return task + " " + alarmTime;
    }
}
