package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "games", schema = "public", catalog = "login")
public class GamesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date_of_game")
    private Object dateOfGame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(Object dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamesEntity that = (GamesEntity) o;

        if (id != that.id) return false;
        if (dateOfGame != null ? !dateOfGame.equals(that.dateOfGame) : that.dateOfGame != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateOfGame != null ? dateOfGame.hashCode() : 0);
        return result;
    }
}
