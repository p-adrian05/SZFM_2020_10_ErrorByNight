package org.example.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlayerImpl implements Player {

    private String name;
    private Piece pieceColor;

    public PlayerImpl() {
    }
    public PlayerImpl(String name, Piece pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }
}