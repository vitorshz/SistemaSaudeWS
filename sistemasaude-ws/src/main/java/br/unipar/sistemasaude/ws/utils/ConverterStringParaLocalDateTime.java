package br.unipar.sistemasaude.ws.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ConverterStringParaLocalDateTime {
    public static LocalDateTime converterStringParaLocalDateTim(String dataString) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        try {
            return LocalDateTime.parse(dataString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao converter a string para LocalDateTime: Formato inválido.");
            throw new Exception("Erro ao converter a string para LocalDateTime: Formato inválido.");
        }
    }

}
