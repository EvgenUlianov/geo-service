package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @Test
    void sendRus() {
        GeoService geoServiceRus = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceRus.byIp("RUSSIA"))
                .thenReturn(new Location("", Country.RUSSIA, null, 0));
        //  GeoService geoServiceRus1 = new GeoServiceImpl();


        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("тест");
        //       LocalizationService localizationService1 = new LocalizationServiceImpl();

        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "RUSSIA");
              MessageSender messageSender = new MessageSenderImpl(geoServiceRus, localizationService);
        String message = messageSender.send(map);

        assertThat(messageSender.send(map), is("тест"));

    }

    @Test
    void sendEng() {
        GeoService geoServiceRus = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceRus.byIp("USA"))
                .thenReturn(new Location("", Country.USA, null, 0));
        //  GeoService geoServiceRus1 = new GeoServiceImpl();


        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("test");
        //       LocalizationService localizationService1 = new LocalizationServiceImpl();

        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "USA");
        MessageSender messageSender = new MessageSenderImpl(geoServiceRus, localizationService);
        String message = messageSender.send(map);

        assertThat(messageSender.send(map), is("test"));

    }}