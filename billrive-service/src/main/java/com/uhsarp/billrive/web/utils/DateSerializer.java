package com.uhsarp.billrive.web.utils;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * The Class DateSerializer.
 */


public class DateSerializer extends JsonSerializer<DateTime> {
 
    private static final String dateFormat = ("MM/dd/yyyy");
 
    @Override
    public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
 
        String formattedDate = DateTimeFormat.forPattern(dateFormat).print(date);
 
        gen.writeString(formattedDate);
    }
 
}