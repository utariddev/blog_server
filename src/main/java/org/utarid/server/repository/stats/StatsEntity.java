package org.utarid.server.repository.stats;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "blog_stats")
public class StatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stats_date")
    private LocalDateTime statsDate;

    @Column(name = "stats_type_id")
    private int statsTypeID;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStatsDate() {
        return statsDate;
    }

    public void setStatsDate(LocalDateTime statsDate) {
        this.statsDate = statsDate;
    }

    public int getStatsTypeID() {
        return statsTypeID;
    }

    public void setStatsTypeID(int statsTypeID) {
        this.statsTypeID = statsTypeID;
    }
}