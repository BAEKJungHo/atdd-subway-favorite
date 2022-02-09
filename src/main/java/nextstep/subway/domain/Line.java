package nextstep.subway.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Line extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String color;
    @Embedded
    private Sections sections = new Sections();

    protected Line() {
    }

    public static Line of(
            final String name,
            final String color,
            final Station upStation,
            final Station downStation,
            int distance
    ) {
        Line newLine = new Line(name, color);
        newLine.sections.addFirst(Section.of(newLine, upStation, downStation, distance));
        return newLine;
    }

    public Line(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void update(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void removeSection(Long stationId) {
        this.sections.remove(stationId);
    }

    public List<Station> getStations() {
        return sections.getAllStations();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Sections getSections() {
        return sections;
    }
}
