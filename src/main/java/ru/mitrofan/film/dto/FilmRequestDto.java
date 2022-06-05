package ru.mitrofan.film.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FilmRequestDto {

    private String filmId;

    private String language;
}
