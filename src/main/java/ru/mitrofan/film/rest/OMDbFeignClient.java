package ru.mitrofan.film.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mitrofan.film.dto.FilmResponseDto;

@FeignClient(name = "OMDbFeignClient", url = "${feign.OMDb.url}")
public interface OMDbFeignClient {

    @GetMapping("/")
    FilmResponseDto receiveFilms(
            @RequestParam(value = "i") String filmId,
            @RequestParam(value = "y") String year,
            @RequestParam(value = "apikey") String apiKey
    );
}
