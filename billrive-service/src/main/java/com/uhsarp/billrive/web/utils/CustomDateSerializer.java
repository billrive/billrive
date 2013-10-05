/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.web.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
 */
public class CustomDateSerializer extends JsonSerializer<DateTime> {  
    @Override    
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider arg2) throws 
        IOException, JsonProcessingException {      

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        DateTime dateTime = (DateTime) value;
        String formattedDate = formatter.format(value);
        //DateTime expireDate = fmt.parseDateTime(value);
//        String formattedDate = formatter.format(value);

        gen.writeString(formattedDate);

    }

}
