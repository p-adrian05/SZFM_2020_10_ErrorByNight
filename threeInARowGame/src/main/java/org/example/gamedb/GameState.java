package org.example.gamedb;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GameState {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "redPlayerName")
    private String redPlayerName;

    /**
     * The name of the blue player.
     */
    @Column(nullable = false, name = "bluePlayerName")
    private String bluePlayerName;

    /**
     * String that represents the unfinished game state.
     */
    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private ZonedDateTime created;

    @PrePersist
    protected void onPersist() {
        created = ZonedDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRedPlayerName(String redPlayerName) {
        this.redPlayerName = redPlayerName;
    }

    public void setBluePlayerName(String bluePlayerName) {
        this.bluePlayerName = bluePlayerName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }
}
