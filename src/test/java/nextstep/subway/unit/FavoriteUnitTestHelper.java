package nextstep.subway.unit;

import nextstep.subway.domain.Line;
import nextstep.subway.domain.Section;
import nextstep.subway.domain.Station;
import org.springframework.test.util.ReflectionTestUtils;

public final class FavoriteUnitTestHelper {

    private static Line 이호선;
    private static Line 신분당선;
    public static Station 강남역;
    public static Station 역삼역;
    public static Station 판교역;

    public static void createLines() {
        이호선 = new Line("2호선", "bg-green-600");
        신분당선 = new Line("신분당선", "bg-red-600");
    }

    public static void createStations() {
        강남역 = new Station("강남역");
        ReflectionTestUtils.setField(강남역, "id", 1L);
        역삼역 = new Station("역삼역");
        ReflectionTestUtils.setField(역삼역, "id", 2L);
        판교역 = new Station("판교역");
        ReflectionTestUtils.setField(판교역, "id", 3L);
    }

    public static void createSections() {
        이호선.addSection(new Section(이호선, 강남역, 역삼역, 10));
    }
}
