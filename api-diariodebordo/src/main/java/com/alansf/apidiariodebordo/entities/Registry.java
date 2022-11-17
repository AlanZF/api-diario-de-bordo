package com.alansf.apidiariodebordo.entities;

import com.alansf.apidiariodebordo.enums.ReadPeriod;
import com.alansf.apidiariodebordo.enums.ReadStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="Registry")
@Getter
@Setter
@SequenceGenerator(name="seq_reg", sequenceName="reg_seq", allocationSize=1)
public class Registry {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_reg")
    private Integer idReg;
    @Column(name="date")
    private Instant date;
    @Column(name="period")
    private Integer period;
    @Column(name="timeEstimated")
    private Instant timeEstimated;
    @Column(name="activity")
    private String activity;
    @Column(name="activityObjective")
    private String activityObjective;
    @Column(name="status")
    private Integer status;

    public Registry() { }

    public Registry(Integer idReg, Instant date, ReadPeriod period, Instant timeEstimated,
                    String activity, String activityObjective, ReadStatus status) {
        this.idReg = idReg;
        this.date = date;
        setPeriod(period);
        this.timeEstimated = timeEstimated;
        this.activity = activity;
        this.activityObjective = activityObjective;
        setStatus(status);
    }

    public ReadPeriod getPeriod() {
        return ReadPeriod.valueOf(this.period);
    }

    public void setPeriod(ReadPeriod period) {
        if(period != null) {
            this.period = period.getCode();
        }
    }

    public ReadStatus getStatus() {
        return ReadStatus.valueOf(this.status);
    }

    public void setStatus(ReadStatus status) {
        if(status != null) {
            this.status = status.getCode();
        }
    }
}

