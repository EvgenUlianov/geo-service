package ru.netology.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GeoServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("testIp")
    void byIpTest(String ip, Country country) {

        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        assertThat(geoService.byIp(ip).getCountry(), is(country));
    }

    static Stream<Arguments> testIp() {
        return Stream.of(
                arguments("172.", Country.RUSSIA),
                arguments("96.",Country.USA)
        );
    }
    @Test
    void byCoordinates() {
    }
}