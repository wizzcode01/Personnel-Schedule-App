package codes;

import java.time.LocalTime;

public class Task {

    private String task;
    private LocalTime alarmTime;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void updateStatus() {
        LocalTime now = LocalTime.now();
        if (alarmTime.equals(now)) {
            status = "it is time...";
        } else if (alarmTime.isAfter(now)) {
            status = "pending";
        } else {
            status = "time passed...";
        }
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
