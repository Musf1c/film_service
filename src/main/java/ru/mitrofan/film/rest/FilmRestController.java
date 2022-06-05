package ru.mitrofan.film.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mitrofan.film.dto.FilmRequestDto;
import ru.mitrofan.film.dto.FilmResponseDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FilmRestController {

    private final OMDbFeignClient omDbFeignClient;
    @Value("${feign.OMDb.apiKey}")
    private String apiKey;

    @GetMapping("/film")
    public FilmResponseDto film(@RequestBody FilmRequestDto requestDto) {
        var result = omDbFeignClient.receiveFilms(requestDto.getFilmId(), null, apiKey);
        log.info("info {}", result);
        return result;
    }
}