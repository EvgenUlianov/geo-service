package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LocalizationServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("testLocale")
    void locale(Country country, String expected) {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        assertThat(localizationService.locale(country), is(expected));
    }


    static Stream<Arguments> testLocale() {
        return Stream.of(
                arguments(Country.RUSSIA, "Добро пожаловать"),
                arguments(Country.USA, "Welcome")
        );
    }

}